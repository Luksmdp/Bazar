package com.tpintegrador.bazar.service;

import com.tpintegrador.bazar.model.Cliente;
import com.tpintegrador.bazar.model.Dto.VentaDto;
import com.tpintegrador.bazar.model.Venta;

import java.util.List;

public interface IVentaService {

    public List<Venta> getVentas();

    public void saveVenta(VentaDto ventaDto);

    public void deleteVenta(Long id);

    public Venta getVenta(Long id);

    public void updateVenta(VentaDto ventaDto, Long codigoVenta);
}
