package com.sistema.matriculas.service;

import com.sistema.matriculas.client.AsignaturaClient;
import com.sistema.matriculas.client.UsuarioClient;
import com.sistema.matriculas.model.Asignatura;
import com.sistema.matriculas.model.Matricula;
import com.sistema.matriculas.model.Usuario;
import com.sistema.matriculas.repository.MatriculaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;
    private final UsuarioClient usuarioClient;
    private final AsignaturaClient asignaturaClient;

    public String matricular(String usuarioId, String asignaturaId) {
        Usuario usuario = usuarioClient.obtenerUsuarioPorId(usuarioId);
        Asignatura asignatura = asignaturaClient.obtenerAsignaturaPorId(asignaturaId);

        if (usuario == null || asignatura == null) {
            return "Usuario o asignatura no encontrados";
        }

        Matricula matricula = new Matricula();
        matricula.setUsuarioId(usuario.getId());
        matricula.setAsignaturaId(asignatura.getId());

        matriculaRepository.save(matricula);

        return "Matrícula completada: " + usuario.getNombre() + " en " + asignatura.getNombre();
    }
}
