package org.grupo2b.proyectodisenio.dao.cliente;

import org.grupo2b.proyectodisenio.logica.cliente.Cliente;

import java.util.List;
import java.util.Optional;

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
    List<Cliente> getClientes(String nombre, String apellido, String nroCliente, String nroDoc, String tipoDoc);
    Optional<Cliente> getClienteFromNroCliente(String nroCliente);
}
