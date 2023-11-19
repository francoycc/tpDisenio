package org.grupo2b.proyectodisenio.logica.documento;

import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.dao.documento.TipoDocumentoDAOPSQL;

import java.util.List;

public class GestorDocumentos {
    public static List<TipoDocumento> getTiposDocumento(){
        return DAOManager.tipoDocumentoDAO().getTiposDocumento();
    }
}
