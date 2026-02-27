package com.primer.micro.clienteservice.domain.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente extends Persona {

    private String clientId;
    private String contrasena;
    private String estado;

    public Cliente(Long id, String nombre, String genero, Integer edad,
                   String identificacion, String direccion, String telefono,
                   String clientId, String contrasena, String estado) {

        super(id, nombre, genero, edad, identificacion, direccion, telefono);
        this.clientId = clientId;
        this.contrasena = contrasena;
        this.estado = estado;
    }

    public Cliente() {}
}
