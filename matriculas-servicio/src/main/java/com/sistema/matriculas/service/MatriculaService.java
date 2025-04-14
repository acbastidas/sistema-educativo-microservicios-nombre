package com.sistema.matriculas.service;

import com.sistema.matriculas.client.UsuarioClient;
import com.sistema.matriculas.client.AsignaturaClient;
import com.sistema.matriculas.model.Matricula;
import com.sistema.matriculas.repository.MatriculaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;
    private final UsuarioClient usuarioClient;
    private final AsignaturaClient asignaturaClient;

    // Registra una nueva matrícula validando primero que el usuario y la asignatura
    // existen
    public String matricular(String usuarioId, String asignaturaId) {
        // Validaciones usando FeignClient (simula que existen)
        usuarioClient.obtenerUsuario(usuarioId);
        asignaturaClient.obtenerAsignatura(asignaturaId);

        Matricula matricula = new Matricula(
                UUID.randomUUID().toString(),
                usuarioId,
                asignaturaId);
        matriculaRepository.save(matricula);
        return "Matrícula registrada con éxito";
    }

    // Retorna todas las matrículas almacenadas
    public List<Matricula> obtenerTodas() {
        return matriculaRepository.findAll();
    }

    // Método auxiliar para guardar una matrícula directamente (usado en tests)
    public Matricula guardarMatricula(Matricula matricula) {
        return matriculaRepository.save(matricula);
    }
}
