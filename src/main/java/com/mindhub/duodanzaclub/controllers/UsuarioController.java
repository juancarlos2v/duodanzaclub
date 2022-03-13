package com.mindhub.duodanzaclub.controllers;

import com.mindhub.duodanzaclub.dtos.SolicitudDTO;
import com.mindhub.duodanzaclub.dtos.UsuarioDTO;
import com.mindhub.duodanzaclub.models.Usuario;
import com.mindhub.duodanzaclub.services.UsuarioService;
import com.mindhub.duodanzaclub.utils.UsuarioUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public List<UsuarioDTO> getUsuarios(){
        List<UsuarioDTO> usuarioDTOS = usuarioService.getUsuarios();
        return usuarioDTOS;
    }

    @GetMapping("/usuarios/{id}")
    public UsuarioDTO getUsuario(@PathVariable long id){
        UsuarioDTO usuarioDTO = usuarioService.getById(id);
        return usuarioDTO;
    }

    @GetMapping("/usuarios/current")
    public UsuarioDTO getCurrentUsuario(Authentication authentication){
        UsuarioDTO usuarioDTO = usuarioService.findByEmail(authentication.getName());
        return usuarioDTO;
    }

    @PostMapping("/usuarios")
    public ResponseEntity<Object> register(@RequestBody UsuarioDTO usuarioDTO){
        Usuario usuario = usuarioService.findUsuarioByEmail(usuarioDTO.getEmail());
        int anio = usuarioDTO.getAnio();
        int mes = usuarioDTO.getMes();
        int dia = usuarioDTO.getDia();
        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);

        if(usuarioDTO.getNombre().isEmpty() || usuarioDTO.getApellido().isEmpty() || usuarioDTO.getEmail().isEmpty() ||
                usuarioDTO.getTelefono().isEmpty() || usuarioDTO.getPassword().isEmpty()){
            return new ResponseEntity<>("Campos faltantes", HttpStatus.FORBIDDEN);
        }
        if(anio < 1912 || anio > LocalDate.now().getYear() || mes < 1 || mes > 12 || dia <= 0 || dia > 31){
            return new ResponseEntity<>("Fecha de nacimiento no valida", HttpStatus.FORBIDDEN);
        }
        if(usuario != null){
            return new ResponseEntity<>("El usuario ya existe", HttpStatus.FORBIDDEN);
        }

        Usuario nuevoUsuario = new Usuario(usuarioDTO.getNombre(), usuarioDTO.getApellido(), usuarioDTO.getTelefono(),
                usuarioDTO.getEmail(), passwordEncoder.encode(usuarioDTO.getPassword()), fechaNacimiento);
        usuarioService.saveUsuario(usuario);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/usuarios/agregar")
    public ResponseEntity<Object> agregarContacto(@RequestBody SolicitudDTO solicitudDTO){
        Usuario usuario1 = usuarioService.getUsuarioById(solicitudDTO.getUsuario1());
        Usuario usuario2 = usuarioService.getUsuarioById(solicitudDTO.getUsuario2());
        List<Usuario> usuarios = new ArrayList<>(usuario1.getFollowing());

        if(usuario1 == null || usuario2 == null){
            return new ResponseEntity<>("Usuario invalido", HttpStatus.FORBIDDEN);
        }
        if(usuario1 == usuario2){
            return new ResponseEntity<>("Los usuarios son los mismos", HttpStatus.FORBIDDEN);
        }
        if(usuarios.size() > 0){
            Boolean sonContactos = UsuarioUtils.buscarEntreContactos(usuario2, usuarios);
            if(sonContactos){
                return new ResponseEntity<>("El usuario ya sigue a este usuario", HttpStatus.FORBIDDEN);
            }
        }

        usuario1.getFollowing().add(usuario2);
        usuario2.getFollowers().add(usuario1);
        if(usuario1.getFollowing().contains(usuario2) && usuario1.getFollowers().contains(usuario2)){
            usuario1.getContactos().add(usuario2.getId());
            usuario2.getContactos().add(usuario1.getId());
        }
        usuarioService.saveUsuario(usuario1);
        usuarioService.saveUsuario(usuario2);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
