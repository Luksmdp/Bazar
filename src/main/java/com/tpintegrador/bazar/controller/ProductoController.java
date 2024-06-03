package com.tpintegrador.bazar.controller;

import com.tpintegrador.bazar.model.Dto.ProductoDto;
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

    @GetMapping("productos/falta_stock")
    public List<Producto> faltaStock(){
        return productoService.faltaStock();
    }

    @PostMapping("productos/crear")
    public void saveProducto(@RequestBody ProductoDto productoDto){
        productoService.saveProducto(productoDto);
    }

    @DeleteMapping("productos/eliminar/{codigoProducto}")
    public void deleteProducto(@PathVariable Long codigoProducto){
        productoService.deleteProducto(codigoProducto);
    }

    @PutMapping("productos/editar/{codigoProducto}")
    public void updateProducto(@RequestBody ProductoDto productoDto,@PathVariable Long codigoProducto){
        productoService.updateProducto(productoDto,codigoProducto);
    }
}
