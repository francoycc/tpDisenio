package org.grupo2b.proyectodisenio.logica.poliza;

import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.dto.TipoCoberturaDTO;

import java.util.List;
import java.util.stream.Collectors;

public class GestorTiposCobertura {
    public static List<TipoCoberturaDTO> getTiposCobertura(){
        return DAOManager.tipoCoberturaDAO().getTiposCobertura().stream().map(o -> new TipoCoberturaDTO(o.getId(), o.getNombre(), o.getDescripcion(), o.getMaxAniosVehiculo())).collect(Collectors.toList());
    }
}
