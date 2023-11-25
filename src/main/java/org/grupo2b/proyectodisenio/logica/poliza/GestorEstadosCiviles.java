package org.grupo2b.proyectodisenio.logica.poliza;

import org.grupo2b.proyectodisenio.dao.DAOManager;

import java.util.List;
import java.util.stream.Collectors;

public class GestorEstadosCiviles {
    public static List<String> getEstadosCiviles(){
        return DAOManager.estadoCivilDAO().getEstadosCiviles().stream().map(EstadoCivil::getTipo).collect(Collectors.toList());
    }
}
