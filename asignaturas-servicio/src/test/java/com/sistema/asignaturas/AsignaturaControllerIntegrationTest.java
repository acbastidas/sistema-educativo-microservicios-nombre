package com.sistema.asignaturas;

import com.sistema.asignaturas.model.Asignatura;
import com.sistema.asignaturas.repository.AsignaturaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AsignaturaControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AsignaturaRepository repository;

    @Test
    void testObtenerAsignaturaPorId() throws Exception {
        Asignatura asignatura = new Asignatura("10", "Matemáticas", "Intro a funciones", 4);
        repository.save(asignatura);

        mockMvc.perform(get("/asignaturas/10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Matemáticas"));
    }
}
