package com.primer.micro.clienteservice.domain.port.in;

import com.primer.micro.clienteservice.domain.model.Cliente;

public interface ActualizarClienteUseCase {

    Cliente actualizar(Long id, Cliente cliente);
}
