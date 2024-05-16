package com.tpintegrador.bazar.service;

import com.tpintegrador.bazar.model.Cliente;

import java.util.List;

public interface IClienteService {

    public List<Cliente> getClientes();

    public void saveCliente(Cliente cliente);

    public void deleteCliente(Long id);

    public Cliente getCliente(Long id);

    public void updateCliente(Cliente cliente);
}
