package org.grupo2b.proyectodisenio.logica.direccion;

import jakarta.persistence.*;
import org.grupo2b.proyectodisenio.logica.historial.HistorialFactor;

@Entity
public class Localidad {
    @Id
    @GeneratedValue
    @Column(name = "id_localidad")
    private int id;
    @Column(length = 20)
    private String nombre;
    private int codigoPostal;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_provincia")
    private Provincia provincia;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_historial")
    private HistorialFactor historialFactor;



    public Localidad(){}
    public Localidad(int id){
        this.id=id;
    }
    public Localidad(String nombre, int codigoPostal, Provincia provincia, HistorialFactor historialFactor) {
        this.nombre = nombre;
        this.codigoPostal = codigoPostal;
        this.provincia = provincia;
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
    public int getCodigoPostal() {
        return codigoPostal;
    }
    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
    public Provincia getProvincia() {
        return provincia;
    }
    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }
    public HistorialFactor getHistorialFactor() {
        return historialFactor;
    }
    public void setHistorialFactor(HistorialFactor historialFactor) {
        this.historialFactor = historialFactor;
    }
}
