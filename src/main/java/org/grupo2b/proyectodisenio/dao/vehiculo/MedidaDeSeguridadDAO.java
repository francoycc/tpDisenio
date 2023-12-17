package org.grupo2b.proyectodisenio.dao.vehiculo;

import org.grupo2b.proyectodisenio.logica.vehiculo.MedidaDeSeguridad;

import java.util.List;
import java.util.Optional;

public interface MedidaDeSeguridadDAO {
    List<MedidaDeSeguridad> getTiposCobertura();
    Optional<MedidaDeSeguridad> getTipoCobertura(String nombre);
    Optional<MedidaDeSeguridad> getTipoCobertura(int id);
}
