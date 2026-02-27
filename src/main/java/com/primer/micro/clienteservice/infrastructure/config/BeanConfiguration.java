package com.primer.micro.clienteservice.infrastructure.config;

import com.primer.micro.clienteservice.application.service.ClienteService;
import com.primer.micro.clienteservice.domain.port.in.CrearClienteUseCase;
import com.primer.micro.clienteservice.domain.port.out.ClienteRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CrearClienteUseCase crearClienteUseCase(ClienteRepositoryPort repositoryPort) {
        return new ClienteService(repositoryPort);
    }
}
