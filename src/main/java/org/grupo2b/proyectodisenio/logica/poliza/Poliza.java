package org.grupo2b.proyectodisenio.logica.poliza;

import jakarta.persistence.*;
import org.grupo2b.proyectodisenio.logica.enums.EstadoPoliza;
import org.grupo2b.proyectodisenio.logica.enums.FormaPago;
import org.grupo2b.proyectodisenio.logica.Cliente;
import org.grupo2b.proyectodisenio.logica.vehiculo.Vehiculo;

import java.util.Date;
import java.util.List;

@Entity
public class Poliza {
    @Id
    @GeneratedValue//TODO CUSTOM GENERATOR
    @Column(name = "id_poliza")
    private int id;
    @Column(name = "nro_poliza")
    private String nroPoliza;

    @PrePersist
    private void ensureId(){
        nroPoliza = "" + id;
    }
    @Column(name = "inicio_vigencia")
    private Date inicioVigencia;
    @Column(name = "fin_vigencia")
    private Date finVigencia;
    @Column(name = "fecha_registro")
    private Date fechaRegistro;
    @Enumerated(EnumType.STRING)
    @Column(name = "forma_pago")
    private FormaPago formaPago;
    @Enumerated(EnumType.STRING)
    @Column(name = "estado_poliza")
    private EstadoPoliza estadoPoliza;
    private float premio;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_derecho_emision")
    private DerechoEmision derechoEmision;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_descuento")
    private Descuento descuento;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tipo_cobertura")
    private TipoCobertura tipoCobertura;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_poliza")
    private List<Cuota> cuotas;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "RELACION_MEDIDAS_POLIZA", joinColumns = @JoinColumn(name = "id_poliza"), inverseJoinColumns = @JoinColumn(name = "id_seguridad"))
    private List<MedidaDeSeguridad> medidasDeSeguridad;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_renovacion")
    private DatosParaRenovacion datosRenovacion;
    @OneToOne(cascade = CascadeType.ALL)
    private Vehiculo vehiculo;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "RELACION_POLIZA_DECLARACION", joinColumns = @JoinColumn(name = "id_poliza"), inverseJoinColumns = @JoinColumn(name = "id_declaracion"))
    private List<DeclaracionHijo> declaracionesHijos;
    @ManyToOne(cascade = CascadeType.ALL)
    private Cliente cliente;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_nro_siniestros")
    private NumeroSiniestros nroSiniestros;


    public Poliza() {}
    public Poliza(Date inicioVigencia, Date finVigencia, Date fechaRegistro, FormaPago formaPago, EstadoPoliza estadoPoliza,
                  float premio, DerechoEmision derechoEmision, Descuento descuento, TipoCobertura tipoCobertura, List<Cuota> cuotas,
                  List<MedidaDeSeguridad> medidasDeSeguridad, Vehiculo vehiculo, List<DeclaracionHijo> declaracionesHijos, Cliente cliente, NumeroSiniestros nroSiniestros){
        this.inicioVigencia = inicioVigencia;
        this.finVigencia = finVigencia;
        this.fechaRegistro = fechaRegistro;
        this.formaPago = formaPago;
        this.estadoPoliza = estadoPoliza;
        this.premio = premio;
        this.derechoEmision = derechoEmision;
        this.descuento = descuento;
        this.tipoCobertura = tipoCobertura;
        this.cuotas = cuotas;
        this.medidasDeSeguridad = medidasDeSeguridad;
        this.datosRenovacion = datosRenovacion;
        this.vehiculo = vehiculo;
        this.declaracionesHijos = declaracionesHijos;
        this.cliente = cliente;
        this.nroSiniestros = nroSiniestros;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNroPoliza() {
        return nroPoliza;
    }
    public void setNroPoliza(String nroPoliza) {
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
        return descuento;
    }
    public void setDescuentos(Descuento descuento) {
        this.descuento = descuento;
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
