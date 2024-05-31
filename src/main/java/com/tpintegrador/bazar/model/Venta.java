package com.tpintegrador.bazar.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigoVenta;
    @NonNull
    private LocalDate fechaVenta;
    @NonNull
    private Double total;
    @NonNull
    @ManyToMany
    @JoinTable(
            name = "venta_producto",
            joinColumns = @JoinColumn(name = "codigo_venta"),
            inverseJoinColumns = @JoinColumn(name = "codigo_producto")
    )
    private List<Producto> listaProductos;
    @NonNull
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @JsonIgnoreProperties(value = "ventas")
    private Cliente unCliente;
}
