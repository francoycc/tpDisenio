package org.grupo2b.proyectodisenio.logica.poliza;

import jakarta.persistence.*;
import org.grupo2b.proyectodisenio.logica.enums.EstadoPoliza;
import org.grupo2b.proyectodisenio.logica.enums.FormaPago;
import org.grupo2b.proyectodisenio.logica.Cliente;
import org.grupo2b.proyectodisenio.logica.vehiculo.Vehiculo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Poliza {
    @Id
    @GeneratedValue//TODO CUSTOM GENERATOR
    private int nroPoliza;
    private Date inicioVigencia;
    private Date finVigencia;
    private Date fechaRegistro;
    @Enumerated(EnumType.STRING)
    private FormaPago formaPago;
    @Enumerated(EnumType.STRING)
    private EstadoPoliza estadoPoliza;
    private float premio;
    @ManyToOne(cascade = CascadeType.ALL)
    private DerechoEmision derechoEmision;
    @ManyToOne(cascade = CascadeType.ALL)
    private Descuento descuentos;
    @ManyToOne(cascade = CascadeType.ALL)
    private TipoCobertura tipoCobertura;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_poliza")
    private List<Cuota> cuotas;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "RELACION_MEDIDAS_POLIZA", joinColumns = @JoinColumn(name = "id_poliza"), inverseJoinColumns = @JoinColumn(name = "id_seguridad"))
    private List<MedidaDeSeguridad> medidasDeSeguridad;
    @OneToOne(cascade = CascadeType.ALL)
    private DatosParaRenovacion datosRenovacion;
    @OneToOne(cascade = CascadeType.ALL)
    private Vehiculo vehiculo;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_poliza")
    private List<DeclaracionHijo> declaracionesHijos;
    @ManyToOne(cascade = CascadeType.ALL)
    private Cliente cliente;
    @ManyToOne(cascade = CascadeType.ALL)
    private NumeroSiniestros nroSiniestros;




    public Poliza(){}
    public Poliza(int nroPoliza){
        this.nroPoliza=nroPoliza;
    }
    public Poliza(int nroPoliza, Date inicioVigencia, Date finVigencia, Date fechaRegistro, FormaPago formaPago, EstadoPoliza estadoPoliza, float premio, DerechoEmision derechoEmision, Descuento descuentos, TipoCobertura tipoCobertura, List<Cuota> cuotas, List<MedidaDeSeguridad> medidasDeSeguridad, DatosParaRenovacion datosRenovacion, Vehiculo vehiculo, List<DeclaracionHijo> declaracionesHijos, Cliente cliente, NumeroSiniestros nroSiniestros) {
        this.nroPoliza = nroPoliza;
        this.inicioVigencia = inicioVigencia;
        this.finVigencia = finVigencia;
        this.fechaRegistro = fechaRegistro;
        this.formaPago = formaPago;
        this.estadoPoliza = estadoPoliza;
        this.premio = premio;
        this.derechoEmision = derechoEmision;
        this.descuentos = descuentos;
        this.tipoCobertura = tipoCobertura;
        this.cuotas = cuotas;
        this.medidasDeSeguridad = medidasDeSeguridad;
        this.datosRenovacion = datosRenovacion;
        this.vehiculo = vehiculo;
        this.declaracionesHijos = declaracionesHijos;
        this.cliente = cliente;
        this.nroSiniestros = nroSiniestros;
    }





    public int getNroPoliza() {
        return nroPoliza;
    }
    public void setNroPoliza(int nroPoliza) {
        this.nroPoliza = nroPoliza;
    }
    public Date getInicioVigencia() {
        return inicioVigencia;
    }
    public void setInicioVigencia(Date inicioVigencia) {
        this.inicioVigencia = inicioVigencia;
    }
    public Date getFinVigencia() {
        return finVigencia;
    }
    public void setFinVigencia(Date finVigencia) {
        this.finVigencia = finVigencia;
    }
    public Date getFechaRegistro() {
        return fechaRegistro;
    }
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    public FormaPago getFormaPago() {
        return formaPago;
    }
    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }
    public EstadoPoliza getEstadoPoliza() {
        return estadoPoliza;
    }
    public void setEstadoPoliza(EstadoPoliza estadoPoliza) {
        this.estadoPoliza = estadoPoliza;
    }
    public float getPremio() {
        return premio;
    }
    public void setPremio(float premio) {
        this.premio = premio;
    }
    public DerechoEmision getDerechoEmision() {
        return derechoEmision;
    }
    public void setDerechoEmision(DerechoEmision derechoEmision) {
        this.derechoEmision = derechoEmision;
    }
    public Descuento getDescuentos() {
        return descuentos;
    }
    public void setDescuentos(Descuento descuentos) {
        this.descuentos = descuentos;
    }
    public TipoCobertura getTipoCobertura() {
        return tipoCobertura;
    }
    public void setTipoCobertura(TipoCobertura tipoCobertura) {
        this.tipoCobertura = tipoCobertura;
    }
    public List<Cuota> getCuotas() {
        return cuotas;
    }
    public void setCuotas(List<Cuota> cuotas) {
        this.cuotas = cuotas;
    }
    public List<MedidaDeSeguridad> getMedidasDeSeguridad() {
        return medidasDeSeguridad;
    }
    public void setMedidasDeSeguridad(List<MedidaDeSeguridad> medidasDeSeguridad) {
        this.medidasDeSeguridad = medidasDeSeguridad;
    }
    public DatosParaRenovacion getDatosRenovacion() {
        return datosRenovacion;
    }
    public void setDatosRenovacion(DatosParaRenovacion datosRenovacion) {
        this.datosRenovacion = datosRenovacion;
    }
    public Vehiculo getVehiculo() {
        return vehiculo;
    }
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    public List<DeclaracionHijo> getDeclaracionesHijos() {
        return declaracionesHijos;
    }
    public void setDeclaracionesHijos(List<DeclaracionHijo> declaracionesHijos) {
        this.declaracionesHijos = declaracionesHijos;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public NumeroSiniestros getNroSiniestros() {
        return nroSiniestros;
    }
    public void setNroSiniestros(NumeroSiniestros nroSiniestros) {
        this.nroSiniestros = nroSiniestros;
    }
}
