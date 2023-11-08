package org.grupo2b.proyectodisenio.logica.poliza;

import jakarta.persistence.*;
import org.grupo2b.proyectodisenio.logica.historial.HistorialFactor;

@Entity
@Table(name = "MEDIDAS_SEGURIDAD")
public class MedidaDeSeguridad {
    @Id
    @GeneratedValue
    private int id;
    @Column(length = 20)
    private String nombre;
    @OneToOne(cascade = CascadeType.ALL)
    private HistorialFactor historialFactor;


    public MedidaDeSeguridad(){}
    public MedidaDeSeguridad(int id, String nombre, HistorialFactor historialFactor) {
        this.id = id;
        this.nombre = nombre;
        this.historialFactor = historialFactor;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public HistorialFactor getHistorialFactor() {
        return historialFactor;
    }
    public void setHistorialFactor(HistorialFactor historialFactor) {
        this.historialFactor = historialFactor;
    }
}
