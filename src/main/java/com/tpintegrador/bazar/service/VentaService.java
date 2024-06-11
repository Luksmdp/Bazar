package com.tpintegrador.bazar.service;

import com.tpintegrador.bazar.model.Cliente;
import com.tpintegrador.bazar.model.Dto.VentaDetalleDto;
import com.tpintegrador.bazar.model.Dto.VentaDto;
import com.tpintegrador.bazar.model.Producto;
import com.tpintegrador.bazar.model.Venta;
import com.tpintegrador.bazar.model.VentaDetalle;
import com.tpintegrador.bazar.repository.IClienteRepository;
import com.tpintegrador.bazar.repository.IProductoRepository;
import com.tpintegrador.bazar.repository.IVentaDetalleRepository;
import com.tpintegrador.bazar.repository.IVentaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class VentaService implements IVentaService{
    final IVentaRepository ventaRepository;
    final IClienteRepository clienteRepository;
    final IProductoRepository productoRepository;
    final IVentaDetalleRepository ventaDetalleRepository;

    public VentaService(IVentaRepository ventaRepository, IClienteRepository clienteRepository, IProductoRepository productoRepository, IVentaDetalleRepository ventaDetalleRepository) {
        this.ventaRepository = ventaRepository;
        this.clienteRepository = clienteRepository;
        this.productoRepository = productoRepository;
        this.ventaDetalleRepository = ventaDetalleRepository;
    }

    @Override
    public List<Venta> getVentas() {
        return ventaRepository.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveVenta(VentaDto ventaDto) throws Exception {
        Cliente cliente = clienteRepository.findById(ventaDto.getIdCliente()).orElseThrow(
                () -> new IllegalArgumentException("El cliente con ID: " + ventaDto.getIdCliente() + " no existe")
        );

        List<VentaDetalle> ventaDetalleList = new ArrayList<>();

        Venta venta = Venta.builder()
                .fechaVenta(ventaDto.getFechaVenta())
                .total(ventaDto.getTotal())
                .unCliente(cliente)
                .listaVentaDetalle(ventaDetalleList)
                .build();

        if (ventaDto.getVentaDetalleDto() == null || ventaDto.getVentaDetalleDto().isEmpty()) {
            throw new IllegalArgumentException("La lista de VentaDetalle no puede estar vacía");
        }

        venta = ventaRepository.save(venta);


        for (VentaDetalleDto ventaDetalleDto : ventaDto.getVentaDetalleDto()) {

            Producto productoGuardado = productoRepository.findById(ventaDetalleDto.getCodigoProducto()).orElseThrow(
                    () -> new IllegalArgumentException("El producto con ID: " + ventaDetalleDto.getCodigoProducto() + " no existe")
            );

            if (productoGuardado.getCantidadDisponible() < ventaDetalleDto.getCantidadProducto()) {
                throw new Exception("Insuficiente cantidad del producto: " + productoGuardado.getNombre());
            }

            productoGuardado.setCantidadDisponible(productoGuardado.getCantidadDisponible() - ventaDetalleDto.getCantidadProducto());
            productoRepository.save(productoGuardado);


            VentaDetalle ventaDetalle = VentaDetalle.builder()
                    .venta(venta)
                    .producto(productoGuardado)
                    .cantidadProducto(ventaDetalleDto.getCantidadProducto())
                    .build();
            ventaDetalleRepository.save(ventaDetalle);
            ventaDetalleList.add(ventaDetalle);

        }

        venta.setListaVentaDetalle(ventaDetalleList);
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
        /*Optional<Venta> ventaGuardada = ventaRepository.findById(codigoVenta);

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
        }*/
    }

    @Override
    public List<Producto> getProductosDeVenta(Long codigoVenta) {
        /*if (ventaRepository.findById(codigoVenta).isPresent()) {
            List<Producto> listaProductos = ventaRepository.findById(codigoVenta).get().getListaProductos();
            return listaProductos;
        }else {
            throw new IllegalArgumentException("La venta con ID: " +codigoVenta+ " no existe");
        }*/
        return null;
    }

}
