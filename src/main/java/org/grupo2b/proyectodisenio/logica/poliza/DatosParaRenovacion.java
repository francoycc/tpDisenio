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
    @Column(name = "id_renovacion")
    private int id;
    @Enumerated(EnumType.STRING)
    @Column(name = "forma_pago", nullable = false)
    private FormaPago formaPago;
    @Column(name = "fecha_renovacion", nullable = false)
    private Date fechaRenovacion;
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id_tipo_cobertura")
    private TipoCobertura tipoCobertura;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "RELACION_MEDIDAS_RENOVACION", joinColumns = @JoinColumn(name = "id_renovacion"), inverseJoinColumns = @JoinColumn(name = "id_seguridad"))
    private ArrayList<MedidaDeSeguridad> medidasDeSeguridad;
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id_anioFabricacion")
    private AnioFabricacion anioFabricacion;
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id_vehiculo")
    private Vehiculo vehiculo;
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id_poliza")
    private Poliza poliza;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "RELACION_RENOVACION_DECLARACION", joinColumns = @JoinColumn(name = "id_renovacion"), inverseJoinColumns = @JoinColumn(name = "id_declaracion"))
    private ArrayList<DeclaracionHijo> declaracionesHijos;
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id_nro_siniestros")
    private NumeroSiniestros nroSiniestros;




    public DatosParaRenovacion(){}
    public DatosParaRenovacion(FormaPago formaPago, Date fechaRenovacion, TipoCobertura tipoCobertura, ArrayList<MedidaDeSeguridad> medidasDeSeguridad, AnioFabricacion anioFabricacion, Vehiculo vehiculo, Poliza poliza, ArrayList<DeclaracionHijo> declaracionesHijos, NumeroSiniestros nroSiniestros) {
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
