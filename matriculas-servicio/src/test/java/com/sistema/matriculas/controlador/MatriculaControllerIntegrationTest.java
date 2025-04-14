package com.sistema.matriculas.controlador;

import com.sistema.matriculas.MatriculasServicioApplication;
import com.sistema.matriculas.client.AsignaturaClient;
import com.sistema.matriculas.client.UsuarioClient;
import com.sistema.matriculas.model.Asignatura;
import com.sistema.matriculas.model.Matricula;
import com.sistema.matriculas.model.Usuario;
import com.sistema.matriculas.repository.MatriculaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = MatriculasServicioApplication.class)
@AutoConfigureMockMvc
@Import(MatriculaControllerIntegrationTest.MockConfig.class)
public class MatriculaControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MatriculaRepository repository;

    @Autowired
    private UsuarioClient usuarioClient;

    @Autowired
    private AsignaturaClient asignaturaClient;

    @BeforeEach
    void setup() {
        repository.deleteAll();
    }

    @Test
    void testListarMatriculas() throws Exception {
        repository.save(new Matricula("5", "usuarioX", "asignaturaX"));

        when(usuarioClient.obtenerUsuario(anyString()))
                .thenReturn(new Usuario("usuarioX", "Nombre Usuario", "estudiante"));

        when(asignaturaClient.obtenerAsignatura(anyString()))
                .thenReturn(new Asignatura("asignaturaX", "Matemáticas"));

        mockMvc.perform(get("/api/matriculas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].usuarioId").value("usuarioX"));
    }

    @Test
    void testSaludo() throws Exception {
        mockMvc.perform(get("/api/matriculas/saludo"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hola desde el microservicio de matrículas"));
    }

    @TestConfiguration
    static class MockConfig {

        @Bean
        public UsuarioClient usuarioClient() {
            return Mockito.mock(UsuarioClient.class);
        }

        @Bean
        public AsignaturaClient asignaturaClient() {
            return Mockito.mock(AsignaturaClient.class);
        }
    }
}
