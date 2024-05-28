package com.tpintegrador.bazar.service;

import com.tpintegrador.bazar.model.Dto.VentaDto;
import com.tpintegrador.bazar.model.Producto;
import com.tpintegrador.bazar.model.Venta;
import com.tpintegrador.bazar.repository.IClienteRepository;
import com.tpintegrador.bazar.repository.IProductoRepository;
import com.tpintegrador.bazar.repository.IVentaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VentaService implements IVentaService{

    final IVentaRepository ventaRepository;
    final IClienteRepository clienteRepository;
    final IProductoRepository productoRepository;

    public VentaService(IVentaRepository ventaRepository, IClienteRepository clienteRepository, IProductoRepository productoRepository) {
        this.ventaRepository = ventaRepository;
        this.clienteRepository = clienteRepository;
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Venta> getVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public void saveVenta(VentaDto ventaDto) {
        Venta venta = new Venta();
        venta.setFechaVenta(ventaDto.getFechaVenta());
        venta.setTotal(ventaDto.getTotal());
        if (clienteRepository.existsById(ventaDto.getIdCliente())) {
            venta.setUnCliente(clienteRepository.findById(ventaDto.getIdCliente()).orElse(null));
        }
        else {
            throw new IllegalArgumentException("El cliente con ID: "+ ventaDto.getIdCliente() + " no existe");
        }
        List<Producto> listaProductos = new ArrayList<>();
        for(Long producto: ventaDto.getListaProductos()){
            if (productoRepository.existsById(producto)){
                listaProductos.add(productoRepository.findById(producto).orElse(null));
            }
            else {
                throw new IllegalArgumentException("El producto con ID: "+ producto + " no existe");
            }
        }
        venta.setListaProductos(listaProductos);
        ventaRepository.save(venta);
    }

    @Override
    public void deleteVenta(Long id) {
        if (ventaRepository.existsById(id)) {
            ventaRepository.deleteById(id);
        }
        else {
            throw new IllegalArgumentException("La venta con ID: "+ id + " no existe");
        }
    }

    @Override
    public Venta getVenta(Long id) {
        if (ventaRepository.findById(id).isPresent()){
        return ventaRepository.findById(id).orElse(null);
        }
        else {
            throw new IllegalArgumentException("La venta con ID: "+ id + " no existe");
        }
    }

    @Override
    public void updateVenta(VentaDto ventaDto, Long codigoVenta) {
        Optional<Venta> ventaguardada = ventaRepository.findById(codigoVenta);

        if (ventaguardada.isPresent()){
            ventaguardada.get().setFechaVenta(ventaDto.getFechaVenta());
            ventaguardada.get().setTotal(ventaDto.getTotal());
            if (clienteRepository.existsById(ventaDto.getIdCliente())) {
                ventaguardada.get().setUnCliente(clienteRepository.findById(ventaDto.getIdCliente()).orElse(null));
            }
            else {
                throw new IllegalArgumentException("El cliente con ID: "+ ventaDto.getIdCliente() + " no existe");
            }
            List<Producto> listaProductos = new ArrayList<>();
            for(Long producto: ventaDto.getListaProductos()){
                if (productoRepository.existsById(producto)){
                    listaProductos.add(productoRepository.findById(producto).orElse(null));
                }
                else {
                    throw new IllegalArgumentException("El producto con ID: "+ producto + " no existe");
                }
            }
            ventaguardada.get().setListaProductos(listaProductos);
            ventaRepository.save(ventaguardada.get());
        }
        else {
            throw new IllegalArgumentException("La venta con ID: "+ codigoVenta + " no existe");
        }
    }

}
