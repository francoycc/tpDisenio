package org.grupo2b.proyectodisenio.logica.vehiculo;

import jakarta.persistence.*;
import org.grupo2b.proyectodisenio.logica.historial.HistorialFactor;

@Entity
@Table(name = "MEDIDAS_SEGURIDAD")
public class MedidaDeSeguridad {
    @Id
    @Column(name = "id_seguridad")
    private int id;
    @Column(length = 20, name = "nombre")
    private String nombre;
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id_historial")
    private HistorialFactor historial;
    private String pregunta;


    public MedidaDeSeguridad(){}
    public MedidaDeSeguridad(String nombre, HistorialFactor historialFactor, String pregunta) {
        this.nombre = nombre;
        this.historial = historialFactor;
        this.pregunta = pregunta;
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
        return historial;
    }
    public void setHistorialFactor(HistorialFactor historialFactor) {
        this.historial = historialFactor;
    }
    public String nombre() {
        return nombre;
    }
    public HistorialFactor historial() {
        return historial;
    }
    public void setHistorial(HistorialFactor historial) {
        this.historial = historial;
    }
    public String pregunta() {
        return pregunta;
    }
    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }
}
