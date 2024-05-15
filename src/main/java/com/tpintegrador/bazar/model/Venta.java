package com.tpintegrador.bazar.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
@Data
@Entity
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigoVenta;
    private LocalDate fechaVenta;
    private double total;
    @OneToMany(mappedBy = "venta")
    private List<Producto> listaProductos;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente unCliente;
}
