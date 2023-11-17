package org.grupo2b.proyectodisenio.logica.poliza;

import jakarta.persistence.*;
import org.grupo2b.proyectodisenio.logica.enums.EstadoCuota;

import java.util.Date;

@Entity
public class Cuota {
    @Id
    @GeneratedValue
    @Column(name = "id_cuota")
    private int id;
    @Column(name = "fecha_vencimiento", nullable = false)
    private Date fechaVencimiento;
    @Column(nullable = false)
    private float monto;
    @Column(nullable = false)
    private EstadoCuota estado;
    @Column(name = "recarga_mora", nullable = false)
    private float recargaMora;
    @Column(nullable = false)
    private float bonificacion;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_recibo")
    private Recibo recibo;




    public Cuota(){}
    public Cuota(Date fechaVencimiento, float monto, EstadoCuota estado, float recargaMora, float bonificacion, Recibo recibo) {
        this.fechaVencimiento = fechaVencimiento;
        this.monto = monto;
        this.estado = estado;
        this.recargaMora = recargaMora;
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
    public float getRecargaMora() {
        return recargaMora;
    }
    public void setRecargaMora(float recargaMora) {
        this.recargaMora = recargaMora;
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
