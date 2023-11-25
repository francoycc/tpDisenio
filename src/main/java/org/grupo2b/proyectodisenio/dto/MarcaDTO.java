package org.grupo2b.proyectodisenio.dto;

public record MarcaDTO(int id, String nombre) {
    @Override
    public String toString() {
        return nombre;
    }
}
