package org.grupo2b.proyectodisenio.logica.poliza;

import org.grupo2b.proyectodisenio.logica.enums.EstadoPoliza;
import org.grupo2b.proyectodisenio.logica.enums.FormaPago;
import org.grupo2b.proyectodisenio.logica.Cliente;
import org.grupo2b.proyectodisenio.logica.vehiculo.Vehiculo;

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
