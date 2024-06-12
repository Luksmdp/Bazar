package com.tpintegrador.bazar.service;

import com.tpintegrador.bazar.model.Cliente;
import com.tpintegrador.bazar.model.dto.ClienteDto;

import java.util.List;

public interface IClienteService {

    List<Cliente> getClientes();

    void saveCliente(ClienteDto clienteDto);

    void deleteCliente(Long id);

    Cliente getCliente(Long id);

    void updateCliente(ClienteDto clienteDto, Long idCliente);
}
