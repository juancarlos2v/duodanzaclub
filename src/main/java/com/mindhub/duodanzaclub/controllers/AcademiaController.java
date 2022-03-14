package com.mindhub.duodanzaclub.controllers;

import com.mindhub.duodanzaclub.dtos.AcademiaDTO;
import com.mindhub.duodanzaclub.models.Academia;
import com.mindhub.duodanzaclub.services.AcademiaService;
import com.mindhub.duodanzaclub.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AcademiaController {

    @Autowired
    AcademiaService academiaService;

    @GetMapping("/academias")
    public List<AcademiaDTO> getAcademias(){
        List<AcademiaDTO> academiaDTOS = academiaService.getAcademias();
        return academiaDTOS;
    }

    @GetMapping("/academias/{id}")
    public AcademiaDTO getAcademia(@PathVariable long id){
        AcademiaDTO academiaDTO = academiaService.getAcademia(id);
        return academiaDTO;
    }

    @PostMapping("/academias")
    public ResponseEntity<Object> crearAcademia(Authentication authentication,
                                                @RequestBody Academia academia){

        if(academia.getNombre().isEmpty() || academia.getCiudad().isEmpty()) {
            return new ResponseEntity<>("Complete los campos", HttpStatus.FORBIDDEN);
        }

        Academia academiaNueva = new Academia(academia.getNombre(), academia.getCiudad());
        academiaService.guardarAcademia(academiaNueva);

        return new ResponseEntity<>("Academia creada", HttpStatus.CREATED);
    }
}
