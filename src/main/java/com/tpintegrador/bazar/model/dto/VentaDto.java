package com.tpintegrador.bazar.model.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class VentaDto {
    private LocalDate fechaVenta;
    private Double total;
    private Long idCliente;
    private List<VentaDetalleDto> ventaDetalleDto;
}
