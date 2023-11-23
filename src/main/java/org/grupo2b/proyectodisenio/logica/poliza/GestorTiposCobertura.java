package org.grupo2b.proyectodisenio.logica.poliza;

import org.grupo2b.proyectodisenio.dao.DAOManager;

import java.util.List;

public class GestorTiposCobertura {
    public static List<TipoCobertura> getTiposCobertura(){
        return DAOManager.tipoCoberturaDAO().getTiposCobertura();
    }
}
