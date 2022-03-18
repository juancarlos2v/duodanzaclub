package com.mindhub.duodanzaclub.controllers;


import com.mindhub.duodanzaclub.dtos.SuscripcionDTO;
import com.mindhub.duodanzaclub.dtos.UsuarioDTO;
import com.mindhub.duodanzaclub.models.Suscripcion;
import com.mindhub.duodanzaclub.models.Usuario;
import com.mindhub.duodanzaclub.repositories.SuscripcionRepository;
import com.mindhub.duodanzaclub.repositories.UsuarioRepository;
import com.mindhub.duodanzaclub.services.SuscripcionService;
import com.mindhub.duodanzaclub.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class SuscripcionController {

    @Autowired
    SuscripcionService suscripcionService;

    @Autowired
    UsuarioService usuarioService;


    @GetMapping("/suscripciones")
    public List<SuscripcionDTO> suscripciones(){
        return suscripcionService.getSuscripciones();
    }

    @GetMapping("/suscripciones/{id}")
    public SuscripcionDTO suscripcion(@PathVariable Long id){

        return new SuscripcionDTO(suscripcionService.getSuscripcion(id));
    }

    //Acá vamos a cambiar el estado de suscripción del usuario
    @PatchMapping("/usuarios/current/suscripciones")
    public ResponseEntity<Object> desuscribirUsuario(Authentication authentication){

        Usuario usuario = usuarioService.findUsuarioByEmail(authentication.getName());

        if(usuario == null) {
            return new ResponseEntity<>("No existe el usuario", HttpStatus.FORBIDDEN);
        }
        if(usuario.getSuscripcion() == null){
            return new ResponseEntity<>("El usuario no está suscrito", HttpStatus.FORBIDDEN);
        }

        usuario.setSuscripcion(null);
        usuarioService.saveUsuario(usuario);

        return new ResponseEntity<>("Suscripción anulada", HttpStatus.OK);

    }



    @PatchMapping("/usuarios/current/suscripciones/")
    public ResponseEntity<Object> suscribirse(Authentication authentication, @RequestParam Long id){
        Usuario usuario = usuarioService.findUsuarioByEmail(authentication.getName());
        Suscripcion suscripcion = suscripcionService.getSuscripcion(id);

        if(usuario == null) {
            return new ResponseEntity<>("El usuario no existe", HttpStatus.FORBIDDEN);
        }
        /**if(usuario.getSuscripcion() != null) {
            return new ResponseEntity<>("El usuario ya está suscripto", HttpStatus.FORBIDDEN);
        }*/
        //if(suscripcion.getPrecios().isEmpty() || suscripcion.getClases().isEmpty()) {
           // return new ResponseEntity<>("Complete los campos", HttpStatus.FORBIDDEN);
        //}




        usuario.setSuscripcion(suscripcion);
        usuarioService.guardarUsuario(usuario);
        suscripcion.getUsuarios().add(usuario);
        suscripcionService.guardarSuscripcion(suscripcion);

        return new ResponseEntity<>("Se suscribió", HttpStatus.CREATED);

    }



    @PostMapping("/suscripciones")
    public ResponseEntity<Object> crearTipoSuscripcion(@RequestBody Suscripcion suscripcion){

        if(suscripcion.getNombre().isEmpty() || suscripcion.getClases() <= 0 || suscripcion.getPrecios().isEmpty()) {
            return new ResponseEntity<>("Complete los campos", HttpStatus.FORBIDDEN);
        }

        Suscripcion suscripcionNueva = new Suscripcion(suscripcion.getNombre(), suscripcion.getPrecios(), suscripcion.getClases());
        suscripcionService.guardarSuscripcion(suscripcionNueva);

        return new ResponseEntity<>("Nuevo tipo de suscripción creado", HttpStatus.CREATED);

    }
}
