package com.primer.micro.clienteservice.clienteservices;

import com.primer.micro.clienteservice.application.service.ClienteService;
import com.primer.micro.clienteservice.domain.model.Cliente;
import com.primer.micro.clienteservice.domain.port.out.ClienteRepositoryPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {

    @Mock
    private ClienteRepositoryPort repository;

    @InjectMocks
    private ClienteService clienteService;

    @Test
    void crearCliente_debeGuardarCliente() {

        // GIVEN (datos de prueba)
        Cliente cliente = new Cliente();
        cliente.setIdentificacion("123");
        cliente.setNombre("Juan");

        // Simulamos que no existe cliente con esa identificación
        when(repository.findByIdentificacion("123"))
                .thenReturn(Optional.empty());

        // Simulamos guardado
        when(repository.save(cliente))
                .thenReturn(cliente);

        // WHEN
        Cliente resultado = clienteService.crearCliente(cliente);

        // THEN
        assertNotNull(resultado);
        assertEquals("Juan", resultado.getNombre());
    }
}
