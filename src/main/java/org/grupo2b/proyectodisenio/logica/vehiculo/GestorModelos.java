package org.grupo2b.proyectodisenio.logica.vehiculo;

import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.dto.MarcaDTO;
import org.grupo2b.proyectodisenio.dto.ModeloDTO;

import java.util.List;
import java.util.stream.Collectors;

public class GestorModelos {
    public static List<ModeloDTO> getModelosFromMarca(MarcaDTO marca){
        return DAOManager.modeloDAO().getModelosFromIdMarca(marca.id()).stream().map(o -> new ModeloDTO(o.getId(), o.getMarca().getId(), o.getNombre())).collect(Collectors.toList());
    }
    public static List<Modelo> getModelosFromMarca(Marca marca, int pageSize, int pageNumber){
        return DAOManager.modeloDAO().getModelosFromMarca(marca);
    }
}
