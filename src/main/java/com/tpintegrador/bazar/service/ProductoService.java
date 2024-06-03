package com.tpintegrador.bazar.service;

import com.tpintegrador.bazar.model.Dto.ProductoDto;
import com.tpintegrador.bazar.model.Producto;
import com.tpintegrador.bazar.repository.IProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductoService implements IProductoService{

    final IProductoRepository productoRepository;

    public ProductoService(IProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }


    @Override
    public List<Producto> getProductos() {
        return productoRepository.findAll();
    }

    @Override
    public void saveProducto(ProductoDto productoDto) {
        Producto producto = Producto.builder()
                .nombre(productoDto.getNombre())
                .costo(productoDto.getCosto())
                .marca(productoDto.getMarca())
                .cantidadDisponible(productoDto.getCantidadDisponible())
                .build();
        productoRepository.save(producto);
    }

    @Override
    public void deleteProducto(Long id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
        }
        else {
            throw new IllegalArgumentException("El producto con id: " + id + " no existe");
        }
    }

    @Override
    public Producto getProducto(Long id) {
        if (productoRepository.existsById(id)) {
            return productoRepository.findById(id).orElse(null);
        }
        else {
            throw new IllegalArgumentException("El producto con ID: "+ id + " no existe");
        }
    }

    @Override
    public void updateProducto(ProductoDto productoDto, Long codigoProducto) {

        if (productoRepository.findById(codigoProducto).isPresent()) {
            Producto productoGuardado = productoRepository.findById(codigoProducto).get();
            productoGuardado.setNombre(productoDto.getNombre());
            productoGuardado.setMarca(productoDto.getMarca());
            productoGuardado.setCosto(productoDto.getCosto());
            productoGuardado.setCantidadDisponible(productoDto.getCantidadDisponible());
            productoRepository.save(productoGuardado);
        }
        else {
            throw new IllegalArgumentException("El producto con ID: "+ codigoProducto + " no existe");
        }
    }

    @Override
    public List<Producto> faltaStock() {
        List<Producto> listaProductos = productoRepository.findAll();
        listaProductos.removeIf(producto -> (producto.getCantidadDisponible() >= 5));
        return listaProductos;
    }
}
