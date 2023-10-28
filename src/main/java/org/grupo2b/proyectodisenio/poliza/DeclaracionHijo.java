package org.grupo2b.proyectodisenio.poliza;

import org.grupo2b.proyectodisenio.enums.Sexo;
import org.grupo2b.proyectodisenio.historial.HistorialFactor;

import java.util.Date;

public class DeclaracionHijo {
    static HistorialFactor historialFactor;
    int id;
    Date fechaNacimiento;
    Sexo sexo;
    EstadoCivil estadoCivilHijo;
}
