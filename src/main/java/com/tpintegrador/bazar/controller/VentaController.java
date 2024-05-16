package com.tpintegrador.bazar.controller;

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

    @PostMapping("ventas/crear")
    public void saveVenta(@RequestBody Venta venta){
        ventaService.saveVenta(venta);
    }

    @DeleteMapping("ventas/eliminar/{codigoVenta}")
    public void deleteVenta(@PathVariable Long codigoVenta){
        ventaService.deleteVenta(codigoVenta);
    }

    @PutMapping("ventas/editar/{codigoVenta}")
    public void updateVenta(@RequestBody Venta venta){
        ventaService.updateVenta(venta);
    }
}
