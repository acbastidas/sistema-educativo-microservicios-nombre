package com.sistema.asignaturas;

import com.sistema.asignaturas.model.Asignatura;
import com.sistema.asignaturas.repository.AsignaturaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.is; // Importar esta clase
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AsignaturaControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AsignaturaRepository repository;

    private Asignatura asignaturaGuardada;

    @BeforeEach
    void setUp() {
        repository.deleteAll(); // Limpia antes de cada test

        Asignatura asignatura = new Asignatura();
        asignatura.setNombre("Matemáticas");
        asignatura.setAula("Álgebra");
        asignatura.setCreditos(4);
        asignatura.setDescripcion("Álgebra y geometría");

        asignaturaGuardada = repository.save(asignatura); // Se guarda en la base de prueba
    }

    @Test
    void testObtenerAsignaturaPorId() throws Exception {
        mockMvc.perform(get("/api/asignaturas/" + asignaturaGuardada.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre", is("Matemáticas")))
                .andExpect(jsonPath("$.aula", is("Álgebra")))
                .andExpect(jsonPath("$.creditos", is(4)))
                .andExpect(jsonPath("$.descripcion", is("Álgebra y geometría")));

        // Puedes hacer otras validaciones si lo necesitas
        // assertEquals("Matemáticas", asignaturaGuardada.getNombre());
        // assertEquals(4, asignaturaGuardada.getCreditos());
    }
}
