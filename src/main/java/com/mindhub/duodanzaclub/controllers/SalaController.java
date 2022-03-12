package com.mindhub.duodanzaclub.controllers;

import com.mindhub.duodanzaclub.dtos.SalaDTO;
import com.mindhub.duodanzaclub.models.Academia;
import com.mindhub.duodanzaclub.models.Sala;
import com.mindhub.duodanzaclub.repositories.AcademiaRepository;
import com.mindhub.duodanzaclub.repositories.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class SalaController {

    @Autowired
    SalaRepository salaRepository;

    @Autowired
    AcademiaRepository academiaRepository;

    @GetMapping("/salas")
    public List<SalaDTO> getSalas(){
        List<Sala> salas = salaRepository.findAll();
        List<SalaDTO> salasDTO = salas.stream().map(SalaDTO::new).collect(Collectors.toList());

        return salasDTO;
    }


    @GetMapping("/salas/{id}")
    public SalaDTO getSala(@PathVariable Long id){
        Sala sala = salaRepository.findById(id).orElse(null);
        SalaDTO salaDTO = new SalaDTO(sala);

        return salaDTO;
    }



    @PostMapping("/salas")
    public ResponseEntity<Object> crearSala(@RequestBody SalaDTO sala){

        Academia academia = academiaRepository.findById(sala.getAcademia_id()).orElse(null);

        if(sala.getNombre().isEmpty() || academia == null) {
            return new ResponseEntity<>("Complete los campos", HttpStatus.FORBIDDEN);
        }

        if(sala.getAforo() <= 0) {
            return new ResponseEntity<>("Ingrese aforo", HttpStatus.FORBIDDEN);
        }

        else {
            Sala salaNueva = new Sala(sala.getNombre(), sala.getAforo(), academia);
            salaRepository.save(salaNueva);

            return new ResponseEntity<>("Sala creada", HttpStatus.CREATED);
        }

    }
}
