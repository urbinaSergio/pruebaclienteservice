package com.primer.micro.clienteservice.domain.port.in;

import com.primer.micro.clienteservice.domain.model.Cliente;

public interface CrearClienteUseCase {

    Cliente crearCliente(Cliente cliente);
}
