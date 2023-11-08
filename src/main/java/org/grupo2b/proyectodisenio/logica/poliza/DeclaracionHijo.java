package org.grupo2b.proyectodisenio.logica.poliza;

import jakarta.persistence.*;
import org.grupo2b.proyectodisenio.logica.enums.Sexo;
import org.grupo2b.proyectodisenio.logica.historial.HistorialFactor;

import java.util.Date;

@Entity
@Table(name = "DECLARACION_HIJO")
public class DeclaracionHijo {
    @Id
    @GeneratedValue
    private int id;
    private Date fechaNacimiento;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    @ManyToOne(cascade = CascadeType.ALL)
    private EstadoCivil estadoCivilHijo;




    public DeclaracionHijo(){}
    public DeclaracionHijo(int id){
        this.id=id;
    }
    public DeclaracionHijo(int id, Date fechaNacimiento, Sexo sexo, EstadoCivil estadoCivilHijo) {
        this.id = id;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.estadoCivilHijo = estadoCivilHijo;
    }




    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public Sexo getSexo() {
        return sexo;
    }
    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
    public EstadoCivil getEstadoCivilHijo() {
        return estadoCivilHijo;
    }
    public void setEstadoCivilHijo(EstadoCivil estadoCivilHijo) {
        this.estadoCivilHijo = estadoCivilHijo;
    }
}
