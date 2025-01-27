package com.rodrigo.post.techfuture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo.post.techfuture.entities.Usuario;
import com.rodrigo.post.techfuture.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario saveOrUpdate(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElseThrow();
    }

    public List<Usuario> userList(Usuario usuario) {
        return usuarioRepository.findAll();
    }

    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }
}
