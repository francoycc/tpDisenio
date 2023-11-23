package org.grupo2b.proyectodisenio.logica.direccion;

import org.grupo2b.proyectodisenio.dao.DAOManager;

import java.util.List;

public class GestorProvincia {
    public static List<Provincia> getProvincias(){
        return DAOManager.provinciaDAO().getProvincias();
    }

    public static List<Localidad> getLocalidadesFromProvincia(Provincia prov){
        return DAOManager.localidadDAO().getLocalidadesFromIdProvincia(prov.getId());
    }
}
