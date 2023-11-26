package org.grupo2b.proyectodisenio.logica.vehiculo;

import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.dto.KmPorAnioDTO;
import org.grupo2b.proyectodisenio.dto.MarcaDTO;
import org.grupo2b.proyectodisenio.dto.ModeloDTO;
import org.grupo2b.proyectodisenio.dto.VehiculoDTO;
import org.grupo2b.proyectodisenio.logica.direccion.Localidad;
import org.grupo2b.proyectodisenio.subsistemas.SubsistemaSumaAsegurada;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GestorVehiculos {

    public static Vehiculo dtoAVehiculo(VehiculoDTO vDTO){
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



    public static boolean existeVehiculoAsociado(String patente, String motor, String chasis){
        return DAOManager.vehiculoDAO().existeVehiculoAsociado(patente, motor, chasis);
    }

    public static Optional<Vehiculo> getVehiculoFromPatente(String patente){
        return DAOManager.vehiculoDAO().getVehiculoFromPatente(patente);
    }




    public static List<Integer> getAniosFabricacionFromModelo(ModeloDTO m){
        return DAOManager.anioFabricacionDAO().getAniosFromIdModelo(m.id()).stream().map(AnioFabricacion::getAnioModelo).collect(Collectors.toList());
    }
    public static List<MarcaDTO> getMarcas() {
        return DAOManager.marcaDao().getMarcas().stream().map(o -> new MarcaDTO(o.getId(), o.getNombre())).collect(Collectors.toList());
    }
    public static List<ModeloDTO> getModelosFromMarca(MarcaDTO marca){
        return DAOManager.modeloDAO().getModelosFromIdMarca(marca.id()).stream().map(o -> new ModeloDTO(o.getId(), o.getMarca().getId(), o.getNombre())).collect(Collectors.toList());
    }




    public static Optional<KmPorAnioDTO> getFromNumero(int km){
        return DAOManager.kmPorAnioDAO().getFromNumero(km).map(o -> new KmPorAnioDTO(o.getId(), o.getKmRealizadosInicial(), o.getKmRealizadosInicial()));
    }

}

