package com.tpintegrador.bazar.model.dto;

import lombok.Data;

@Data
public class MayorVentaDto {

    private Long codigoVenta;
    private Double total;
    private Long cantidadProductos;
    private String nombreCliente;
    private String apellidoCliente;
}
