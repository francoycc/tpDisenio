package org.grupo2b.proyectodisenio.logica;

import jakarta.persistence.*;
import org.grupo2b.proyectodisenio.logica.direccion.Direccion;
import org.grupo2b.proyectodisenio.logica.direccion.Pais;
import org.grupo2b.proyectodisenio.logica.documento.Documento;
import org.grupo2b.proyectodisenio.logica.enums.CondicionCliente;
import org.grupo2b.proyectodisenio.logica.enums.Sexo;
import org.grupo2b.proyectodisenio.logica.poliza.EstadoCivil;
import org.grupo2b.proyectodisenio.logica.vehiculo.Vehiculo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Cliente {
    @Id
    @GeneratedValue
    private int id;
    private String nroCliente;
    @PrePersist
    private void ensureId(){
        nroCliente = domicilio.getLocalidad().getProvincia().getPais().getId()+ "-"+id;
        //TODO CODIGO DE PAIS? NORMALIZAR
    }
    @Column(length = 40)
    private String nombre;
    @Column(length = 40)
    private String apellido;
    private long cuil;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;
    @Column(name = "correo", length = 40)
    private String correoElectronico;
    @Column(length = 30)
    private String profesion;
    @Column(name = "anio_registro")
    private int anioRegistro;
    @Enumerated(EnumType.STRING)
    @Column(name = "condicion_cliente")
    private CondicionCliente condicionCliente;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "numero_documento")
    private Documento documento;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_condicion_iva")
    private CondicionIva condicionIva;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_domicilio")
    private Direccion domicilio;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    private List<Vehiculo> vehiculos;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_estado_civil")
    private EstadoCivil estadoCivil;



    public Cliente(){}
    public Cliente(int id){
        this.id=id;
    }
    public Cliente(String nombre, String apellido, long cuil, Sexo sexo, Date fechaNacimiento, String correoElectronico, String profesion, int anioRegistro, CondicionCliente condicionCliente, Documento documento, CondicionIva condicionIva, Direccion domicilio, List<Vehiculo> vehiculos, EstadoCivil estadoCivil) {
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


    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nroCliente='" + nroCliente + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", cuil=" + cuil +
                ", sexo=" + sexo +
                ", fechaNacimiento=" + fechaNacimiento +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", profesion='" + profesion + '\'' +
                ", anioRegistro=" + anioRegistro +
                ", condicionCliente=" + condicionCliente +
                ", documento=" + documento +
                ", condicionIva=" + condicionIva +
                ", domicilio=" + domicilio +
                ", vehiculos=" + vehiculos +
                ", estadoCivil=" + estadoCivil +
                '}';
    }

    public String getNroCliente() {
        return nroCliente;
    }

    public void setNroCliente(String nroCliente) {
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

    public long getCuil() {
        return cuil;
    }

    public void setCuil(long cuil) {
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

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
}
