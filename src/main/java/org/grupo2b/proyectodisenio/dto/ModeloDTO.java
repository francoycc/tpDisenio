package org.grupo2b.proyectodisenio.dto;

public record ModeloDTO(int id, int id_marca, String modelo) {
    @Override
    public String toString() {
        return modelo;
    }
}
