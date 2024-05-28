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
        Producto producto = new Producto();
        producto.setNombre(productoDto.getNombre());
        producto.setCosto(productoDto.getCosto());
        producto.setMarca(productoDto.getMarca());
        producto.setCantidadDisponible(productoDto.getCantidadDisponible());
        productoRepository.save(producto);
    }

    @Override
    public void deleteProducto(Long id) {
        productoRepository.deleteById(id);
    }

    @Override
    public Producto getProducto(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public void updateProducto(ProductoDto productoDto) {

    }
}
