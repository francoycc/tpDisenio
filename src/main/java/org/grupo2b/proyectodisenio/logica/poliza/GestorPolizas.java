package org.grupo2b.proyectodisenio.logica.poliza;

import org.grupo2b.proyectodisenio.carga_datos.Objetos;
import org.grupo2b.proyectodisenio.dao.DAO;
import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.dto.*;
import org.grupo2b.proyectodisenio.logica.cliente.Cliente;
import org.grupo2b.proyectodisenio.logica.cliente.EstadoCivil;
import org.grupo2b.proyectodisenio.logica.cuentas.GestorCuentas;
import org.grupo2b.proyectodisenio.logica.direccion.GestorUbicaciones;
import org.grupo2b.proyectodisenio.logica.direccion.Localidad;
import org.grupo2b.proyectodisenio.logica.enums.EstadoCuota;
import org.grupo2b.proyectodisenio.logica.enums.EstadoPoliza;
import org.grupo2b.proyectodisenio.logica.pagos.Cuota;
import org.grupo2b.proyectodisenio.logica.vehiculo.*;
import org.grupo2b.proyectodisenio.subsistemas.SubsistemaSumaAsegurada;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GestorPolizas {

    public static boolean darAltaPoliza(PolizaDTO polizaDTO){
        System.out.println("AAAAAAAAAAAA");
        //TODO HARDCODEADOS POR CU16
        final int PREMIO=1000;
        final DerechoEmision derechoEmision=new DerechoEmision(Objetos.getHistorial(GestorCuentas.getCuentaActiva()));
        final Descuento descuento=new Descuento("Ejemplo", Objetos.getHistorial(GestorCuentas.getCuentaActiva()));

        Vehiculo vehiculo;
        try {
            vehiculo = dtoAVehiculo(polizaDTO.vehiculo());
        }catch (IllegalArgumentException e){
            return false;
        }

        NumeroSiniestros numeroSiniestros = null;
        List<MedidaDeSeguridad> medidasDeSeguridad = new ArrayList<>();
        List<Cuota> cuotas = new ArrayList<>();
        TipoCobertura tipoCobertura = null;
        LocalDate fechaInicio = polizaDTO.fechaInicioVigencia();
        LocalDate fechaFinal = polizaDTO.fechaFinalVigencia();
        List<DeclaracionHijo> declaracionesHijos = new ArrayList<>();
        Cliente cliente = null;

        {//VALIDACIONES
            Optional<TipoCobertura> tipoCoberturaOpt = DAOManager.tipoCoberturaDAO().get(polizaDTO.idTipoCobertura());
            if (tipoCoberturaOpt.isEmpty()) return false;
            tipoCobertura = tipoCoberturaOpt.get();

            if((LocalDate.now().getYear()-vehiculo.getAnioFabricacion().getAnioModelo())>tipoCobertura.maxAniosVehiculo) return false;

            Optional<NumeroSiniestros> numeroSiniestrosOpt = DAOManager.numeroSiniestrosDAO().get(polizaDTO.id_nroSiniestros());
            if(numeroSiniestrosOpt.isEmpty()) return false;
            numeroSiniestros = numeroSiniestrosOpt.get();

            for(String medidaSeguridad : polizaDTO.idsMedidasSeguridad()){
                Optional<MedidaDeSeguridad> medida = DAOManager.medidaDeSeguridadDAO().getTipoCobertura(medidaSeguridad);
                if(medida.isEmpty()) return false;
                medidasDeSeguridad.add(medida.get());
            }

            if(fechaInicio.isBefore(LocalDate.now()) || fechaInicio.isAfter(LocalDate.now().plusMonths(1))) return false;

            if(!fechaFinal.isEqual(fechaInicio.plusMonths(6))) return false;

            switch (polizaDTO.formaPago()){
                case MENSUAL:
                    for (int i=0;i<6;i++)
                        cuotas.add(new Cuota(fechaInicio.minusDays(1).plusMonths(i+1), PREMIO, EstadoCuota.PENDIENTE, 0, 0, null));
                break;
                case SEMESTRAL:
                    cuotas.add(new Cuota(fechaFinal.minusDays(1), PREMIO, EstadoCuota.PENDIENTE, 0, 0, null));
                break;
                default:
                    return false;
            }

            for(DeclaracionHijoDTO d : polizaDTO.declaracionesHijos()){
                if(d.fechaNacimiento().isAfter(LocalDate.now().minusYears(18))||d.fechaNacimiento().isBefore(LocalDate.now().minusYears(30)))
                    return false;
                if(d.sexo()==null) return false;
                Optional<EstadoCivil> estadoCivil = DAOManager.estadoCivilDAO().get(d.id_estadoCivil());
                if(estadoCivil.isEmpty()) return false;

                declaracionesHijos.add(new DeclaracionHijo(d.fechaNacimiento(), d.sexo(), estadoCivil.get()));
            }

            Optional<Cliente> clienteOpt = DAOManager.clienteDAO().get(polizaDTO.id_cliente());
            if(clienteOpt.isEmpty()) return false;
            cliente = clienteOpt.get();
        }


        cliente.getVehiculos().add(vehiculo);
        Poliza p = new Poliza(polizaDTO.fechaInicioVigencia(), polizaDTO.fechaFinalVigencia(), LocalDate.now(), polizaDTO.formaPago(), EstadoPoliza.GENERADA,
                PREMIO, derechoEmision,  descuento, tipoCobertura, cuotas,
                medidasDeSeguridad, vehiculo, declaracionesHijos,  cliente,  numeroSiniestros);

        return DAOManager.polizaDAO().save(p);
    }

    private static Vehiculo dtoAVehiculo(VehiculoDTO vDTO){
        Localidad domicilioRiesgo = null;
        AnioFabricacion anioFabricacion = null;
        Modelo modelo = null;
        KmPorAnio kmPorAnio = null;


        if(GestorVehiculos.existeVehiculoAsociado(vDTO.patente(), vDTO.motor(), vDTO.chasis()))
            throw new IllegalArgumentException();//TODO QUE PASA SI YA EXISTE UN VEHICULO PERO NO ESTA ASOCIADO?? QUE PASA SI SON LOS VEHICULOS TIENEN DIFERENCIAS EN LOS DATOS?? SE ACTUALIZA? TIRA ERROR?
        {
            Optional<Localidad> domicilioRiesgoOpt = DAOManager.localidadDAO().getLocalidad(vDTO.id_localidad());
            if (domicilioRiesgoOpt.isEmpty()) throw new IllegalArgumentException();
            domicilioRiesgo = domicilioRiesgoOpt.get();

            Optional<Modelo> modeloOpt = DAOManager.modeloDAO().get(vDTO.id_modelo());
            if (modeloOpt.isEmpty()) throw new IllegalArgumentException();
            modelo = modeloOpt.get();

            for(AnioFabricacion a : modelo.getAniosFabricacion())
                if(a.getAnioModelo() == vDTO.id_anioFabricacion())
                    anioFabricacion = a;
            if(anioFabricacion==null) throw new IllegalArgumentException();

            Optional<KmPorAnio> kmPorAnioOpt = DAOManager.kmPorAnioDAO().get(vDTO.id_kmPorAnio());
            if(kmPorAnioOpt.isEmpty()) throw new IllegalArgumentException();
            kmPorAnio=kmPorAnioOpt.get();

            //TODO VALIDAR PATENTE, MOTOR, CHASIS de vDTO
        }

        return new Vehiculo(SubsistemaSumaAsegurada.getSumaAsegurada(modelo.getId(), anioFabricacion.getAnioModelo()), vDTO.motor(), vDTO.chasis(), vDTO.patente(), modelo, anioFabricacion, kmPorAnio, domicilioRiesgo);

    }





    public static List<NumeroSiniestrosDTO> getNumeroSiniestrosList(){
        return DAOManager.numeroSiniestrosDAO().getNumeroSiniestrosList().stream().map(o -> new NumeroSiniestrosDTO(o.getId(), o.getCantSiniestrosInicial(), o.getCantSiniestrosFinal())).collect(Collectors.toList());
    }




    public static List<TipoCoberturaDTO> getTiposCobertura(){
        return DAOManager.tipoCoberturaDAO().getTiposCobertura().stream().map(o -> new TipoCoberturaDTO(o.getId(), o.getNombre(), o.getDescripcion(), o.getMaxAniosVehiculo())).collect(Collectors.toList());
    }
}
