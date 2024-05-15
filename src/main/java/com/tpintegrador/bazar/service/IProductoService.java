package com.tpintegrador.bazar.service;

import com.tpintegrador.bazar.model.Producto;

import java.util.List;

public interface IProductoService {

    public List<Producto> getProductos();

    public void saveProducto(Producto producto);

    public void deleteProducto(Long id);

    public Producto getProducto(Long id);

    public void updateProducto(Producto producto);
}
