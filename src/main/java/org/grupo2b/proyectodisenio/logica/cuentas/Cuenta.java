package org.grupo2b.proyectodisenio.logica.cuentas;

import jakarta.persistence.*;
import org.grupo2b.proyectodisenio.dao.cuentas.PasswordHasher;

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
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private TipoCuenta tipoCuenta;
    @Column(length = 16, nullable = false)
    private String salt;
    @PrePersist//POR LAS DUDAS
    @PreUpdate
    private void generateSalt(){
        if (salt==null)
            salt=PasswordHasher.generateSalt();
    }



    public Cuenta(){}
    public Cuenta(String nombre, String clave, TipoCuenta tipoCuenta) {
        generateSalt();
        this.nombre = nombre;
        this.claveHash = PasswordHasher.hash(clave, salt);
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
        generateSalt();
        this.claveHash = PasswordHasher.hash(clave, salt);
    }
    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }
    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }
    public String getSalt() {
        return salt;
    }
    public void setSalt(String salt) {
        this.salt = salt;
    }
}
