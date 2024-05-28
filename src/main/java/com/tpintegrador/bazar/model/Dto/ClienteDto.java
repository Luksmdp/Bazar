package com.tpintegrador.bazar.model.Dto;

import com.tpintegrador.bazar.model.Venta;
import lombok.Data;

import java.util.List;
@Data
public class ClienteDto {

    private String nombre;
    private String apellido;
    private String dni;
    private List<Venta> ventas;
}
