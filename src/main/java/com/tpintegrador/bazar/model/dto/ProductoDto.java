package com.tpintegrador.bazar.model.dto;

import lombok.Data;

@Data
public class ProductoDto {

    private String nombre;
    private String marca;
    private Double costo;
    private Double cantidadDisponible;
}
