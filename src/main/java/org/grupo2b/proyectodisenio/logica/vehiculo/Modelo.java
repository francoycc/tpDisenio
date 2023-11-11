package org.grupo2b.proyectodisenio.logica.vehiculo;

import jakarta.persistence.*;
import org.grupo2b.proyectodisenio.logica.historial.HistorialFactor;

import java.util.List;
import java.util.Set;

@Entity
public class Modelo{
    @Id
    @GeneratedValue
    @Column(name = "id_modelo")
    private int id;
    @Column(length = 30)
    private String nombre;
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_marca")
    private Marca marca;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_historial")
    private HistorialFactor historialFactor;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<AnioFabricacion> aniosFabricacion;


    public Modelo(){}
    public Modelo(int id, String nombre, Marca marca, HistorialFactor historialFactor, List<AnioFabricacion> aniosFabricacion) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.historialFactor = historialFactor;
        this.aniosFabricacion = aniosFabricacion;
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
    public Marca getMarca() {
        return marca;
    }
    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    public HistorialFactor getHistorialFactor() {
        return historialFactor;
    }
    public void setHistorialFactor(HistorialFactor historialFactor) {
        this.historialFactor = historialFactor;
    }
    public List<AnioFabricacion> getAniosFabricacion() {
        return aniosFabricacion;
    }
    public void setAniosFabricacion(List<AnioFabricacion> aniosFabricacion) {
        this.aniosFabricacion = aniosFabricacion;
    }
}
