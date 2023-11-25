package org.grupo2b.proyectodisenio.logica.poliza;

import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.dto.NumeroSiniestrosDTO;

import java.util.List;
import java.util.stream.Collectors;

public class GestorNumeroSiniestros {
    public static List<NumeroSiniestrosDTO> getNumeroSiniestrosList(){
        return DAOManager.numeroSiniestrosDAO().getNumeroSiniestrosList().stream().map(o -> new NumeroSiniestrosDTO(o.getId(), o.getCantSiniestrosInicial(), o.getCantSiniestrosFinal())).collect(Collectors.toList());
    }
}
