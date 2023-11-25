package org.grupo2b.proyectodisenio.dto;

import org.grupo2b.proyectodisenio.logica.enums.EstadoPoliza;
import org.grupo2b.proyectodisenio.logica.enums.FormaPago;

import java.time.LocalDate;
import java.util.List;

public record PolizaDTO(int id, LocalDate fechaInicioVigencia, LocalDate fechaFinalVigencia, LocalDate fechaEmision, FormaPago formaPago, EstadoPoliza estadoPoliza,
                        int idTipoCobertura, List<String> idsMedidasSeguridad, VehiculoDTO vehiculo, List<DeclaracionHijoDTO> declaracionesHijos, int id_cliente, int id_nroSiniestros) {
}
