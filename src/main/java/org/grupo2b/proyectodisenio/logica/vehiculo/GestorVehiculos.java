package org.grupo2b.proyectodisenio.logica.vehiculo;

import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.dto.KmPorAnioDTO;
import org.grupo2b.proyectodisenio.dto.MarcaDTO;
import org.grupo2b.proyectodisenio.dto.ModeloDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GestorVehiculos {

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
    public static List<Modelo> getModelosFromMarca(Marca marca, int pageSize, int pageNumber){
        return DAOManager.modeloDAO().getModelosFromMarca(marca);
    }




    public static Optional<KmPorAnioDTO> getFromNumero(int km){
        return DAOManager.kmPorAnioDAO().getFromNumero(km).map(o -> new KmPorAnioDTO(o.getId(), o.getKmRealizadosInicial(), o.getKmRealizadosInicial()));
    }





    public static Optional<MedidaDeSeguridad> obtenerFromNombre(String nombre){
        return DAOManager.medidaDeSeguridadDAO().getTipoCobertura(nombre);
    }
    /*public static void darAltaVehiculo(Vehiculo vehiculo, Cliente cliente){
        cliente.getVehiculos().add(vehiculo);
        DAOManager.vehiculoDAO().guardar(vehiculo);
    }*/

}

