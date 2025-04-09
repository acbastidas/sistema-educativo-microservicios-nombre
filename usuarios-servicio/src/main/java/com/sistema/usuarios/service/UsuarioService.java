package com.sistema.usuarios.service;

import com.sistema.usuarios.model.Usuario;
import com.sistema.usuarios.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<Usuario> obtenerTodos() {
        return repository.findAll();
    }

    public Optional<Usuario> obtenerPorId(String id) {
        return repository.findById(id);
    }

    public Usuario crear(Usuario usuario) {
        return repository.save(usuario); // Uso del método 'save' de Spring Data
    }

    public Optional<Usuario> actualizar(String id, Usuario usuario) {
        return repository.findById(id).map(existing -> {
            existing.setNombre(usuario.getNombre());
            existing.setEmail(usuario.getEmail());
            return repository.save(existing);
        });
    }

    public void eliminar(String id) {
        repository.deleteById(id);
    }
}
