package com.sistema.asignaturas;

import com.sistema.asignaturas.model.Asignatura;
import com.sistema.asignaturas.repository.AsignaturaRepository;
import com.sistema.asignaturas.service.AsignaturaService;
import org.junit.jupiter.api.Test;
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
        Asignatura asignatura = new Asignatura("1", "Matemáticas", "Álgebra", 4);
        when(asignaturaRepository.findById("1")).thenReturn(Optional.of(asignatura));

        Optional<Asignatura> resultado = asignaturaService.obtenerPorId("1");

        assertTrue(resultado.isPresent());
        assertEquals("Matemáticas", resultado.get().getNombre());
    }
}
