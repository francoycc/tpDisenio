package org.grupo2b.proyectodisenio.dao.cliente;

import org.grupo2b.proyectodisenio.logica.cliente.EstadoCivil;

import java.util.List;
import java.util.Optional;

public interface EstadoCivilDAO {
    List<EstadoCivil> getEstadosCiviles();
    List<String> getStringEstadosCiviles();
    Optional<EstadoCivil> get(String id);
}
