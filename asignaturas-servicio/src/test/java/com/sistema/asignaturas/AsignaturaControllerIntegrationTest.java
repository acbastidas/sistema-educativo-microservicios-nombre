package com.sistema.asignaturas.controlador;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sistema.asignaturas.entidad.Asignatura;
import com.sistema.asignaturas.repositorio.AsignaturaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
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
        Asignatura asignatura = new Asignatura("10", "Física", "Mecánica");
        repository.save(asignatura);

        mockMvc.perform(get("/asignaturas/10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Física"));
    }
}
