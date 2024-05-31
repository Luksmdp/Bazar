package com.tpintegrador.bazar.service;

import com.tpintegrador.bazar.model.Dto.VentaDto;
import com.tpintegrador.bazar.model.Producto;
import com.tpintegrador.bazar.model.Venta;
import com.tpintegrador.bazar.repository.IClienteRepository;
import com.tpintegrador.bazar.repository.IProductoRepository;
import com.tpintegrador.bazar.repository.IVentaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public void saveVenta(VentaDto ventaDto) throws Exception {
        if (clienteRepository.existsById(ventaDto.getIdCliente())) {
            if (ventaDto.getListaProductos() != null && !ventaDto.getListaProductos().isEmpty()) {
                List<Producto> listaProductos = new ArrayList<>();
                for (Long producto : ventaDto.getListaProductos()) {
                    if (productoRepository.existsById(producto)) {
                        listaProductos.add(productoRepository.findById(producto).orElse(null));
                    } else {
                        throw new IllegalArgumentException("El producto con ID: " + producto + " no existe");
                    }
                }
                Venta venta = Venta.builder()
                        .fechaVenta(ventaDto.getFechaVenta())
                        .total(ventaDto.getTotal())
                        .fechaVenta(ventaDto.getFechaVenta())
                        .total(ventaDto.getTotal())
                        .unCliente(clienteRepository.findById(ventaDto.getIdCliente()).orElse(null))
                        .listaProductos(listaProductos)
                        .build();
                this.procesarVenta(venta);
            }
            else {
                throw new IllegalArgumentException("La lista de productos no puede estar vacia");
            }
        }
        else {
            throw new IllegalArgumentException("El cliente con ID: "+ ventaDto.getIdCliente() + " no existe");
        }
    }
    @Transactional(rollbackFor = Exception.class)
    public void procesarVenta(Venta venta) throws Exception {
        for (Producto producto: venta.getListaProductos()){
            Producto productoGuardado = productoRepository.findById(producto.getCodigoProducto())
                    .orElseThrow(() -> new Exception("El producto con ID: "+ producto.getCodigoProducto() + " no existe"));
                if (productoGuardado.getCantidadDisponible()>=1){

                    productoGuardado.setCantidadDisponible(productoGuardado.getCantidadDisponible()- 1);
                    productoRepository.save(productoGuardado);
                }
                else {
                    throw new Exception("Insuficiente cantidad del producto: "+ producto.getNombre());
                }
        }
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
        Optional<Venta> ventaGuardada = ventaRepository.findById(codigoVenta);

        if (ventaGuardada.isPresent()){
            if (clienteRepository.existsById(ventaDto.getIdCliente())) {
                if (ventaDto.getListaProductos() != null && !ventaDto.getListaProductos().isEmpty()) {
                    List<Producto> listaProductos = new ArrayList<>();
                    for (Long producto : ventaDto.getListaProductos()) {
                        if (productoRepository.existsById(producto)) {
                            listaProductos.add(productoRepository.findById(producto).orElse(null));
                        } else {
                            throw new IllegalArgumentException("El producto con ID: " + producto + " no existe");
                        }
                    }
                    Venta venta = Venta.builder()
                            .codigoVenta(ventaGuardada.get().getCodigoVenta())
                            .fechaVenta(ventaDto.getFechaVenta())
                            .total(ventaDto.getTotal())
                            .fechaVenta(ventaDto.getFechaVenta())
                            .total(ventaDto.getTotal())
                            .unCliente(clienteRepository.findById(ventaDto.getIdCliente()).orElse(null))
                            .listaProductos(listaProductos)
                            .build();
                    ventaRepository.save(venta);
                }
                else {
                    throw new IllegalArgumentException("La lista de productos no puede estar vacia");
                }
            }
            else {
                throw new IllegalArgumentException("El cliente con ID: "+ ventaDto.getIdCliente() + " no existe");
            }
        }
        else {
            throw new IllegalArgumentException("La venta con ID: "+ codigoVenta + " no existe");
        }
    }

}
