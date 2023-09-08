package org.grupoXX.poliza;

import org.grupoXX.Cliente;
import org.grupoXX.enums.EstadoPoliza;
import org.grupoXX.enums.FormaPago;
import org.grupoXX.vehiculo.Vehiculo;

import java.util.ArrayList;
import java.util.Date;

public class Poliza {
    int nroPoliza;
    Date inicioVigencia;
    Date finVigencia;
    Date fechaRegistro;
    FormaPago formaPago;
    EstadoPoliza estadoPoliza;
    float premio;
    DerechoEmision derechoEmision;
    Descuentos descuentos;
    TipoCobertura tipoCobertura;
    ArrayList<Cuota> cuotas;
    ArrayList<MedidaDeSeguridad> medidasDeSeguridad;
    DatosParaRenovacion datosRenovacion;
    Vehiculo vehiculo;
    ArrayList<DeclaracionHijo> declaracionesHijos;
    Cliente cliente;
    NumeroSiniestros nroSiniestros;
}
