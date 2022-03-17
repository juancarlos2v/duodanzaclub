package com.mindhub.duodanzaclub.controllers;

import com.mindhub.duodanzaclub.dtos.ClaseDTO;
import com.mindhub.duodanzaclub.dtos.SolicitudDTO;
import com.mindhub.duodanzaclub.models.*;
import com.mindhub.duodanzaclub.repositories.AcademiaRepository;
import com.mindhub.duodanzaclub.repositories.ClaseRepository;
import com.mindhub.duodanzaclub.services.AcademiaService;
import com.mindhub.duodanzaclub.services.ClaseService;
import com.mindhub.duodanzaclub.repositories.UsuarioClaseRepository;
import com.mindhub.duodanzaclub.services.UsuarioService;
import com.mindhub.duodanzaclub.utils.UsuarioClaseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ClaseController {

    @Autowired
    ClaseService claseService;
    @Autowired
    AcademiaService academiaService;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    UsuarioClaseRepository usuarioClaseRepository;

    @GetMapping("/clases")
    public List<ClaseDTO> getClases(){
        List<ClaseDTO> clases = claseService.traerClases();
        return clases;
    }

    @GetMapping("/clases/{id}")
    public ClaseDTO getClase(@PathVariable Long id){
        Clase clase = claseService.traerClasePorId(id);
        ClaseDTO claseDTO = new ClaseDTO(clase);
        return claseDTO;
    }

    @PatchMapping("clases/{id}")
    public ResponseEntity<Object> cambiarPrecio(@PathVariable Long id,
                                                @RequestParam String horario){
        Clase clase = claseService.traerClasePorId(id);

        if(clase == null) {
            return new ResponseEntity<>("La clase no existe", HttpStatus.FORBIDDEN);
        }

        clase.setHorario(horario);
        claseService.guardarClase(clase);
        return new ResponseEntity<>("Clase creada", HttpStatus.CREATED);
    }

    @PostMapping("/clases")
    public ResponseEntity<Object> crearClase(@RequestBody ClaseDTO clase){
        Academia academia = academiaService.getAcademiaClass(clase.getId());

        if(clase.getNombre().isEmpty() || clase.getEstilo() == null || clase.getHorario().isEmpty() ){
            return new ResponseEntity<>("Complete todos los campos", HttpStatus.FORBIDDEN);
        }
        if(academia == null) {
            return new ResponseEntity<>("La academia no existe", HttpStatus.FORBIDDEN);
        }

        Clase claseNueva = new Clase(clase.getNombre(), clase.getEstilo(), clase.getHorario(), clase.getDireccion(), academia);
        claseService.guardarClase(claseNueva);

        return  new ResponseEntity<>("Clase creada", HttpStatus.CREATED);
    }

    @PostMapping("/usuarios/clases")
    public ResponseEntity<Object> anotarEnClase(Authentication authentication, @RequestBody SolicitudDTO solicitudDTO){
        Usuario usuario = usuarioService.findUsuarioByEmail(authentication.getName());
        Clase clase = claseService.traerClasePorId(solicitudDTO.getUsuario());
        List<UsuarioClase> usuarioClases = usuarioClaseRepository.findAll();

        if(usuario == null){
            return new ResponseEntity<>("Usuario no encontrado", HttpStatus.FORBIDDEN);
        }
        if(clase == null){
            return new ResponseEntity<>("La clase seleccionada no existe", HttpStatus.FORBIDDEN);
        }
        if(usuarioClases.size() > 0){
            Boolean estaAnotado = UsuarioClaseUtils.buscarAnotadoClases(usuario, clase, usuarioClases) != null;
            if(estaAnotado){
                return new ResponseEntity<>("El usuario ya se encuentra anotado a esta clase", HttpStatus.FORBIDDEN);
            }
        }

        usuarioClaseRepository.save(new UsuarioClase(usuario, clase));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/usuarios/clases/desanotar")
    public ResponseEntity<Object> desanotarDeClase(Authentication authentication, @RequestBody SolicitudDTO solicitudDTO){
        Usuario usuario = usuarioService.findUsuarioByEmail(authentication.getName());
        Clase clase = claseService.traerClasePorId(solicitudDTO.getUsuario());
        List<UsuarioClase> usuarioClases = usuarioClaseRepository.findAll();

        if(usuario == null){
            return new ResponseEntity<>("Usuario no encontrado", HttpStatus.FORBIDDEN);
        }
        if(clase == null){
            return new ResponseEntity<>("La clase seleccionada no existe", HttpStatus.FORBIDDEN);
        }
        if(usuarioClases.size() < 1){
            return new ResponseEntity<>("No existen usuarios anotados a clases", HttpStatus.FORBIDDEN);
        }
        UsuarioClase usuarioAnotado = UsuarioClaseUtils.buscarAnotadoClases(usuario, clase, usuarioClases);
        if(usuarioAnotado == null){
            return new ResponseEntity<>("Usuario no está anotado a esta clase", HttpStatus.FORBIDDEN);
        }

        usuarioClaseRepository.delete(usuarioAnotado);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
