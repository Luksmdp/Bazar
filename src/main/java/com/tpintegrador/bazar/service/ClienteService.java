package com.tpintegrador.bazar.service;

import com.tpintegrador.bazar.model.Cliente;
import com.tpintegrador.bazar.model.dto.ClienteDto;
import com.tpintegrador.bazar.repository.IClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClienteService implements IClienteService{

    final IClienteRepository clienteRepository;

    public ClienteService(IClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public void saveCliente(ClienteDto clienteDto) {
        Cliente cliente = Cliente.builder()
                .dni(clienteDto.getDni())
                .nombre(clienteDto.getNombre())
                .apellido(clienteDto.getApellido())
                .build();
        clienteRepository.save(cliente);
    }

    @Override
    public void deleteCliente(Long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
        }
        else {
            throw new IllegalArgumentException("El cliente con id: " + id + " no existe");
        }
    }

    @Override
    public Cliente getCliente(Long id) {
        if (clienteRepository.existsById(id)) {
            return clienteRepository.findById(id).orElse(null);
        }
        else {
            throw new IllegalArgumentException("El cliente con id: " + id + " no existe");
        }
    }

    @Override
    public void updateCliente(ClienteDto clienteDto, Long idCliente) {

        if (clienteRepository.findById(idCliente).isPresent()){
            Cliente clienteGuardado = clienteRepository.findById(idCliente).orElse(null);
            clienteGuardado.setDni(clienteDto.getDni());
            clienteGuardado.setNombre(clienteDto.getNombre());
            clienteGuardado.setApellido(clienteDto.getApellido());
            clienteRepository.save(clienteGuardado);
        }
        else {
            throw new IllegalArgumentException("El cliente con id: " + idCliente + " no existe");
        }
    }
}
