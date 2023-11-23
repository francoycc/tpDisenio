package org.grupo2b.proyectodisenio.logica.vehiculo;

import jakarta.persistence.*;
import org.grupo2b.proyectodisenio.logica.direccion.Direccion;
import org.grupo2b.proyectodisenio.logica.direccion.Localidad;

@Entity
public class Vehiculo {
    @Id
    @GeneratedValue
    @Column(name = "id_vehiculo")
    private int id;
    @Column(name = "suma_asegurada", nullable = false)
    private int sumaAsegurada;
    @Column(length = 30, nullable = false, unique = true)
    private String motor;
    @Column(length = 30, nullable = false, unique = true)
    private String chasis;
    @Column(length = 10,nullable = false, unique = true)
    private String patente;
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id_modelo")
    private Modelo modelo;
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id_kmAnio")
    private KmPorAnio kmPorAnio;
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id_direccion")
    private Localidad localidad;




    public Vehiculo(){}
    public Vehiculo(int sumaAsegurada, String motor, String chasis, String patente, Modelo modelo, KmPorAnio kmPorAnio, Localidad localidad) {
        this.sumaAsegurada = sumaAsegurada;
        this.motor = motor;
        this.chasis = chasis;
        this.patente = patente;
        this.modelo = modelo;
        this.kmPorAnio = kmPorAnio;
        this.localidad = localidad;
    }




    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getSumaAsegurada() {
        return sumaAsegurada;
    }
    public void setSumaAsegurada(int sumaAsegurada) {
        this.sumaAsegurada = sumaAsegurada;
    }
    public String getMotor() {
        return motor;
    }
    public void setMotor(String motor) {
        this.motor = motor;
    }
    public String getChasis() {
        return chasis;
    }
    public void setChasis(String chasis) {
        this.chasis = chasis;
    }
    public String getPatente() {
        return patente;
    }
    public void setPatente(String patente) {
        this.patente = patente;
    }
    public Modelo getModelo() {
        return modelo;
    }
    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }
    public KmPorAnio getKmPorAnio() {
        return kmPorAnio;
    }
    public void setKmPorAnio(KmPorAnio kmPorAnio) {
        this.kmPorAnio = kmPorAnio;
    }
    public Localidad getLocalidad() {
        return localidad;
    }
    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }
}
