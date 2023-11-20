package org.grupo2b.proyectodisenio.dao.direccion;

import org.grupo2b.proyectodisenio.logica.direccion.Provincia;

import java.util.List;
import java.util.Optional;

public interface ProvinciaDAO {

    List<Provincia> getProvincias();

    List<String> getStringsProvincias();

    Provincia getFromNombre(String nombre);
    Optional<Provincia> getProvincia(int id);
}
