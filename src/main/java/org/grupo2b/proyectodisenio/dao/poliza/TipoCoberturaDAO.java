package org.grupo2b.proyectodisenio.dao.poliza;

import org.grupo2b.proyectodisenio.logica.poliza.TipoCobertura;

import java.util.List;
import java.util.Optional;

public interface TipoCoberturaDAO {
    List<TipoCobertura> getTiposCobertura();
    Optional<TipoCobertura> get(int id);
}
