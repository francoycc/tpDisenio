package org.grupo2b.proyectodisenio.logica.vehiculo;

import org.grupo2b.proyectodisenio.dao.DAOManager;

import java.util.List;

public class GestorAniosFabricacion {
    public static List<AnioFabricacion> getAniosFabricacionFromModelo(Modelo m){
        return DAOManager.anioFabricacionDAO().getAniosFromModelo(m);
    }
}
