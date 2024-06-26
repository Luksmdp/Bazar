package com.tpintegrador.bazar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;
    @NotNull
    private String nombre;
    @NotNull
    private String apellido;
    @NotNull
    private String dni;

    @OneToMany(mappedBy = "unCliente")
    @JsonIgnore
    private List<Venta> ventas;
}
