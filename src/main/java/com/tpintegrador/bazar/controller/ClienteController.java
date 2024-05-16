package com.tpintegrador.bazar.controller;

import com.tpintegrador.bazar.model.Cliente;
import com.tpintegrador.bazar.service.IClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ClienteController {

    final IClienteService clienteService;

    public ClienteController(IClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("clientes")
    public List<Cliente> getClientes(){
        return clienteService.getClientes();
    }

    @GetMapping("clientes/{idCliente}")
    public Cliente getCliente(@PathVariable Long idCliente){
        return clienteService.getCliente(idCliente);
    }

    @PostMapping("clientes/crear")
    public void saveCliente(@RequestBody Cliente cliente){
        clienteService.saveCliente(cliente);
    }

    @DeleteMapping("clientes/eliminar/{idCliente}")
    public void deleteCliente(@PathVariable Long idCliente){
        clienteService.deleteCliente(idCliente);
    }

    @PutMapping("clientes/editar/{idCliente}")
    public void updateCliente(@RequestBody Cliente cliente){
        clienteService.updateCliente(cliente);
    }
}
