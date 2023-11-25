package org.grupo2b.proyectodisenio.logica.direccion;

import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.dto.LocalidadDTO;
import org.grupo2b.proyectodisenio.dto.ProvinciaDTO;

import java.util.List;
import java.util.stream.Collectors;

public class GestorProvincia {
    public static List<ProvinciaDTO> getProvincias(){
        return DAOManager.provinciaDAO().getProvincias().stream().map(o -> new ProvinciaDTO(o.getId(), o.getPais().getId(), o.getNombre())).collect(Collectors.toList());
    }

    public static List<Localidad> getLocalidadesFromProvincia(Provincia prov){
        return DAOManager.localidadDAO().getLocalidadesFromIdProvincia(prov.getId());
    }
    public static List<LocalidadDTO> getLocalidadesFromIdProvincia(int id){
        return DAOManager.localidadDAO().getLocalidadesFromIdProvincia(id).stream().map(o -> new LocalidadDTO(o.getId(), o.getProvincia().getId(), o.getNombre(), o.getCodigoPostal())).collect(Collectors.toList());
    }
    public static List<Localidad> getLocalidadesFromProvincia(Provincia prov, int pageSize, int pageNumber){
        return DAOManager.localidadDAO().getLocalidadesFromIdProvincia(prov.getId(), pageSize, pageNumber);
    }
    public static List<Localidad> getLocalidadesFromIdProvincia(int id, int pageSize, int pageNumber){
        return DAOManager.localidadDAO().getLocalidadesFromIdProvincia(id, pageSize, pageNumber);
    }
}
