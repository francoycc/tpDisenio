package org.grupo2b.proyectodisenio.logica.poliza;

import jakarta.persistence.*;
import org.grupo2b.proyectodisenio.logica.historial.HistorialFactor;

@Entity
@Table(name = "MEDIDAS_SEGURIDAD")
public class MedidaDeSeguridad {
    @Id
    @Column(length = 20)
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
