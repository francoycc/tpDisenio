package org.grupo2b.proyectodisenio.logica.poliza;

import org.grupo2b.proyectodisenio.logica.enums.Sexo;
import org.grupo2b.proyectodisenio.logica.historial.HistorialFactor;

import java.util.Date;

public class DeclaracionHijo {
    static HistorialFactor historialFactor;
    int id;
    Date fechaNacimiento;
    Sexo sexo;
    EstadoCivil estadoCivilHijo;
}
