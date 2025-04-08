package com.sistema.matriculas.service;

import com.sistema.matriculas.client.Asignatura;
import com.sistema.matriculas.client.AsignaturaClient;
import com.sistema.matriculas.client.Usuario;
import com.sistema.matriculas.client.UsuarioClient;
import com.sistema.matriculas.model.Matricula;
import com.sistema.matriculas.repository.MatriculaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MatriculaService {

    private final MatriculaRepository repository;
    private final UsuarioClient usuarioClient;
    private final AsignaturaClient asignaturaClient;

    public String matricular(String usuarioId, String asignaturaId) {
        System.out.println("📥 Recibido usuarioId: " + usuarioId + ", asignaturaId: " + asignaturaId);

        Usuario usuario = usuarioClient.obtenerUsuario(usuarioId);
        System.out.println("🔍 Usuario obtenido: " + usuario);

        Asignatura asignatura = asignaturaClient.obtenerAsignatura(asignaturaId);
        System.out.println("🔍 Asignatura obtenida: " + asignatura);

        if (usuario == null || asignatura == null) {
            return "❌ No se pudo realizar la matrícula. Usuario o Asignatura no encontrados.";
        }

        Matricula matricula = new Matricula();
        matricula.setUsuarioId(usuarioId);
        matricula.setAsignaturaId(asignaturaId);
        repository.save(matricula);
        System.out.println("💾 Matrícula guardada con éxito.");

        return "✅ Matrícula registrada: " + usuario.getNombre() +
                " fue matriculado en " + asignatura.getNombre();
    }

    public Matricula guardarMatricula(Matricula matricula) {
        return repository.save(matricula);
    }
}
