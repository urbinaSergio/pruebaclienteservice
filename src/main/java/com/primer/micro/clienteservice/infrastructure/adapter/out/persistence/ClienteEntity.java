package com.primer.micro.clienteservice.infrastructure.adapter.out.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "cliente")
@PrimaryKeyJoinColumn(name = "id")
public class ClienteEntity extends PersonaEntity {

    @Column(unique = true)
    private String clientId;

    private String contrasena;
    private String estado;
}