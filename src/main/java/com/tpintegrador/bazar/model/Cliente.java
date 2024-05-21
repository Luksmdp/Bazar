package com.tpintegrador.bazar.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idCliente;
    private String nombre;
    private String apellido;
    private String dni;

    @OneToMany(mappedBy = "unCliente")
    private List<Venta> ventas;
}
