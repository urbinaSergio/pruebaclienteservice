package com.primer.micro.clienteservice.infrastructure.adapter.out.persistence;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataClienteRepository
        extends JpaRepository<ClienteEntity, Long> {

    Optional<ClienteEntity> findByClientId(String clientId);

    Optional<ClienteEntity> findByIdentificacion(String identificacion);


}
