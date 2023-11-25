package org.grupo2b.proyectodisenio.logica.poliza;

import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.dto.NumeroSiniestrosDTO;
import org.grupo2b.proyectodisenio.dto.PolizaDTO;
import org.grupo2b.proyectodisenio.dto.TipoCoberturaDTO;
import org.grupo2b.proyectodisenio.dto.VehiculoDTO;
import org.grupo2b.proyectodisenio.logica.vehiculo.GestorVehiculos;
import org.grupo2b.proyectodisenio.logica.vehiculo.Vehiculo;

import java.util.List;
import java.util.stream.Collectors;

public class GestorPolizas {

    public static boolean darAltaPoliza(PolizaDTO polizaDTO){
        VehiculoDTO vDTO = polizaDTO.vehiculo();
        if(GestorVehiculos.existeVehiculoAsociado(vDTO.patente(), vDTO.motor(), vDTO.chasis()))
            return false;
        //TODO QUE PASA SI YA EXISTE UN VEHICULO PERO NO ESTA ASOCIADO?? QUE PASA SI SON LOS VEHICULOS TIENEN DIFERENCIAS EN LOS DATOS?? SE ACTUALIZA? TIRA ERROR?
        Gestor

        Vehiculo vehiculo = new Vehiculo(sumaAsegurada, vDTO.motor(), vDTO.chasis(), vDTO.patente(), );


        Poliza p = new Poliza(polizaDTO.fechaInicioVigencia(), polizaDTO.fechaFinalVigencia(), polizaDTO.fechaEmision(), polizaDTO.formaPago(), polizaDTO.estadoPoliza(),
                premio, derechoEmision,  descuento, polizaDTO.idTipoCobertura(), cuotas,
                medidasDeSeguridad, vehiculo, declaracionesHijos,  cliente,  nroSiniestros);

        DAOManager.polizaDAO().save(p);

    }





    public static List<NumeroSiniestrosDTO> getNumeroSiniestrosList(){
        return DAOManager.numeroSiniestrosDAO().getNumeroSiniestrosList().stream().map(o -> new NumeroSiniestrosDTO(o.getId(), o.getCantSiniestrosInicial(), o.getCantSiniestrosFinal())).collect(Collectors.toList());
    }




    public static List<TipoCoberturaDTO> getTiposCobertura(){
        return DAOManager.tipoCoberturaDAO().getTiposCobertura().stream().map(o -> new TipoCoberturaDTO(o.getId(), o.getNombre(), o.getDescripcion(), o.getMaxAniosVehiculo())).collect(Collectors.toList());
    }
}
