package org.grupo2b.proyectodisenio.logica.cuentas;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Cuenta {
    @Id
    @GeneratedValue
    @Column(name = "idUsuario")
    private int id;
    @Column(length = 32, unique = true)
    private String nombre;
    @Column(length = 64)
    private String claveHash;



    public Cuenta(){}
    public Cuenta(String nombre, String clave) {
        this.nombre = nombre;
        this.claveHash = PasswordHasher.hash(clave);
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
    public String getClaveHash() {
        return claveHash;
    }
    public void setClaveHash(String claveHash) {
        this.claveHash = claveHash;
    }
    public void setClave(String clave) {
        this.claveHash = PasswordHasher.hash(clave);
    }
}
