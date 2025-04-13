package com.sistema.usuarios;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sistema.usuarios.controller.UsuarioController;
import com.sistema.usuarios.model.Usuario;
import com.sistema.usuarios.service.UsuarioService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class UsuarioControllerTest {

        private MockMvc mockMvc;

        @Mock
        private UsuarioService usuarioService;

        @InjectMocks
        private UsuarioController usuarioController;

        private final ObjectMapper objectMapper = new ObjectMapper();

        @BeforeEach
        public void setUp() {
                MockitoAnnotations.openMocks(this);
                mockMvc = MockMvcBuilders.standaloneSetup(usuarioController).build();
        }

        @Test
        public void testCrearUsuario() throws Exception {
                Usuario usuario = new Usuario("1", "Juan", "juan@example.com", "juan", "1234");

                when(usuarioService.crear(usuario)).thenReturn(usuario);

                mockMvc.perform(post("/api/usuarios")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(usuario)))
                                .andExpect(status().isCreated())
                                .andExpect(jsonPath("$.username").value("juan"));
        }
}
