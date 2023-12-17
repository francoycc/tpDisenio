package org.grupo2b.proyectodisenio.dao.poliza;

import org.grupo2b.proyectodisenio.logica.poliza.Poliza;
import org.grupo2b.proyectodisenio.logica.pagos.Cuota;
import java.util.Optional;

public interface PolizaDAO {
    boolean save(Poliza p);

    Optional<Poliza> buscarPoliza(String nroPoliza);

   // Optional List<Cuota> getCuotasImpagas(String nroPoliza);

}
