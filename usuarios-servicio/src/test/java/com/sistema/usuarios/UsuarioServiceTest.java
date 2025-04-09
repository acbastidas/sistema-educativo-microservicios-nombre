package com.sistema.usuarios;

import com.sistema.usuarios.model.Usuario;
import com.sistema.usuarios.repository.UsuarioRepository;
import com.sistema.usuarios.service.UsuarioService;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UsuarioServiceTest {

    private final UsuarioRepository usuarioRepository = mock(UsuarioRepository.class);
    private final UsuarioService usuarioService = new UsuarioService(usuarioRepository);

    @Test
    public void testObtenerUsuarioPorId() {
        Usuario usuario = new Usuario("1", "Juan", "juan@example.com", "juan123", "password123");
        when(usuarioRepository.findById("1")).thenReturn(Optional.of(usuario));

        Optional<Usuario> resultado = usuarioService.obtenerPorId("1");

        assertTrue(resultado.isPresent());
        assertEquals("juan123", resultado.get().getUsername()); // Asegúrate de que el valor del 'username' sea correcto
    }
}
