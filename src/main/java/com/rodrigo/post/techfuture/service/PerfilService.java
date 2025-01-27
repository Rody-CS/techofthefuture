package com.rodrigo.post.techfuture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo.post.techfuture.entities.Perfil;
import com.rodrigo.post.techfuture.repository.PerfilRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PerfilService {
    
    @Autowired
    private PerfilRepository perfilRepository;

    public Perfil saveOrUpdate(Perfil perfil) {
        return perfilRepository.save(perfil);
    }
    
    public Perfil findById(Long id) {
        return perfilRepository.findById(id).orElseThrow();
    }

    public List<Perfil> userList(Perfil Perfil) {
        return perfilRepository.findAll();
    }

    public void delete(Long id) {
        perfilRepository.deleteById(id);
    }
}
