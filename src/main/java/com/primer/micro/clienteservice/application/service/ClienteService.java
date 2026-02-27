package com.primer.micro.clienteservice.application.service;

import com.primer.micro.clienteservice.domain.model.Cliente;
import com.primer.micro.clienteservice.domain.port.in.*;
import com.primer.micro.clienteservice.domain.port.out.ClienteRepositoryPort;

import java.util.List;

public class ClienteService implements CrearClienteUseCase, ActualizarClienteUseCase, EliminarClienteUseCase, ListarClientesUseCase, ObtenerClienteUseCase {

    private final ClienteRepositoryPort repository;

    public ClienteService(ClienteRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Cliente crearCliente(Cliente cliente) {

        repository.findByIdentificacion(cliente.getIdentificacion())
                .ifPresent(c -> {
                    throw new RuntimeException("Ya existe un cliente con esa identificación");
                });

        return repository.save(cliente);
    }


    @Override
    public Cliente actualizar(Long id, Cliente cliente) {
        return repository.save(cliente);

    }

    @Override
    public void eliminar(Long id) {
        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        repository.deleteById(cliente.getId());
    }

    @Override
    public List<Cliente> listar() {

        List<Cliente> clientes = repository.findAll();

        if (clientes.isEmpty()) {
            throw new RuntimeException("No existen clientes");
        }

        return clientes;
    }

    @Override
    public Cliente obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ClienteNoEncontradoException(id));
    }

    public class ClienteNoEncontradoException extends RuntimeException {
        public ClienteNoEncontradoException(Long id) {
            super("Cliente no encontrado con id: " + id);
        }
    }
}
