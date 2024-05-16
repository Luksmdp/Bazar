package com.tpintegrador.bazar.service;

import com.tpintegrador.bazar.model.Cliente;
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
    public void saveCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public Cliente getCliente(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public void updateCliente(Cliente clienteNuevo) {
        if (clienteRepository.existsById(clienteNuevo.getIdCliente())) {
            Cliente clienteViejo = this.getCliente(clienteNuevo.getIdCliente());
            clienteViejo.setNombre(clienteNuevo.getNombre());
            clienteViejo.setApellido(clienteNuevo.getApellido());
            clienteViejo.setDni(clienteNuevo.getDni());
            clienteRepository.save(clienteViejo);
        }
    }
}
