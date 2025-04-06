package com.sistema.matriculas.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "matriculas")
public class Matricula {

    @Id
    private String id;

    private String usuarioId;
    private String asignaturaId;

    // Lombok con @Data genera automáticamente los getters y setters
}
