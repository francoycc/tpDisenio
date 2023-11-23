package org.grupo2b.proyectodisenio.logica;

import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.logica.documento.TipoDocumento;

import java.util.List;
import java.util.Optional;

public class GestorClientes {
    public static List<Cliente> buscarClientes(String nombre, String apellido, String nroCliente, TipoDocumento tipoDoc, String nroDocumento){
        return DAOManager.clienteDAO().getClientes(nombre,apellido,nroCliente,nroDocumento,tipoDoc);
    }
    public static Optional<Cliente> getClienteFromNroCliente(String nroCliente){
        return DAOManager.clienteDAO().getClienteFromNroCliente(nroCliente);
    }

    public static Optional<Cliente> getCliente(String nroCliente){
        return DAOManager.clienteDAO().getClienteFromNroCliente(nroCliente);
    }
}
