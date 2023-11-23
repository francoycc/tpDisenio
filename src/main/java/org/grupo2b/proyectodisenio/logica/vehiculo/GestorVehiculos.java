package org.grupo2b.proyectodisenio.logica.vehiculo;

import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.logica.Cliente;

import java.util.Optional;

public class GestorVehiculos {

    public static boolean existeVehiculoAsociado(String patente, String motor, String chasis){
        return DAOManager.vehiculoDAO().existeVehiculoAsociado(patente, motor, chasis);
    }

    public static Optional<Vehiculo> getVehiculoFromPatente(String patente){
        return DAOManager.vehiculoDAO().getVehiculoFromPatente(patente);
    }

    /*public static void darAltaVehiculo(Vehiculo vehiculo, Cliente cliente){
        cliente.getVehiculos().add(vehiculo);
        DAOManager.vehiculoDAO().guardar(vehiculo);
    }*/

}

