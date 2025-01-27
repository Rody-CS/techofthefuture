package com.rodrigo.post.techfuture.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Perfil {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String telefone;
    private LocalDate dataNascimento;
    private String email;
    
    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
}
