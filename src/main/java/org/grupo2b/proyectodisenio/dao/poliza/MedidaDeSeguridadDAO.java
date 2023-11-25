package org.grupo2b.proyectodisenio.dao.poliza;

import org.grupo2b.proyectodisenio.logica.vehiculo.MedidaDeSeguridad;

import java.util.List;
import java.util.Optional;

public interface MedidaDeSeguridadDAO {
    List<MedidaDeSeguridad> getTiposCobertura();
    Optional<MedidaDeSeguridad> getTipoCobertura(String nombre);
}
