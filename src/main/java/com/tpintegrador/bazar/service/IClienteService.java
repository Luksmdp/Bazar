package com.tpintegrador.bazar.service;

import com.tpintegrador.bazar.model.Cliente;
import com.tpintegrador.bazar.model.Dto.ClienteDto;

import java.util.List;

public interface IClienteService {

    public List<Cliente> getClientes();

    public void saveCliente(ClienteDto clienteDto);

    public void deleteCliente(Long id);

    public Cliente getCliente(Long id);

    public void updateCliente(ClienteDto clienteDto);
}
