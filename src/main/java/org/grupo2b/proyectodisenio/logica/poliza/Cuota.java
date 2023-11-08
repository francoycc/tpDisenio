package org.grupo2b.proyectodisenio.logica.poliza;

import jakarta.persistence.*;
import org.grupo2b.proyectodisenio.logica.enums.EstadoCuota;

import java.util.Date;

@Entity
public class Cuota {
    @Id
    @GeneratedValue
    private int id;
    private Date fechaVencimiento;
    private float monto;
    private EstadoCuota estado;
    private float recargoMora;
    private float bonificacion;
    @ManyToOne(cascade = CascadeType.ALL)
    private Recibo recibo;




    public Cuota(){}
    public Cuota(int id){
        this.id=id;
    }
    public Cuota(Date fechaVencimiento, float monto, EstadoCuota estado, float recargoMora, float bonificacion, Recibo recibo) {
        this.fechaVencimiento = fechaVencimiento;
        this.monto = monto;
        this.estado = estado;
        this.recargoMora = recargoMora;
        this.bonificacion = bonificacion;
        this.recibo = recibo;
    }





    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }
    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
    public float getMonto() {
        return monto;
    }
    public void setMonto(float monto) {
        this.monto = monto;
    }
    public EstadoCuota getEstado() {
        return estado;
    }
    public void setEstado(EstadoCuota estado) {
        this.estado = estado;
    }
    public float getRecargoMora() {
        return recargoMora;
    }
    public void setRecargoMora(float recargoMora) {
        this.recargoMora = recargoMora;
    }
    public float getBonificacion() {
        return bonificacion;
    }
    public void setBonificacion(float bonificacion) {
        this.bonificacion = bonificacion;
    }
    public Recibo getRecibo() {
        return recibo;
    }
    public void setRecibo(Recibo recibo) {
        this.recibo = recibo;
    }
}
