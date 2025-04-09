package com.sistema.usuarios;

import com.sistema.usuarios.controller.UsuarioController;
import com.sistema.usuarios.model.Usuario;
import com.sistema.usuarios.service.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import org.mockito.MockitoAnnotations;

@WebMvcTest(UsuarioController.class)
public class UsuarioControllerTest {

        private MockMvc mockMvc;

        @Mock
        private UsuarioService usuarioService;

        @InjectMocks
        private UsuarioController usuarioController;

        @BeforeEach
        public void setUp() {
                // Usar openMocks en lugar de initMocks
                MockitoAnnotations.openMocks(this);
                // Inicializar MockMvc de manera adecuada
                mockMvc = MockMvcBuilders.standaloneSetup(usuarioController).build();
        }

        @Test
        public void testCrearUsuario() throws Exception {
                Usuario usuario = new Usuario("1", "Juan", "juan@example.com", "juan", "1234");

                // Configurar el mock para el servicio
                when(usuarioService.crear(usuario)).thenReturn(usuario);

                // Realizar la solicitud POST y verificar la respuesta
                mockMvc.perform(post("/api/usuarios")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{\"id\":\"1\",\"nombre\":\"Juan\",\"email\":\"juan@example.com\",\"username\":\"juan\",\"password\":\"1234\"}"))
                                .andExpect(status().isCreated()) // Verifica que el estado sea 201
                                .andExpect(jsonPath("$.username").value("juan")); // Verifica el valor del username
        }
}
