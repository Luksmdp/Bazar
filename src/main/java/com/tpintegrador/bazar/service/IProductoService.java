package com.tpintegrador.bazar.service;

import com.tpintegrador.bazar.model.Dto.ProductoDto;
import com.tpintegrador.bazar.model.Producto;

import java.util.List;

public interface IProductoService {

    public List<Producto> getProductos();

    public void saveProducto(ProductoDto productoDto);

    public void deleteProducto(Long id);

    public Producto getProducto(Long id);

    public void updateProducto(ProductoDto productoDto, Long codigoProducto);
}
