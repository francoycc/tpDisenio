package org.grupo2b.proyectodisenio.dao.pagos;

import org.grupo2b.proyectodisenio.logica.pagos.Cuota;

import java.util.List;

public interface CuotaDAO {
    boolean tieneCuotasImpagas(String nroCliente);
}
