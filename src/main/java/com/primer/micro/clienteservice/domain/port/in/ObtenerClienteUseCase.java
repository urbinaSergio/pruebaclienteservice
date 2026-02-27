package com.primer.micro.clienteservice.domain.port.in;

import com.primer.micro.clienteservice.domain.model.Cliente;

public interface ObtenerClienteUseCase {
    Cliente obtenerPorId(Long id);
}
