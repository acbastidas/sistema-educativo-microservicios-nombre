package com.sistema.asignaturas.service;

import com.sistema.asignaturas.model.Asignatura;
import com.sistema.asignaturas.repository.AsignaturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsignaturaService {

    private final AsignaturaRepository repository;

    public AsignaturaService(AsignaturaRepository repository) {
        this.repository = repository;
    }

    public List<Asignatura> obtenerTodas() {
        return repository.findAll();
    }

    public Optional<Asignatura> obtenerPorId(String id) {
        return repository.findById(id);
    }

    public Asignatura guardar(Asignatura asignatura) {
        return repository.save(asignatura);
    }

    public void eliminar(String id) {
        repository.deleteById(id);
    }
}