package org.grupo2b.proyectodisenio.logica.direccion;

import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.dto.LocalidadDTO;
import org.grupo2b.proyectodisenio.dto.ProvinciaDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GestorUbicaciones {
    public static List<ProvinciaDTO> getProvincias(){
        return DAOManager.provinciaDAO().getProvincias().stream().map(o -> new ProvinciaDTO(o.getId(), o.getPais().getId(), o.getNombre())).collect(Collectors.toList());
    }
    public static List<LocalidadDTO> getLocalidadesFromIdProvincia(int id){
        return DAOManager.localidadDAO().getLocalidadesFromIdProvincia(id).stream().map(o -> new LocalidadDTO(o.getId(), o.getProvincia().getId(), o.getNombre(), o.getCodigoPostal())).collect(Collectors.toList());
    }
    public static Optional<String> getNombreLocalidadFromId(int id){
        return DAOManager.localidadDAO().getLocalidad(id).map(Localidad::getNombre);
    }
}
