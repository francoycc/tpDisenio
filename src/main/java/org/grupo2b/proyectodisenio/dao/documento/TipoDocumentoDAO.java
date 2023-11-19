package org.grupo2b.proyectodisenio.dao.documento;

import org.grupo2b.proyectodisenio.logica.documento.TipoDocumento;

import java.util.List;
import java.util.Optional;

public interface TipoDocumentoDAO {
    List<TipoDocumento> getTiposDocumento();
    Optional<TipoDocumento> getTipoDocumentoFromName(String name);
}
