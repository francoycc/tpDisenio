package org.grupo2b.proyectodisenio.dao.poliza;

import org.grupo2b.proyectodisenio.logica.poliza.EstadoCivil;

import java.util.List;

public interface EstadoCivilDAO {
    List<EstadoCivil> getEstadosCiviles();
    List<String> getStringEstadosCiviles();
}
