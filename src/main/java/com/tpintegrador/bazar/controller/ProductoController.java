package com.tpintegrador.bazar.controller;

import com.tpintegrador.bazar.model.Producto;
import com.tpintegrador.bazar.service.IProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {

    final IProductoService productoService;

    public ProductoController(IProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("productos")
    public List<Producto> getProductos(){
        return productoService.getProductos();
    }

    @GetMapping("productos/{codigoProducto}")
    public Producto getProducto(@PathVariable Long codigoProducto){
        return productoService.getProducto(codigoProducto);
    }

    @PostMapping("productos/crear")
    public void saveProducto(@RequestBody Producto producto){
        productoService.saveProducto(producto);
    }

    @DeleteMapping("productos/eliminar/{codigoProducto}")
    public void deleteProducto(@PathVariable Long codigoProducto){
        productoService.deleteProducto(codigoProducto);
    }

    @PutMapping("productos/editar/{codigoProducto}")
    public void updateProducto(@RequestBody Producto producto){
        productoService.updateProducto(producto);
    }
}
