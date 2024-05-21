package com.tpintegrador.bazar.service;

import com.tpintegrador.bazar.model.Cliente;
import com.tpintegrador.bazar.model.Venta;
import com.tpintegrador.bazar.repository.IVentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VentaService implements IVentaService{

    final IVentaRepository ventaRepository;

    public VentaService(IVentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    @Override
    public List<Venta> getVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public void saveVenta(Venta venta) {
        ventaRepository.save(venta);
    }

    @Override
    public void deleteVenta(Long id) {
        ventaRepository.deleteById(id);
    }

    @Override
    public Venta getVenta(Long id) {
        return ventaRepository.findById(id).orElse(null);
    }

    @Override
    public void updateVenta(Venta ventaNueva) {
        if (ventaRepository.existsById(ventaNueva.getCodigoVenta())){
            Venta ventaVieja = this.getVenta(ventaNueva.getCodigoVenta());
            ventaVieja.setFechaVenta(ventaNueva.getFechaVenta());
            ventaVieja.setTotal(ventaNueva.getTotal());
            ventaVieja.setUnCliente(ventaNueva.getUnCliente());
            ventaVieja.setListaProductos(ventaNueva.getListaProductos());
            this.saveVenta(ventaVieja);
        }
    }
}
