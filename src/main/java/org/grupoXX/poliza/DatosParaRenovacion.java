package org.grupoXX.poliza;

import org.grupoXX.*;
import org.grupoXX.enums.FormaPago;
import org.grupoXX.vehiculo.AnioFabricacion;
import org.grupoXX.vehiculo.Vehiculo;

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
