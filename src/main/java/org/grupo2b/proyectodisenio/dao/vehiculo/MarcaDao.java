package org.grupo2b.proyectodisenio.dao.vehiculo;

import org.grupo2b.proyectodisenio.logica.vehiculo.Marca;

import java.util.List;

public interface MarcaDao {
    List<Marca> getMarcas();
    List<String> getStringsMarcas();
}
