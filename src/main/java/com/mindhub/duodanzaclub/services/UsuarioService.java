package com.mindhub.duodanzaclub.services;

import com.mindhub.duodanzaclub.dtos.UsuarioDTO;
import com.mindhub.duodanzaclub.models.Usuario;

import java.util.List;

public interface UsuarioService {
    public List<UsuarioDTO> getUsuarios();
    public Usuario saveUsuario(Usuario usuario);
    public Usuario getUsuarioById(long id);
    public UsuarioDTO getById(long id);
    public UsuarioDTO findByEmail(String email);
    public Usuario findUsuarioByEmail(String email);
}
