package com.tpintegrador.bazar.service;

import com.tpintegrador.bazar.model.Dto.VentaDetalleDto;
import com.tpintegrador.bazar.model.Producto;
import com.tpintegrador.bazar.model.Venta;
import com.tpintegrador.bazar.model.VentaDetalle;
import com.tpintegrador.bazar.repository.IProductoRepository;
import com.tpintegrador.bazar.repository.IVentaDetalleRepository;
import com.tpintegrador.bazar.repository.IVentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaDetalleService implements IVentaDetalleService {

    final IVentaDetalleRepository ventaDetalleRepository;
    final IProductoRepository productoRepository;
    final IVentaRepository ventaRepository;

    public VentaDetalleService(IVentaDetalleRepository ventaDetalleRepository, IProductoRepository productoRepository, IVentaRepository ventaRepository) {
        this.ventaDetalleRepository = ventaDetalleRepository;
        this.productoRepository = productoRepository;
        this.ventaRepository = ventaRepository;
    }

    @Override
    public List<VentaDetalle> getVentaDetalle() {
        return null;
    }

    @Override
    public void saveVentaDetalle(VentaDetalleDto ventaDetalleDto) {
        Producto producto = productoRepository.findById(ventaDetalleDto.getCodigoProducto()).orElseThrow(
                () -> new IllegalArgumentException("El Producto con Id: " +ventaDetalleDto.getCodigoProducto()+
                        " No existe" ));

        Venta venta = ventaRepository.findById(ventaDetalleDto.getCodigoVenta()).orElseThrow(
                () -> new IllegalArgumentException("La Venta con Id: " +ventaDetalleDto.getCodigoVenta()+
                        " No existe" ));

        VentaDetalle ventaDetalle = VentaDetalle.builder()
                .venta(venta)
                .producto(producto)
                .cantidadProducto(ventaDetalleDto.getCantidadProducto())
                .build();
        ventaDetalleRepository.save(ventaDetalle);
    }

    @Override
    public void deleteVentaDetalle(Long id) {

    }

    @Override
    public VentaDetalle getVentaDetalle(Long id) {
        return null;
    }

    @Override
    public void updateVentaDetalle(VentaDetalleDto ventaDetalleDto, Long idVentaDetalle) {

    }
}
