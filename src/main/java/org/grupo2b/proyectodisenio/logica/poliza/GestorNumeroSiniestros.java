package org.grupo2b.proyectodisenio.logica.poliza;

import org.grupo2b.proyectodisenio.dao.DAOManager;

import java.util.List;

public class GestorNumeroSiniestros {
    public static List<NumeroSiniestros> getNumeroSiniestrosList(){
        return DAOManager.numeroSiniestrosDAO().getNumeroSiniestrosList();
    }
}
