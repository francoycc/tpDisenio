package org.grupo2b.proyectodisenio.logica;

import jakarta.persistence.*;
import org.grupo2b.proyectodisenio.logica.direccion.Direccion;
import org.grupo2b.proyectodisenio.logica.documento.Documento;
import org.grupo2b.proyectodisenio.logica.enums.CondicionCliente;
import org.grupo2b.proyectodisenio.logica.enums.Sexo;
import org.grupo2b.proyectodisenio.logica.poliza.EstadoCivil;
import org.grupo2b.proyectodisenio.logica.vehiculo.Vehiculo;

import java.util.ArrayList;
import java.util.Date;

@Entity
public class Cliente {
    @Id
    private int nroCliente;
    @Column(length = 40)
    private String nombre;
    @Column(length = 40)
    private String apellido;
    @Column
    private int cuil;
    //TODO ????????????????
    private Sexo sexo;
    @Column
    private Date fechaNacimiento;
    @Column(length = 40)
    private String correoElectronico;
    @Column(length = 30)
    private String profesion;
    @Column
    private int anioRegistro;
    //TODO ????????????????????????
    @Enumerated
    private CondicionCliente condicionCliente;
    @OneToOne(cascade = CascadeType.ALL)
    private Documento documento;
    @ManyToOne(cascade = CascadeType.ALL)
    private CondicionIva condicionIva;
    @ManyToOne(cascade = CascadeType.ALL)
    private Direccion domicilio;
    @OneToMany(cascade = CascadeType.ALL)
    private ArrayList<Vehiculo> vehiculos;
    @ManyToOne(cascade = CascadeType.ALL)
    private EstadoCivil estadoCivil;



    public Cliente(){}
    public Cliente(int nroCliente, String nombre, String apellido, int cuil, Sexo sexo, Date fechaNacimiento, String correoElectronico, String profesion, int anioRegistro, CondicionCliente condicionCliente, Documento documento, CondicionIva condicionIva, Direccion domicilio, ArrayList<Vehiculo> vehiculos, EstadoCivil estadoCivil) {
        this.nroCliente = nroCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cuil = cuil;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.correoElectronico = correoElectronico;
        this.profesion = profesion;
        this.anioRegistro = anioRegistro;
        this.condicionCliente = condicionCliente;
        this.documento = documento;
        this.condicionIva = condicionIva;
        this.domicilio = domicilio;
        this.vehiculos = vehiculos;
        this.estadoCivil = estadoCivil;
    }




    public int getNroCliente() {
        return nroCliente;
    }

    public void setNroCliente(int nroCliente) {
        this.nroCliente = nroCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCuil() {
        return cuil;
    }

    public void setCuil(int cuil) {
        this.cuil = cuil;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public int getAnioRegistro() {
        return anioRegistro;
    }

    public void setAnioRegistro(int anioRegistro) {
        this.anioRegistro = anioRegistro;
    }

    public CondicionCliente getCondicionCliente() {
        return condicionCliente;
    }

    public void setCondicionCliente(CondicionCliente condicionCliente) {
        this.condicionCliente = condicionCliente;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public CondicionIva getCondicionIva() {
        return condicionIva;
    }

    public void setCondicionIva(CondicionIva condicionIva) {
        this.condicionIva = condicionIva;
    }

    public Direccion getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Direccion domicilio) {
        this.domicilio = domicilio;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
}
