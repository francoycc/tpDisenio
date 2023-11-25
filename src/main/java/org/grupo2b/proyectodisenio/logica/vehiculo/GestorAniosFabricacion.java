package org.grupo2b.proyectodisenio.logica.vehiculo;

import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.dto.ModeloDTO;

import java.util.List;
import java.util.stream.Collectors;

public class GestorAniosFabricacion {
    public static List<Integer> getAniosFabricacionFromModelo(ModeloDTO m){
        return DAOManager.anioFabricacionDAO().getAniosFromIdModelo(m.id()).stream().map(AnioFabricacion::getAnioModelo).collect(Collectors.toList());
    }
}
