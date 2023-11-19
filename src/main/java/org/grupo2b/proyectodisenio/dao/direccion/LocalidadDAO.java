package org.grupo2b.proyectodisenio.dao.direccion;

import org.grupo2b.proyectodisenio.logica.direccion.Localidad;

import java.util.List;

public interface LocalidadDAO {
    /**
     * @param id Id de la provincia
     * @return Lista de localidades en dicha provincia
     */
    List<Localidad> getLocalidadesFromIdProvincia(int id);
}
