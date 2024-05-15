package com.tpintegrador.bazar.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigoProducto;
    private String nombre;
    private String marca;
    private double costo;
    private double cantidadDisponible;
    @ManyToOne
    @JoinColumn(name = "venta_id")
    private Venta venta;
}
