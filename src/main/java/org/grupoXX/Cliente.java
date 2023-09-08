package org.grupoXX;

import org.grupoXX.direccion.Direccion;
import org.grupoXX.documento.Documento;
import org.grupoXX.enums.CondicionCliente;
import org.grupoXX.enums.Sexo;
import org.grupoXX.poliza.EstadoCivil;
import org.grupoXX.vehiculo.Vehiculo;

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
