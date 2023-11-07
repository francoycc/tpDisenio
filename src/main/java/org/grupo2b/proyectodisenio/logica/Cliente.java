package org.grupo2b.proyectodisenio.logica;

import org.grupo2b.proyectodisenio.logica.direccion.Direccion;
import org.grupo2b.proyectodisenio.logica.documento.Documento;
import org.grupo2b.proyectodisenio.logica.enums.CondicionCliente;
import org.grupo2b.proyectodisenio.logica.enums.Sexo;
import org.grupo2b.proyectodisenio.logica.poliza.EstadoCivil;
import org.grupo2b.proyectodisenio.logica.vehiculo.Vehiculo;

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
