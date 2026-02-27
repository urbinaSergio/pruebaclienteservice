package com.primer.micro.clienteservice.infrastructure.adapter.in.rest;

import com.primer.micro.clienteservice.domain.model.Cliente;
import com.primer.micro.clienteservice.domain.port.in.*;
import com.primer.micro.clienteservice.infrastructure.adapter.in.dto.ActualizarClienteRequest;
import com.primer.micro.clienteservice.infrastructure.adapter.in.dto.CrearClienteRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final CrearClienteUseCase crearClienteUseCase;

    private final ActualizarClienteUseCase  actualizarClienteUseCase;

    private final EliminarClienteUseCase eliminarClienteUseCase;

    private final ListarClientesUseCase listarClientesUseCase;

    private final ObtenerClienteUseCase obtenerClienteUseCase;



    public ClienteController(CrearClienteUseCase crearClienteUseCase, ActualizarClienteUseCase actualizarClienteUseCase, EliminarClienteUseCase eliminarClienteUseCase, ListarClientesUseCase listarClientesUseCase, ObtenerClienteUseCase obtenerClienteUseCase) {
        this.crearClienteUseCase = crearClienteUseCase;
        this.actualizarClienteUseCase = actualizarClienteUseCase;
        this.eliminarClienteUseCase = eliminarClienteUseCase;
        this.listarClientesUseCase = listarClientesUseCase;
        this.obtenerClienteUseCase = obtenerClienteUseCase;
    }

    @PostMapping("/crear")
    public ResponseEntity<Cliente> crear(@RequestBody CrearClienteRequest request) {

        Cliente cliente = new Cliente(
                null,
                request.nombre,
                request.genero,
                request.edad,
                request.identificacion,
                request.direccion,
                request.telefono,
                request.clientId,
                request.contrasena,
                request.estado
        );

        return ResponseEntity.ok(crearClienteUseCase.crearCliente(cliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizar(
            @PathVariable Long id,
            @RequestBody ActualizarClienteRequest request) {

        Cliente cliente = new Cliente(
                id,
                request.nombre,
                request.genero,
                request.edad,
                null,
                request.direccion,
                request.telefono,
                null,
                null,
                request.estado
        );

        return ResponseEntity.ok(actualizarClienteUseCase.actualizar(id, cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        eliminarClienteUseCase.eliminar(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listar() {
        return ResponseEntity.ok(listarClientesUseCase.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(obtenerClienteUseCase.obtenerPorId(id));
    }
}
