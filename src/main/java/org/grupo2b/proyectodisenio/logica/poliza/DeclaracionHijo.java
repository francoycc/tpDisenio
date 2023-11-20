package org.grupo2b.proyectodisenio.logica.poliza;

import jakarta.persistence.*;
import org.grupo2b.proyectodisenio.logica.enums.Sexo;
import org.grupo2b.proyectodisenio.logica.historial.HistorialFactor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "DECLARACION_HIJO")
public class DeclaracionHijo {
    @Id
    @GeneratedValue
    @Column(name = "id_declaracion")
    private int id;
    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Sexo sexo;
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id_estado_civil")
    private EstadoCivil estadoCivilHijo;




    public DeclaracionHijo(){}
    public DeclaracionHijo(LocalDate fechaNacimiento, Sexo sexo, EstadoCivil estadoCivilHijo) {
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
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
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
