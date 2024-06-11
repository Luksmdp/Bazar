package com.tpintegrador.bazar.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoProducto;
    @NotNull
    private String nombre;
    @NotNull
    private String marca;
    @NotNull
    private Double costo;
    @NotNull
    private Double cantidadDisponible;

}
