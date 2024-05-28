package com.tpintegrador.bazar.model.Dto;

import lombok.Data;

@Data
public class ProductoDto {

    private String nombre;
    private String marca;
    private double costo;
    private double cantidadDisponible;
}
