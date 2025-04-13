package com.sistema.matriculas.repository;

import com.sistema.matriculas.model.Matricula;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaRepository extends MongoRepository<Matricula, String> {
    // Aquí ya viene incluido save(), findById(), findAll(), etc.
}
