package com.sistema.asignaturas.servicio;

import com.sistema.asignaturas.entidad.Asignatura;
import com.sistema.asignaturas.repositorio.AsignaturaRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class AsignaturaServiceTest {

    private final AsignaturaRepository asignaturaRepository = mock(AsignaturaRepository.class);
    private final AsignaturaService asignaturaService = new AsignaturaService(asignaturaRepository);

    @Test
    void testObtenerAsignaturaPorId() {
        Asignatura asignatura = new Asignatura("1", "Matemáticas", "Álgebra y cálculo");
        when(asignaturaRepository.findById("1")).thenReturn(Optional.of(asignatura));

        Optional<Asignatura> resultado = asignaturaService.obtenerPorId("1");

        assertTrue(resultado.isPresent());
        assertEquals("Matemáticas", resultado.get().getNombre());
    }
}
