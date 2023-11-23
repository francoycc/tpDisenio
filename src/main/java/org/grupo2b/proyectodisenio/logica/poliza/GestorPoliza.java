package org.grupo2b.proyectodisenio.logica.poliza;

import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.logica.Cliente;
import org.grupo2b.proyectodisenio.logica.enums.EstadoPoliza;
import org.grupo2b.proyectodisenio.logica.enums.FormaPago;
import org.grupo2b.proyectodisenio.logica.vehiculo.Vehiculo;

import java.time.LocalDate;
import java.util.List;

public class GestorPoliza {

    public static void darAltaPoliza(LocalDate inicioVigencia, LocalDate finVigencia, LocalDate fechaRegistro, FormaPago formaPago, EstadoPoliza estadoPoliza,
                                     float premio, DerechoEmision derechoEmision, Descuento descuento, TipoCobertura tipoCobertura, List<Cuota> cuotas,
                                     List<MedidaDeSeguridad> medidasDeSeguridad, Vehiculo vehiculo, List<DeclaracionHijo> declaracionesHijos, Cliente cliente, NumeroSiniestros nroSiniestros){

        Poliza p = new Poliza(inicioVigencia, finVigencia, fechaRegistro, formaPago, estadoPoliza,
                premio, derechoEmision,  descuento, tipoCobertura, cuotas,
                medidasDeSeguridad, vehiculo, declaracionesHijos,  cliente,  nroSiniestros);

        DAOManager.polizaDAO().save(p);

    }

}
