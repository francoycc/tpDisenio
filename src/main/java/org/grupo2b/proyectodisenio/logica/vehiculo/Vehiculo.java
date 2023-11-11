package org.grupo2b.proyectodisenio.logica.vehiculo;

import jakarta.persistence.*;
import org.grupo2b.proyectodisenio.logica.direccion.Direccion;

@Entity
public class Vehiculo {
    @Id
    @GeneratedValue
    @Column(name = "id_vehiculo")
    private int id;
    @Column(name = "suma_asegurada")
    private int sumaAsegurada;
    @Column(length = 30)
    private String motor;
    @Column(length = 30)
    private String chasis;
    @Column(length = 10)
    private String patente;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_modelo")
    private Modelo modelo;
    @JoinColumn(name = "id_kmAnio")
    @ManyToOne(cascade = CascadeType.ALL)
    private KmPorAnio kmPorAnio;
    @JoinColumn(name = "id_direccion")
    @ManyToOne(cascade = CascadeType.ALL)
    private Direccion direccion;




    public Vehiculo(){}
    public Vehiculo(int sumaAsegurada, String motor, String chasis, String patente, Modelo modelo, KmPorAnio kmPorAnio, Direccion direccion) {
        this.sumaAsegurada = sumaAsegurada;
        this.motor = motor;
        this.chasis = chasis;
        this.patente = patente;
        this.modelo = modelo;
        this.kmPorAnio = kmPorAnio;
        this.direccion = direccion;
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
    public Direccion getDireccion() {
        return direccion;
    }
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
}
