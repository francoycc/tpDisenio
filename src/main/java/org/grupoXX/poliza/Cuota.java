package org.grupoXX.poliza;

import org.grupoXX.enums.EstadoCuota;

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
