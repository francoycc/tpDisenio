package org.grupo2b.proyectodisenio.dao.vehiculo;

import org.grupo2b.proyectodisenio.logica.vehiculo.Marca;
import org.grupo2b.proyectodisenio.logica.vehiculo.Modelo;

import java.util.List;

public interface ModeloDAO {
    List<Modelo> getModelos();
    List<Modelo> getModelosFromMarca(Marca m);
}
