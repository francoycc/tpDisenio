package org.grupo2b.proyectodisenio.logica.poliza;

import org.grupo2b.proyectodisenio.dao.DAOManager;

import java.util.List;

public class GestorEstadosCiviles {
    public static List<EstadoCivil> getEstadosCiviles(){
        return DAOManager.estadoCivilDAO().getEstadosCiviles();
    }
}
