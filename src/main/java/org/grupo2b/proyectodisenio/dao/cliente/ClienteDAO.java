package org.grupo2b.proyectodisenio.dao.cliente;

import org.grupo2b.proyectodisenio.logica.Cliente;
import org.grupo2b.proyectodisenio.logica.documento.TipoDocumento;

import java.util.List;

public interface ClienteDAO {

    /**
     *
     * @param nombre
     * @param apellido
     * @param nroCliente
     * @param nroDoc
     * @param tipoDoc
     * @return Lista de clientes que cumplen con las condiciones
     */
    List<Cliente> getClientes(String nombre, String apellido, String nroCliente, String nroDoc, TipoDocumento tipoDoc);
}
