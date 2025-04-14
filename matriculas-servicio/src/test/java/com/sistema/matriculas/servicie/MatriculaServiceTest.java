package com.sistema.matriculas.servicie;

import com.sistema.matriculas.client.AsignaturaClient;
import com.sistema.matriculas.client.UsuarioClient;
import com.sistema.matriculas.model.Matricula;
import com.sistema.matriculas.service.MatriculaService;
import com.sistema.matriculas.repository.MatriculaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MatriculaServiceTest {

    @Mock
    private MatriculaRepository matriculaRepository;

    @Mock
    private UsuarioClient usuarioClient;

    @Mock
    private AsignaturaClient asignaturaClient;

    @InjectMocks
    private MatriculaService matriculaService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGuardarMatricula() {
        Matricula matricula = new Matricula("1", "usuario1", "asignatura1");

        when(matriculaRepository.save(matricula)).thenReturn(matricula);

        Matricula guardada = matriculaService.guardarMatricula(matricula);

        assertEquals(matricula, guardada);
        verify(matriculaRepository, times(1)).save(matricula);
    }

    @Test
    void testObtenerTodas() {
        Matricula matricula1 = new Matricula("1", "usuario1", "asignatura1");
        Matricula matricula2 = new Matricula("2", "usuario2", "asignatura2");

        when(matriculaRepository.findAll()).thenReturn(Arrays.asList(matricula1, matricula2));

        List<Matricula> resultado = matriculaService.obtenerTodas();

        assertEquals(2, resultado.size());
        verify(matriculaRepository, times(1)).findAll();
    }
}
