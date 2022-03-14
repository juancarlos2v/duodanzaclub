package com.mindhub.duodanzaclub.services.implementations;

import com.mindhub.duodanzaclub.dtos.UsuarioDTO;
import com.mindhub.duodanzaclub.models.Usuario;
import com.mindhub.duodanzaclub.repositories.UsuarioRepository;
import com.mindhub.duodanzaclub.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioDTO> getUsuarios(){
        return usuarioRepository.findAll().stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }

    @Override
    public Usuario saveUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    @Override
    public UsuarioDTO getById(long id){
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);
        return usuarioDTO;
    }

    @Override
    public Usuario getUsuarioById(long id){
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public UsuarioDTO findByEmail(String email){
        Usuario usuario = usuarioRepository.findByEmail(email);
        UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);
        return usuarioDTO;
    }

    @Override
    public Usuario findUsuarioByEmail(String email){
        Usuario usuario = usuarioRepository.findByEmail(email);
        return usuario;
    }
}
