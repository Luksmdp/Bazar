package com.tpintegrador.bazar.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoVenta;
    @NotNull
    private LocalDate fechaVenta;
    @NotNull
    private Double total;
    @NotNull
    @OneToMany(mappedBy = "venta")
    private List<VentaDetalle> listaVentaDetalle;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente unCliente;
}
