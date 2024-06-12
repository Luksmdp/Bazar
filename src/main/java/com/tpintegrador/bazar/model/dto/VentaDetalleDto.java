package com.tpintegrador.bazar.model.dto;

import lombok.Data;

@Data
public class VentaDetalleDto {

    private Long codigoProducto;
    private Long codigoVenta;
    private Long cantidadProducto;
}
