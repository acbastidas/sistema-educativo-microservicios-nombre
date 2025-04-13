package com.sistema.matriculas.servicie;

import com.sistema.matriculas.client.UsuarioClient;
import com.sistema.matriculas.client.AsignaturaClient;
import com.sistema.matriculas.model.Matricula;
import com.sistema.matriculas.service.MatriculaService;
import com.sistema.matriculas.repository.MatriculaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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

