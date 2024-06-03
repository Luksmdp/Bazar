package com.tpintegrador.bazar.controller;

import com.tpintegrador.bazar.model.Dto.VentaDto;
import com.tpintegrador.bazar.model.Producto;
import com.tpintegrador.bazar.model.Venta;
import com.tpintegrador.bazar.service.IVentaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VentaController {

    final IVentaService ventaService;

    public VentaController(IVentaService ventaService) {
        this.ventaService = ventaService;
    }

    @GetMapping("ventas")
    public List<Venta> getVentas(){
        return ventaService.getVentas();
    }

    @GetMapping("ventas/{codigoVenta}")
    public Venta getVenta(@PathVariable Long codigoVenta){
        return ventaService.getVenta(codigoVenta);
    }

    @GetMapping("ventas/productos/{codigoVenta}")
    public List<Producto> getProductosDeVenta(@PathVariable Long codigoVenta){
        return ventaService.getProductosDeVenta(codigoVenta);
    }

    @PostMapping("ventas/crear")
    public void saveVenta(@RequestBody VentaDto ventaDto) throws Exception{
        ventaService.saveVenta(ventaDto);
    }

    @DeleteMapping("ventas/eliminar/{codigoVenta}")
    public void deleteVenta(@PathVariable Long codigoVenta){
        ventaService.deleteVenta(codigoVenta);
    }

    @PutMapping("ventas/editar/{codigoVenta}")
    public void updateVenta(@RequestBody VentaDto ventaDto,@PathVariable Long codigoVenta){
        ventaService.updateVenta(ventaDto,codigoVenta);
    }
}
