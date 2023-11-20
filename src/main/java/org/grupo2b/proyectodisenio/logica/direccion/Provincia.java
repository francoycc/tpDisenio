package org.grupo2b.proyectodisenio.logica.direccion;

import jakarta.persistence.*;

@Entity
public class Provincia {
    @Id
    @GeneratedValue
    @Column(name = "id_provincia")
    private int id;
    @Column(length = 20, nullable = false)
    private String nombre;
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id_pais")
    private Pais pais;



    public Provincia(){}
    public Provincia(String nombre, Pais pais) {
        this.nombre = nombre;
        this.pais = pais;
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
    public Pais getPais() {
        return pais;
    }
    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return getNombre()+", "+pais.toString();
    }
}
