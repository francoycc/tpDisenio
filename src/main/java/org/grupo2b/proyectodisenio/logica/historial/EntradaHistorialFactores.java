package org.grupo2b.proyectodisenio.logica.historial;

import jakarta.persistence.*;
import org.grupo2b.proyectodisenio.logica.cuentas.Cuenta;
import org.grupo2b.proyectodisenio.logica.cuentas.GestorCuentas;

import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Table(name = "entrada_historial")
public class EntradaHistorialFactores{
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private float valorFactor;
    @Column(nullable = false)
    private LocalDateTime fechaInicio;
    @Column(nullable = false)
    private LocalDateTime fechaFin;
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Cuenta cuenta;

    public EntradaHistorialFactores(){};
    public EntradaHistorialFactores(float valorFactor, LocalDateTime fechaInicio, LocalDateTime fechaFin){
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
    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public LocalDateTime getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }
}
