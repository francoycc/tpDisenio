package org.grupo2b.proyectodisenio.logica.direccion;

import jakarta.persistence.*;

@Entity
public class Direccion {
    @Id
    @GeneratedValue
    private int id;
    @Column(length = 20)
    private String calle;
    @Column
    private int numero;
    @Column
    private int piso;
    @Column
    private int departamento;
    @ManyToOne(cascade = CascadeType.ALL)
    private Localidad localidad;



    public Direccion(){}
    public Direccion(int id, String calle, int numero, int piso, int departamento, Localidad localidad) {
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.piso = piso;
        this.departamento = departamento;
        this.localidad = localidad;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCalle() {
        return calle;
    }
    public void setCalle(String calle) {
        this.calle = calle;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public int getPiso() {
        return piso;
    }
    public void setPiso(int piso) {
        this.piso = piso;
    }
    public int getDepartamento() {
        return departamento;
    }
    public void setDepartamento(int departamento) {
        this.departamento = departamento;
    }
    public Localidad getLocalidad() {
        return localidad;
    }
    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }
}
