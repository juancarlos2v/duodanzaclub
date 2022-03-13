package com.mindhub.duodanzaclub.controllers;

import com.mindhub.duodanzaclub.dtos.UsuarioDTO;
import com.mindhub.duodanzaclub.models.Usuario;
import com.mindhub.duodanzaclub.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/usuarios")
    public List<UsuarioDTO> getUsuarios(){
        List<UsuarioDTO> usuarioDTOS = usuarioRepository.findAll().stream().map(UsuarioDTO::new).collect(Collectors.toList());
        return usuarioDTOS;
    }

    @GetMapping("/usuarios/{id}")
    public UsuarioDTO getUsuario(@PathVariable long id){
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);
        return usuarioDTO;
    }



}
