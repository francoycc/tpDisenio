package org.grupo2b.proyectodisenio.logica.poliza;

import jakarta.persistence.*;
import org.grupo2b.proyectodisenio.logica.cuentas.Cuenta;

import java.util.Date;
import java.util.List;

@Entity
public class Recibo {
    @Id
    @GeneratedValue
    private int id;
    private Date fecha;
    @ManyToOne(cascade = CascadeType.ALL)
    private Cuenta operador;
    private int nroRecibo;
    private int nroMes;
    private int nroAnio;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "recibo")
    private List<Cuota> cuotas;


    public Recibo(){}
    public Recibo(int id){
        this.id=id;
    }
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
