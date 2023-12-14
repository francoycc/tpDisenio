package org.grupo2b.proyectodisenio.logica.cliente;

import jakarta.persistence.*;
import org.grupo2b.proyectodisenio.logica.direccion.Direccion;
import org.grupo2b.proyectodisenio.logica.documento.Documento;
import org.grupo2b.proyectodisenio.logica.enums.CondicionCliente;
import org.grupo2b.proyectodisenio.logica.enums.Sexo;
import org.grupo2b.proyectodisenio.logica.vehiculo.Vehiculo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
public class Cliente {  // HAY QUE PONER EL DOCUMENTO COMO ATRIBUTO
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false, unique = true)
    private String nroCliente;
    @PrePersist
    @PreUpdate
    private void ensureId(){
        nroCliente = String.format("%02d", domicilio.getLocalidad().getProvincia().getPais().getId())+ "-"+String.format("%08d", id);
    }
    @Column(length = 40, nullable = false)
    private String nombre;
    @Column(length = 40, nullable = false)
    private String apellido;
    @Column(nullable = false)//TODO Long o String
    private long cuil;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Sexo sexo;
    @Column(name = "fecha_nacimiento", nullable = false)
    private Date fechaNacimiento;
    @Column(name = "correo", length = 40, nullable = false)
    private String correoElectronico;
    @Column(length = 30, nullable = false)
    private String profesion;
    @Column(name = "anio_registro", nullable = false)
    private int anioRegistro;
    @Enumerated(EnumType.STRING)
    @Column(name = "condicion_cliente", nullable = false)
    private CondicionCliente condicionCliente;
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "numero_documento")
    private Documento documento;
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id_condicion_iva")
    private CondicionIva condicionIva;
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id_domicilio")
    private Direccion domicilio;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id", nullable = false)
    private List<Vehiculo> vehiculos;
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id_estado_civil")
    private EstadoCivil estadoCivil;
    int diasDesdeQueEsClienteActivo;



    public Cliente(){}

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
        this.diasDesdeQueEsClienteActivo = 0;
    }
    public Cliente(String nombre, String apellido, long cuil, Sexo sexo, Date fechaNacimiento, String correoElectronico, String profesion, int anioRegistro, CondicionCliente condicionCliente, Documento documento, CondicionIva condicionIva, Direccion domicilio, List<Vehiculo> vehiculos, EstadoCivil estadoCivil, int diasDesdeQueEsClienteActivo) {
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
        this.diasDesdeQueEsClienteActivo = diasDesdeQueEsClienteActivo;
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
    public int getDiasDesdeQueEsClienteActivo() {
        return diasDesdeQueEsClienteActivo;
    }
    public void setDiaDesdeQueEsClienteActivo(int diasDesdeQueEsClienteActivo) {
        this.diasDesdeQueEsClienteActivo = diasDesdeQueEsClienteActivo;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
