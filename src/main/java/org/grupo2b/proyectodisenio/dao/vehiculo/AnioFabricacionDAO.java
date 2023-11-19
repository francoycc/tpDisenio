package org.grupo2b.proyectodisenio.dao.vehiculo;

import org.grupo2b.proyectodisenio.logica.vehiculo.AnioFabricacion;
import org.grupo2b.proyectodisenio.logica.vehiculo.Modelo;

import java.util.List;

public interface AnioFabricacionDAO {
    List<AnioFabricacion> getAnioFromModelo(Modelo m);
}
