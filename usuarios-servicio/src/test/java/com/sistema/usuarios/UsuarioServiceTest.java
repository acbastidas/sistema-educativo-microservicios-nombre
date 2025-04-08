package com.sistema.usuarios;

import com.sistema.usuarios.model.Usuario;
import com.sistema.usuarios.repository.UsuarioRepository;
import com.sistema.usuarios.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UsuarioServiceTest {

    private final UsuarioRepository usuarioRepository = mock(UsuarioRepository.class);
    private final UsuarioService usuarioService = new UsuarioService(usuarioRepository);

    @Test
    public void testObtenerUsuarioPorId() {
        Usuario usuario = new Usuario("1", "Juan", "juan@example.com", "ROLE_USER");
        when(usuarioRepository.findById("1")).thenReturn(Optional.of(usuario));

        Usuario resultado = usuarioService.obtenerUsuarioPorId("1");

        assertNotNull(resultado);
        assertEquals("Juan", resultado.getNombre());
    }
}
