package com.sistema.matriculas.model;

import lombok.Data;

@Data
public class Usuario {
    private String id;
    private String nombre;
    private String tipo; // estudiante o docente
}
