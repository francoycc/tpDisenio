package org.grupo2b.proyectodisenio.dao.cliente;

import org.grupo2b.proyectodisenio.logica.Cliente;

import java.util.List;

public interface ClienteDAO {
    List<Cliente> getCliente(String nombre, String apellido, String nroCliente, String nroDoc, String tipoDoc);
}
