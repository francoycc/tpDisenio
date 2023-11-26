package org.grupo2b.proyectodisenio.dao.vehiculo;

import org.grupo2b.proyectodisenio.logica.vehiculo.Marca;
import org.grupo2b.proyectodisenio.logica.vehiculo.Modelo;

import java.util.List;
import java.util.Optional;

public interface ModeloDAO {
    List<Modelo> getModelos();
    Optional<Modelo> get(int id);
    List<Modelo> getModelosFromMarca(Marca m);
    List<Modelo> getModelosFromIdMarca(int id);
    List<Modelo> getModelosFromMarca(Marca m, int pageSize, int pageNumber);
}
