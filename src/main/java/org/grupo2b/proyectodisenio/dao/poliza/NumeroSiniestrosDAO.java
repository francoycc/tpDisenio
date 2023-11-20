package org.grupo2b.proyectodisenio.dao.poliza;

import org.grupo2b.proyectodisenio.logica.poliza.NumeroSiniestros;

import java.util.List;
import java.util.Optional;

public interface NumeroSiniestrosDAO {
    List<NumeroSiniestros> getNumeroSiniestrosList();
    Optional<NumeroSiniestros> getNumeroSiniestros(int minimo, int maximo);
}
