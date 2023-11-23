package org.grupo2b.proyectodisenio.logica.vehiculo;

import org.grupo2b.proyectodisenio.dao.DAOManager;

import java.util.List;

public class GestorModelos {
    public static List<Modelo> getModelosFromMarca(Marca marca){
        return DAOManager.modeloDAO().getModelosFromMarca(marca);
    }
}
