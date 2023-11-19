package org.grupo2b.proyectodisenio.dao.direccion;

import org.grupo2b.proyectodisenio.logica.direccion.Pais;

import java.util.List;

public interface PaisDAO {

    /**
     *
     * @return lista de todos los paises
     */
    List<Pais> getPaises();
}
