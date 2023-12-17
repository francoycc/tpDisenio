package org.grupo2b.proyectodisenio.dto;

import org.grupo2b.proyectodisenio.logica.enums.Sexo;

import java.time.LocalDate;

public record DeclaracionHijoDTO(int id, int id_estadoCivil, LocalDate fechaNacimiento, Sexo sexo) {
}
