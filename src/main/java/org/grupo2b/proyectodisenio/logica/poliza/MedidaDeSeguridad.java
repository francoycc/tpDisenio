package org.grupo2b.proyectodisenio.logica.poliza;

import jakarta.persistence.*;
import org.grupo2b.proyectodisenio.logica.historial.HistorialFactor;

@Entity
@Table(name = "MEDIDAS_SEGURIDAD")
public class MedidaDeSeguridad {
    @Id
    @GeneratedValue
    @Column(name = "id_seguridad")
    private int id;
    @Column(length = 20)
    private String nombre;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_historial")
    private HistorialFactor historial;


    public MedidaDeSeguridad(){}
    public MedidaDeSeguridad(int id, String nombre, HistorialFactor historialFactor) {
        this.id = id;
        this.nombre = nombre;
        this.historial = historialFactor;
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
}
