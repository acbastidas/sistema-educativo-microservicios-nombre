package com.sistema.matriculas.controlador;

import com.sistema.matriculas.model.Matricula;
import com.sistema.matriculas.repository.MatriculaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class MatriculaControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MatriculaRepository repository;

    @Test
    void testListarMatriculas() throws Exception {
        repository.save(new Matricula("5", "usuarioX", "asignaturaX"));

        mockMvc.perform(get("/matriculas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].usuarioId").value("usuarioX"));
    }
}
