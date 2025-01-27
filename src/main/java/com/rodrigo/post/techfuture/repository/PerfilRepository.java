package com.rodrigo.post.techfuture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rodrigo.post.techfuture.entities.Perfil;
@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long>{
    
}
