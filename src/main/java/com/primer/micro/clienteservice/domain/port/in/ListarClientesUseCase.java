package com.primer.micro.clienteservice.domain.port.in;

import com.primer.micro.clienteservice.domain.model.Cliente;

import java.util.List;

public interface ListarClientesUseCase {
    List<Cliente> listar();
}