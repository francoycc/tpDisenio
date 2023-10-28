package org.grupo2b.proyectodisenio.poliza;

import org.grupo2b.proyectodisenio.enums.FormaPago;
import org.grupo2b.proyectodisenio.vehiculo.AnioFabricacion;
import org.grupo2b.proyectodisenio.vehiculo.Vehiculo;
import org.grupo2b.proyectodisenio.Cliente;

import java.util.ArrayList;
import java.util.Date;

public class DatosParaRenovacion {
    int id;
    FormaPago formaPago;
    Date fechaRenovacion;
    TipoCobertura tipoCobertura;
    ArrayList<MedidaDeSeguridad> medidasDeSeguridad;
    AnioFabricacion anioFabricacion;
    Vehiculo vehiculo;
    Cliente cliente;
    ArrayList<DeclaracionHijo> declaracionesHijos;
    NumeroSiniestros nroSiniestros;
}
