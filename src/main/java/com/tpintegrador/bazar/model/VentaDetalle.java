package com.tpintegrador.bazar.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VentaDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "codigo_producto")
    private Producto producto;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "codigo_venta")
    private Venta venta;
    @NotNull
    private Long cantidadProducto;
}
