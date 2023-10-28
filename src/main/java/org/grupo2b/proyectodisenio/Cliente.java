package org.grupo2b.proyectodisenio;

import org.grupo2b.proyectodisenio.direccion.Direccion;
import org.grupo2b.proyectodisenio.documento.Documento;
import org.grupo2b.proyectodisenio.enums.CondicionCliente;
import org.grupo2b.proyectodisenio.enums.Sexo;
import org.grupo2b.proyectodisenio.poliza.EstadoCivil;
import org.grupo2b.proyectodisenio.vehiculo.Vehiculo;

import java.util.ArrayList;
import java.util.Date;

public class Cliente {
    int nroCliente;
    String nombre;
    String apellido;
    int cuil;
    Sexo sexo;
    Date fechaNacimiento;
    String correoElectronico;
    String profesion;
    int anioRegistro;
    CondicionCliente condicionCliente;
    Documento documento;
    CondicionIva condicionIva;
    Direccion domicilio;
    ArrayList<Vehiculo> vehiculos;
    EstadoCivil estadoCivil;
}
