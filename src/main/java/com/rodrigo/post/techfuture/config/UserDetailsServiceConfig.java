package com.rodrigo.post.techfuture.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.rodrigo.post.techfuture.entities.Role;
import com.rodrigo.post.techfuture.entities.Usuario;
import com.rodrigo.post.techfuture.repository.UsuarioRepository;

@Configuration
public class UserDetailsServiceConfig {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                Usuario usuario = usuarioRepository.findByUsername(username);
                if (usuario == null) {
                    throw new UsernameNotFoundException("Usuário não encontrado");
                }
                return new User(usuario.getUsername(), usuario.getPassword(), getAuthorities(usuario.getRole()));
            }

            private List<GrantedAuthority> getAuthorities(Role role) {
                List<GrantedAuthority> authorities = new ArrayList<>();
                authorities.add(new SimpleGrantedAuthority(role.name()));
                return authorities;
            }
        };
    }
}