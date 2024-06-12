package com.tpintegrador.bazar.service;

import com.tpintegrador.bazar.model.dto.VentaDetalleDto;
import com.tpintegrador.bazar.model.VentaDetalle;

import java.util.List;

public interface IVentaDetalleService {

    List<VentaDetalle> getVentaDetalle();

    void saveVentaDetalle(VentaDetalleDto ventaDetalleDto);

    void deleteVentaDetalle(Long id);

    VentaDetalle getVentaDetalle(Long id);

    void updateVentaDetalle(VentaDetalleDto ventaDetalleDto, Long idVentaDetalle);
}
