package org.grupo2b.proyectodisenio.dao.poliza;

import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.logica.poliza.Poliza;

public class PolizaDAOPSQL implements PolizaDAO{
    @Override
    public void save(Poliza p) {
        DAOManager.save(p);
    }
}
