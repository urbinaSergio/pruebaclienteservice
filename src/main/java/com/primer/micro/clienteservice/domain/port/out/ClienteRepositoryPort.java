package com.primer.micro.clienteservice.domain.port.out;

import com.primer.micro.clienteservice.domain.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteRepositoryPort {

    Cliente save(Cliente cliente);

    Optional<Cliente> findById(Long id);

    void deleteById(Long id);

    List<Cliente> findAll();

    Optional<Cliente> findByIdentificacion(String identificacion);

}