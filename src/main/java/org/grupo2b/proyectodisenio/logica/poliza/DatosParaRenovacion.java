package org.grupo2b.proyectodisenio.logica.poliza;

import org.grupo2b.proyectodisenio.logica.enums.FormaPago;
import org.grupo2b.proyectodisenio.logica.vehiculo.AnioFabricacion;
import org.grupo2b.proyectodisenio.logica.vehiculo.Vehiculo;
import org.grupo2b.proyectodisenio.logica.Cliente;

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
