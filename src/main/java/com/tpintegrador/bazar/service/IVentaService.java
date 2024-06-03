package com.tpintegrador.bazar.service;

import com.tpintegrador.bazar.model.Dto.VentaDto;
import com.tpintegrador.bazar.model.Producto;
import com.tpintegrador.bazar.model.Venta;

import java.util.List;

public interface IVentaService {

    List<Venta> getVentas();

    void saveVenta(VentaDto ventaDto) throws Exception;

    void deleteVenta(Long id);

    Venta getVenta(Long id);

    void updateVenta(VentaDto ventaDto, Long codigoVenta);

    List<Producto> getProductosDeVenta(Long codigoVenta);
}
