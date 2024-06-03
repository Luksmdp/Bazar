package com.tpintegrador.bazar.model.Dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
@Data
public class VentaDto {
    private LocalDate fechaVenta;
    private Double total;
    private Long idCliente;
    private HashMap<Long,Long> listaProductos;
}
