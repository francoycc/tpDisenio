package org.grupo2b.proyectodisenio.logica.cliente;

import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.dto.ClienteDTO;
import org.grupo2b.proyectodisenio.dto.DireccionDTO;
import org.grupo2b.proyectodisenio.dto.DocumentoDTO;
import org.grupo2b.proyectodisenio.logica.cliente.Cliente;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GestorClientes {
    public static final Function<Cliente, ClienteDTO> conversorADTO = o -> new ClienteDTO(o.getId(), o.getNroCliente(), o.getNombre(), o.getApellido(), o.getCuil(), o.getSexo(), o.getFechaNacimiento(),
            o.getCorreoElectronico(), o.getProfesion(), o.getAnioRegistro(), o.getCondicionCliente(),
            new DocumentoDTO(String.valueOf(o.getDocumento().getNumero()), o.getDocumento().getTipoDocumento().getNombre()),
            o.getCondicionIva().getTipo(),
            new DireccionDTO(o.getDomicilio().getId(), o.getDomicilio().getLocalidad().getId(), o.getDomicilio().getCalle(), o.getDomicilio().getNumero(), o.getDomicilio().getPiso(), o.getDomicilio().getDepartamento()),
            o.getEstadoCivil().getTipo());

    public static List<ClienteDTO> buscarClientes(String nombre, String apellido, String nroCliente, String tipoDoc, String nroDocumento){
        return DAOManager.clienteDAO().getClientes(nombre,apellido,nroCliente,nroDocumento,tipoDoc).stream().map(conversorADTO).collect(Collectors.toList());
    }

    public static Optional<ClienteDTO> getClienteFromNroCliente(String nroCliente){
        return DAOManager.clienteDAO().getClienteFromNroCliente(nroCliente).map(conversorADTO);
    }

    public static Optional<Cliente> getCliente(String nroCliente){
        return DAOManager.clienteDAO().getClienteFromNroCliente(nroCliente);
    }





    public static List<String> getEstadosCiviles(){
        return DAOManager.estadoCivilDAO().getEstadosCiviles().stream().map(EstadoCivil::getTipo).collect(Collectors.toList());
    }
}
