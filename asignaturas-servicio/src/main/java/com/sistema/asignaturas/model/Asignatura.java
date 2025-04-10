package com.sistema.asignaturas.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "asignaturas")
public class Asignatura {

    @Id
    private String id;

    private String nombre;
    private String descripcion;
    private int creditos;
}