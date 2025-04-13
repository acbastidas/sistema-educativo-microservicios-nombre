package com.sistema.usuarios;

import com.sistema.usuarios.controller.UsuarioController;
import com.sistema.usuarios.model.Usuario;
import com.sistema.usuarios.security.JwtUtil;
import com.sistema.usuarios.service.UsuarioService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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

        @Mock
        private JwtUtil jwtUtil;

        @InjectMocks
        private UsuarioController usuarioController;

        @BeforeEach
        public void setUp() {
                MockitoAnnotations.openMocks(this);
                mockMvc = MockMvcBuilders.standaloneSetup(usuarioController).build();
        }

        @Test
        void testCrearUsuario() throws Exception {
                Usuario usuario = new Usuario("1", "Juan", "juan@example.com", "1234");

                when(usuarioService.saveUsuario(Mockito.any(Usuario.class))).thenReturn(usuario);
                when(jwtUtil.generateToken(Mockito.anyString())).thenReturn("mocked-jwt-token");

                mockMvc.perform(post("/api/usuarios/usuarios")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("""
                                                {
                                                    "nombre": "Juan",
                                                    "email": "juan@example.com",
                                                    "password": "1234"
                                                }
                                                """))
                                .andExpect(status().isCreated())
                                .andExpect(jsonPath("$.nombre").value("Juan"))
                                .andExpect(jsonPath("$.email").value("juan@example.com"));
        }
}
