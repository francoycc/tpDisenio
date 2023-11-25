package org.grupo2b.proyectodisenio.dto;

import org.grupo2b.proyectodisenio.logica.enums.CondicionCliente;
import org.grupo2b.proyectodisenio.logica.enums.Sexo;

import java.util.Date;

public record ClienteDTO(int id, String nroCliente, String nombre, String apellido, long cuil, Sexo sexo,
                         Date fechaNacimiento, String correoElectronico, String profesion, int anioRegistro,
                         CondicionCliente condicionCliente, DocumentoDTO documentoDTO, String condicionIva,
                         DireccionDTO domicilio, String estadoCivil) {
}
