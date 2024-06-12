package com.tpintegrador.bazar.service;

import com.tpintegrador.bazar.model.dto.MayorVentaDto;
import com.tpintegrador.bazar.model.dto.MontoFechaDto;
import com.tpintegrador.bazar.model.dto.VentaDto;
import com.tpintegrador.bazar.model.Venta;
import com.tpintegrador.bazar.model.VentaDetalle;

import java.time.LocalDate;
import java.util.List;

public interface IVentaService {

    List<Venta> getVentas();

    void saveVenta(VentaDto ventaDto) throws Exception;

    void deleteVenta(Long id);

    Venta getVenta(Long id);

    void updateVenta(VentaDto ventaDto, Long codigoVenta);

    List<VentaDetalle> getProductosDeVenta(Long codigoVenta);

    MontoFechaDto getVentasPorDia(LocalDate fechaVenta);

    MayorVentaDto getMayorVenta();
}
