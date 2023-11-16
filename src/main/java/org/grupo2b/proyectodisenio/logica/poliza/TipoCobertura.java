package org.grupo2b.proyectodisenio.logica.poliza;

import jakarta.persistence.*;
import org.grupo2b.proyectodisenio.logica.historial.HistorialFactor;

@Entity
@Table(name = "tipos_cobertura")
public class TipoCobertura {
    @Id
    @GeneratedValue
    @Column(name = "id_tipoCobertura")
    private int id;
    @Column(length = 40)
    private String nombre;
    @Column(length = 1000)
    private String descripcion;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_historial")
    HistorialFactor historial;
    int maxAniosVehiculo;




    public TipoCobertura(){}
    public TipoCobertura(String nombre, String descripcion, int maxAniosVehiculo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.maxAniosVehiculo = maxAniosVehiculo;
    }


    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public HistorialFactor getHistorial() {
        return historial;
    }
    public void setHistorial(HistorialFactor historial) {
        this.historial = historial;
    }
    public int getMaxAniosVehiculo() {
        return maxAniosVehiculo;
    }
    public void setMaxAniosVehiculo(int maxAniosVehiculo) {
        this.maxAniosVehiculo = maxAniosVehiculo;
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
}
