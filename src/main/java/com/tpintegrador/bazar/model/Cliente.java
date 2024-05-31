package com.tpintegrador.bazar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idCliente;
    @NonNull
    private String nombre;
    @NonNull
    private String apellido;
    @NonNull
    private String dni;

    @OneToMany(mappedBy = "unCliente")
    @JsonIgnore
    private List<Venta> ventas;
}
