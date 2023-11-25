package org.grupo2b.proyectodisenio.dto;

public record ProvinciaDTO(int id, int id_pais, String nombre) {
    @Override
    public String toString() {
        return nombre;
    }
}
