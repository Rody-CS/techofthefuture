package com.rodrigo.post.techfuture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigo.post.techfuture.entities.Usuario;

@RestController
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public String login(@RequestBody Usuario usuario) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(usuario.getUsername(), usuario.getPassword());
        Authentication authentication = authenticationManager.authenticate(token);

        if (authentication.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return "Login efetuado com sucesso!";
        } else {
            return "Usuário ou senha inválidos";
        }
    }
}
