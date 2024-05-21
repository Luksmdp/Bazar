package com.tpintegrador.bazar.service;

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
    public void saveProducto(Producto producto) {
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
    public void updateProducto(Producto productoNuevo) {
        if (productoRepository.existsById(productoNuevo.getCodigoProducto())) {
            Producto productoViejo = this.getProducto(productoNuevo.getCodigoProducto());
            productoViejo.setCosto(productoNuevo.getCosto());
            productoViejo.setNombre(productoNuevo.getNombre());
            productoViejo.setMarca(productoNuevo.getMarca());
            productoViejo.setCantidadDisponible(productoNuevo.getCantidadDisponible());
            productoRepository.save(productoViejo);
        }
    }
}
