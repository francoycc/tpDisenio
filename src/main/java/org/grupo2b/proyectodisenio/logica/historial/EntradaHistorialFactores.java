package org.grupo2b.proyectodisenio.logica.historial;

import jakarta.persistence.*;
import org.grupo2b.proyectodisenio.logica.cuentas.Cuenta;
import org.grupo2b.proyectodisenio.logica.cuentas.GestorCuentas;

import java.time.Instant;

@Entity
@Table(name = "entrada_historial")
public class EntradaHistorialFactores{
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private float valorFactor;
    @Column(nullable = false)
    private Instant fechaInicio;
    @Column(nullable = false)
    private Instant fechaFin;
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Cuenta cuenta;

    public EntradaHistorialFactores(){};
    public EntradaHistorialFactores(float valorFactor, Instant fechaInicio, Instant fechaFin){
        this.valorFactor=valorFactor;
        this.fechaFin=fechaFin;
        this.fechaInicio=fechaInicio;
        this.cuenta=GestorCuentas.getCuentaActiva();
    }




    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public float getValorFactor() {
        return valorFactor;
    }
    public void setValorFactor(float valorFactor) {
        this.valorFactor = valorFactor;
    }
    public Cuenta getCuenta() {
        return cuenta;
    }
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    public Instant getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(Instant fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public Instant getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(Instant fechaFin) {
        this.fechaFin = fechaFin;
    }
}
