package com.sistema.matriculas.servicio;

import com.sistema.matriculas.cliente.UsuarioClient;
import com.sistema.matriculas.cliente.AsignaturaClient;
import com.sistema.matriculas.entidad.Matricula;
import com.sistema.matriculas.repositorio.MatriculaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class MatriculaServiceTest {

    private final MatriculaRepository repository = mock(MatriculaRepository.class);
    private final UsuarioClient usuarioClient = mock(UsuarioClient.class);
    private final AsignaturaClient asignaturaClient = mock(AsignaturaClient.class);

    private final MatriculaService service = new MatriculaService(repository, usuarioClient, asignaturaClient);

    @Test
    void testGuardarMatricula() {
        Matricula matricula = new Matricula("1", "usuario1", "asignatura1");

        when(repository.save(matricula)).thenReturn(matricula);
        Matricula resultado = service.guardarMatricula(matricula);

        assertNotNull(resultado);
        assertEquals("usuario1", resultado.getUsuarioId());
    }
}
