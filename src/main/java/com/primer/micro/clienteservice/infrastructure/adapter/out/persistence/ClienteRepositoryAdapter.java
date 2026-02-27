package com.primer.micro.clienteservice.infrastructure.adapter.out.persistence;

import com.primer.micro.clienteservice.domain.model.Cliente;
import com.primer.micro.clienteservice.domain.port.out.ClienteRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ClienteRepositoryAdapter implements ClienteRepositoryPort {

    private final SpringDataClienteRepository repository;

    public ClienteRepositoryAdapter(SpringDataClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Cliente save(Cliente cliente) {

        ClienteEntity entity;

        if (cliente.getId() == null) {
            // ===== INSERT =====
            entity = mapToEntity(cliente);
        } else {
            // ===== UPDATE =====
            entity = repository.findById(cliente.getId())
                    .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

            // Actualizar campos
            entity.setNombre(cliente.getNombre());
            entity.setGenero(cliente.getGenero());
            entity.setEdad(cliente.getEdad());
            entity.setDireccion(cliente.getDireccion());
            entity.setTelefono(cliente.getTelefono());
            entity.setEstado(cliente.getEstado());
        }

        ClienteEntity saved = repository.save(entity);
        return mapToDomain(saved);
    }



    @Override
    public Optional<Cliente> findById(Long id) {
        return repository.findById(id)
                .map(this::mapToDomain);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Cliente> findAll() {
        return repository.findAll()
                .stream()
                .map(this::mapToDomain)
                .toList();
    }

    @Override
    public Optional<Cliente> findByIdentificacion(String identificacion) {
        return repository.findByIdentificacion(identificacion)
                .map(this::mapToDomain);
    }

    private ClienteEntity mapToEntity(Cliente cliente) {
        ClienteEntity entity = new ClienteEntity();

        // ===== Campos heredados (Persona) =====
        entity.setId(cliente.getId());
        entity.setNombre(cliente.getNombre());
        entity.setGenero(cliente.getGenero());
        entity.setEdad(cliente.getEdad());
        entity.setIdentificacion(cliente.getIdentificacion());
        entity.setDireccion(cliente.getDireccion());
        entity.setTelefono(cliente.getTelefono());

        // ===== Campos propios de Cliente =====
        entity.setClientId(cliente.getClientId());
        entity.setContrasena(cliente.getContrasena());
        entity.setEstado(cliente.getEstado());

        return entity;
    }

    private Cliente mapToDomain(ClienteEntity entity) {
        return new Cliente(
                entity.getId(),
                entity.getNombre(),
                entity.getGenero(),
                entity.getEdad(),
                entity.getIdentificacion(),
                entity.getDireccion(),
                entity.getTelefono(),
                entity.getClientId(),
                entity.getContrasena(),
                entity.getEstado()
        );
    }
}
