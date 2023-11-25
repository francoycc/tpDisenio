package org.grupo2b.proyectodisenio.logica.vehiculo;

import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.dto.MarcaDTO;

import java.util.List;
import java.util.stream.Collectors;

public class GestorMarca {
    public static List<MarcaDTO> getMarcas() {
        return DAOManager.marcaDao().getMarcas().stream().map(o -> new MarcaDTO(o.getId(), o.getNombre())).collect(Collectors.toList());
    }
}
