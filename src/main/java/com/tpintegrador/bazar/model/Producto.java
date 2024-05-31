package com.tpintegrador.bazar.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigoProducto;
    @NonNull
    private String nombre;
    @NonNull
    private String marca;
    @NonNull
    private Double costo;
    @NonNull
    private Double cantidadDisponible;
}
