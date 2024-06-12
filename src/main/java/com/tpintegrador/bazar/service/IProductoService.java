package com.tpintegrador.bazar.service;

import com.tpintegrador.bazar.model.dto.ProductoDto;
import com.tpintegrador.bazar.model.Producto;

import java.util.List;

public interface IProductoService {

    List<Producto> getProductos();

    void saveProducto(ProductoDto productoDto);

    void deleteProducto(Long id);

    Producto getProducto(Long id);

    void updateProducto(ProductoDto productoDto, Long codigoProducto);

    List<Producto> faltaStock();
}
