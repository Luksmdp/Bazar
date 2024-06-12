package com.tpintegrador.bazar.controller;

import com.tpintegrador.bazar.model.dto.MayorVentaDto;
import com.tpintegrador.bazar.model.dto.MontoFechaDto;
import com.tpintegrador.bazar.model.dto.VentaDto;
import com.tpintegrador.bazar.model.Venta;
import com.tpintegrador.bazar.model.VentaDetalle;
import com.tpintegrador.bazar.service.IVentaService;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@Validated
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
    public List<VentaDetalle> getProductosDeVenta(@Valid @PathVariable Long codigoVenta){
        return ventaService.getProductosDeVenta(codigoVenta);
    }

    @PostMapping("ventas/crear")
    public void saveVenta(@Valid @RequestBody VentaDto ventaDto) throws Exception{
        ventaService.saveVenta(ventaDto);
    }

    @DeleteMapping("ventas/eliminar/{codigoVenta}")
    public void deleteVenta(@Valid @PathVariable Long codigoVenta){
        ventaService.deleteVenta(codigoVenta);
    }

    @PutMapping("ventas/editar/{codigoVenta}")
    public void updateVenta(@Valid @RequestBody VentaDto ventaDto,@Valid @PathVariable Long codigoVenta){
        ventaService.updateVenta(ventaDto,codigoVenta);
    }

    @GetMapping("ventas/dia/{fechaVenta}")
    public MontoFechaDto getVentasPorDia(@Valid @PathVariable LocalDate fechaVenta){
        return ventaService.getVentasPorDia(fechaVenta);
    }

    @GetMapping("ventas/mayor_venta")
    public MayorVentaDto getMayorVenta(){
        return ventaService.getMayorVenta();
    }

}
