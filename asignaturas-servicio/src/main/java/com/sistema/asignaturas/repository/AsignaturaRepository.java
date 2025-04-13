package com.sistema.asignaturas.repository;

import com.sistema.asignaturas.model.Asignatura;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AsignaturaRepository extends MongoRepository<Asignatura, String> {
}
