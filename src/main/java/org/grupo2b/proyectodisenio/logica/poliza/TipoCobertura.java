package org.grupo2b.proyectodisenio.logica.poliza;

import jakarta.persistence.*;
import org.grupo2b.proyectodisenio.logica.historial.HistorialFactor;

@Entity
@Table(name = "tipos_cobertura")
public class TipoCobertura {
    @Id
    @GeneratedValue
    private int id;
    @Column(length = 30)
    private String nombre;
    @OneToOne(cascade = CascadeType.ALL)
    HistorialFactor historialFactor;


    public TipoCobertura(){}
    public TipoCobertura(String nombre) {
        this.nombre = nombre;
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
