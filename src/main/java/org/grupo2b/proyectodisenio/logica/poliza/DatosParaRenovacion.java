package org.grupo2b.proyectodisenio.logica.poliza;

import jakarta.persistence.*;
import org.grupo2b.proyectodisenio.logica.enums.FormaPago;
import org.grupo2b.proyectodisenio.logica.vehiculo.AnioFabricacion;
import org.grupo2b.proyectodisenio.logica.vehiculo.Vehiculo;
import org.grupo2b.proyectodisenio.logica.Cliente;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "DATOS_RENOVACION")
public class DatosParaRenovacion {
    @Id
    @GeneratedValue
    private int id;
    @Enumerated(EnumType.STRING)
    private FormaPago formaPago;
    private Date fechaRenovacion;
    @ManyToOne(cascade = CascadeType.ALL)
    private TipoCobertura tipoCobertura;
    @ManyToMany(cascade = CascadeType.ALL)
    private ArrayList<MedidaDeSeguridad> medidasDeSeguridad;
    @ManyToOne(cascade = CascadeType.ALL)
    private AnioFabricacion anioFabricacion;
    @OneToOne(cascade = CascadeType.ALL)
    private Vehiculo vehiculo;
    @OneToOne(cascade = CascadeType.ALL)
    private Poliza poliza;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_datos_renovacion")
    private ArrayList<DeclaracionHijo> declaracionesHijos;
    @ManyToOne(cascade = CascadeType.ALL)
    private NumeroSiniestros nroSiniestros;




    public DatosParaRenovacion(){}
    public DatosParaRenovacion(int id){
        this.id=id;
    }
    public DatosParaRenovacion(int id, FormaPago formaPago, Date fechaRenovacion, TipoCobertura tipoCobertura, ArrayList<MedidaDeSeguridad> medidasDeSeguridad, AnioFabricacion anioFabricacion, Vehiculo vehiculo, Poliza poliza, ArrayList<DeclaracionHijo> declaracionesHijos, NumeroSiniestros nroSiniestros) {
        this.id = id;
        this.formaPago = formaPago;
        this.fechaRenovacion = fechaRenovacion;
        this.tipoCobertura = tipoCobertura;
        this.medidasDeSeguridad = medidasDeSeguridad;
        this.anioFabricacion = anioFabricacion;
        this.vehiculo = vehiculo;
        this.poliza = poliza;
        this.declaracionesHijos = declaracionesHijos;
        this.nroSiniestros = nroSiniestros;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public FormaPago getFormaPago() {
        return formaPago;
    }
    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }
    public Date getFechaRenovacion() {
        return fechaRenovacion;
    }
    public void setFechaRenovacion(Date fechaRenovacion) {
        this.fechaRenovacion = fechaRenovacion;
    }
    public TipoCobertura getTipoCobertura() {
        return tipoCobertura;
    }
    public void setTipoCobertura(TipoCobertura tipoCobertura) {
        this.tipoCobertura = tipoCobertura;
    }
    public ArrayList<MedidaDeSeguridad> getMedidasDeSeguridad() {
        return medidasDeSeguridad;
    }
    public void setMedidasDeSeguridad(ArrayList<MedidaDeSeguridad> medidasDeSeguridad) {
        this.medidasDeSeguridad = medidasDeSeguridad;
    }
    public AnioFabricacion getAnioFabricacion() {
        return anioFabricacion;
    }
    public void setAnioFabricacion(AnioFabricacion anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }
    public Vehiculo getVehiculo() {
        return vehiculo;
    }
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    public Poliza getPoliza() {
        return poliza;
    }
    public void setPoliza(Poliza poliza) {
        this.poliza = poliza;
    }
    public ArrayList<DeclaracionHijo> getDeclaracionesHijos() {
        return declaracionesHijos;
    }
    public void setDeclaracionesHijos(ArrayList<DeclaracionHijo> declaracionesHijos) {
        this.declaracionesHijos = declaracionesHijos;
    }
    public NumeroSiniestros getNroSiniestros() {
        return nroSiniestros;
    }
    public void setNroSiniestros(NumeroSiniestros nroSiniestros) {
        this.nroSiniestros = nroSiniestros;
    }
}
