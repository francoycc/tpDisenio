package org.grupo2b.proyectodisenio.logica.cuentas;

import jakarta.persistence.*;

@Entity
public class Cuenta {
    @Id
    @GeneratedValue
    @Column(name = "idUsuario")
    private int id;
    @Column(length = 32, unique = true, nullable = false)
    private String nombre;
    @Column(length = 64, nullable = false)
    private String claveHash;
    @ManyToOne(optional = false)
    private TipoCuenta tipoCuenta;



    public Cuenta(){}
    public Cuenta(String nombre, String clave, TipoCuenta tipoCuenta) {
        this.nombre = nombre;
        this.claveHash = PasswordHasher.hash(clave);
        this.tipoCuenta = tipoCuenta;
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
    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }
    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }
}
