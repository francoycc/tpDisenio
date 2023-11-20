package org.grupo2b.proyectodisenio.dao.vehiculo;

import org.grupo2b.proyectodisenio.logica.vehiculo.Vehiculo;

import java.util.Optional;

public interface VehiculoDAO {
    Optional<Vehiculo> getVehiculoFromPatente(String patente);
    Optional<Vehiculo> getVehiculoFromMotor(String motor);
    Optional<Vehiculo> getVehiculoFromChasis(String chasis);
    boolean existeVehiculoAsociado(String patente, String motor, String chasis);
}
