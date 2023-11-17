package org.grupo2b.proyectodisenio.logica.poliza;

import jakarta.persistence.*;
import org.grupo2b.proyectodisenio.logica.cuentas.Cuenta;

import java.util.Date;
import java.util.List;

@Entity
public class Recibo {
    @Id
    @GeneratedValue
    @Column(name = "id_recibo")
    private int id;
    @Column(nullable = false)
    private Date fecha;
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Cuenta operador;
    @Column(name = "numero_recibo", nullable = false)
    private int nroRecibo;
    @Column(name = "mes", nullable = false)
    private int nroMes;
    @Column(name = "anio", nullable = false)
    private int nroAnio;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "recibo")
    private List<Cuota> cuotas;


    public Recibo(){}
    public Recibo(Date fecha, Cuenta operador, int nroRecibo, int nroMes, int nroAnio, List<Cuota> cuotas) {
        this.fecha = fecha;
        this.operador = operador;
        this.nroRecibo = nroRecibo;
        this.nroMes = nroMes;
        this.nroAnio = nroAnio;
        this.cuotas = cuotas;
    }




    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Cuenta getOperador() {
        return operador;
    }
    public void setOperador(Cuenta operador) {
        this.operador = operador;
    }
    public int getNroRecibo() {
        return nroRecibo;
    }
    public void setNroRecibo(int nroRecibo) {
        this.nroRecibo = nroRecibo;
    }
    public int getNroMes() {
        return nroMes;
    }
    public void setNroMes(int nroMes) {
        this.nroMes = nroMes;
    }
    public int getNroAnio() {
        return nroAnio;
    }
    public void setNroAnio(int nroAnio) {
        this.nroAnio = nroAnio;
    }
    public List<Cuota> getCuotas() {
        return cuotas;
    }
    public void setCuotas(List<Cuota> cuotas) {
        this.cuotas = cuotas;
    }
}
