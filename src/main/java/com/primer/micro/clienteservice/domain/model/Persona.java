package com.primer.micro.clienteservice.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Persona {

    protected Long id;
    protected String nombre;
    protected String genero;
    protected Integer edad;
    protected String identificacion;
    protected String direccion;
    protected String telefono;

    // Constructor
    public Persona(Long id, String nombre, String genero, Integer edad,
                   String identificacion, String direccion, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Persona() {}
}
