package org.grupo2b.proyectodisenio.logica.direccion;

import jakarta.persistence.*;

@Entity
public class Direccion {
    @Id
    @GeneratedValue
    @Column(name = "id_direccion")
    private int id;
    @Column(length = 20, nullable = false)
    private String calle;
    @Column(nullable = false)
    private int numero;
    private int piso;
    private int departamento;
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id_localidad")
    private Localidad localidad;



    public Direccion(){}
    public Direccion(int id){
        this.id=id;
    }
    public Direccion(String calle, int numero, int piso, int departamento, Localidad localidad) {
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
