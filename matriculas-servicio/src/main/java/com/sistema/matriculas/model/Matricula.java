package com.sistema.matriculas.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "matriculas")
public class Matricula {
    @Id
    private String id;
    private String usuarioId;
    private String asignaturaId;
}
