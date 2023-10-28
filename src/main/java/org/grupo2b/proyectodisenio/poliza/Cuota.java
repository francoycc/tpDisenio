package org.grupo2b.proyectodisenio.poliza;

import org.grupo2b.proyectodisenio.enums.EstadoCuota;

import java.util.Date;

public class Cuota {
    int id;
    Date fechaVencimiento;
    float monto;
    EstadoCuota estado;
    float recargoMora;
    float bonificacion;
    Recibo recibo;
}
