package org.grupo2b.proyectodisenio.logica.documento;

import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.dao.documento.TipoDocumentoDAOPSQL;

import java.util.List;
import java.util.stream.Collectors;

public class GestorDocumentos {
    public static List<String> getTiposDocumento(){
        List<TipoDocumento> tiposDoc = DAOManager.tipoDocumentoDAO().getTiposDocumento();
        return DAOManager.tipoDocumentoDAO().getTiposDocumento().stream().map(TipoDocumento::getNombre).collect(Collectors.toList());
    }
}
