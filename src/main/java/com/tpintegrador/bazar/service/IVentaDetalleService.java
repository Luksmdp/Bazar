package com.tpintegrador.bazar.service;

import com.tpintegrador.bazar.model.Cliente;
import com.tpintegrador.bazar.model.Dto.ClienteDto;
import com.tpintegrador.bazar.model.Dto.VentaDetalleDto;
import com.tpintegrador.bazar.model.VentaDetalle;

import java.util.List;

public interface IVentaDetalleService {

    List<VentaDetalle> getVentaDetalle();

    void saveVentaDetalle(VentaDetalleDto ventaDetalleDto);

    void deleteVentaDetalle(Long id);

    VentaDetalle getVentaDetalle(Long id);

    void updateVentaDetalle(VentaDetalleDto ventaDetalleDto, Long idVentaDetalle);
}
