package org.grupo2b.proyectodisenio.logica.vehiculo;

import org.grupo2b.proyectodisenio.dao.DAOManager;

import java.util.List;

public class GestorMarca {
    public static List<Marca> getMarcas() {
        return DAOManager.marcaDao().getMarcas();
    }
}
