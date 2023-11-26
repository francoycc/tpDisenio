package org.grupo2b.proyectodisenio.dao.vehiculo;

import org.grupo2b.proyectodisenio.logica.vehiculo.KmPorAnio;

import java.util.Optional;

public interface KmPorAnioDAO {
    Optional<KmPorAnio> getFromNumero(int km);
    Optional<KmPorAnio> get(int id);
}
