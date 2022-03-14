package com.mindhub.duodanzaclub.controllers;


import com.mindhub.duodanzaclub.dtos.ProfesorDTO;
import com.mindhub.duodanzaclub.models.Profesor;
import com.mindhub.duodanzaclub.repositories.ProfesorRepository;
import com.mindhub.duodanzaclub.services.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ProfesorController {

    @Autowired
    ProfesorService profesorService;

    @GetMapping("/profesores")
    public List<ProfesorDTO> getProfesores(){
        List<ProfesorDTO> profesores = profesorService.getProfesores();
        return profesores;
    }

    @GetMapping("/profesores/{id}")
    public ProfesorDTO getProfesor(@PathVariable Long id){
        Profesor profesor = profesorService.getProfesor(id);
        ProfesorDTO profesorDTO = new ProfesorDTO(profesor);

        return profesorDTO;
    }


    @PostMapping("/profesores")
    public ResponseEntity<Object> crearProfesor(@RequestBody Profesor profesor){

        if(profesor.getNombre().isEmpty() || profesor.getApellido().isEmpty()){
            return new ResponseEntity<>("Complete los campos", HttpStatus.FORBIDDEN);
        }

        Profesor profesorNuevo = new Profesor(profesor.getNombre(), profesor.getApellido());
        profesorService.guardarProfesor(profesorNuevo);


        return new ResponseEntity<>("Profesor enlistado", HttpStatus.CREATED);
    }
}
