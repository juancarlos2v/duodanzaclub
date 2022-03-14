package com.mindhub.duodanzaclub.controllers;

import com.mindhub.duodanzaclub.dtos.SalaDTO;
import com.mindhub.duodanzaclub.models.Academia;
import com.mindhub.duodanzaclub.models.Sala;
import com.mindhub.duodanzaclub.repositories.AcademiaRepository;
import com.mindhub.duodanzaclub.repositories.SalaRepository;
import com.mindhub.duodanzaclub.services.AcademiaService;
import com.mindhub.duodanzaclub.services.SalaService;
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
    SalaService salaService;
    @Autowired
    AcademiaService academiaService;

    @GetMapping("/salas")
    public List<SalaDTO> getSalas(){
        List<SalaDTO> salasDTO = salaService.obtenerSalasDTO();
        return salasDTO;
    }

    @GetMapping("/salas/{id}")
    public SalaDTO getSala(@PathVariable Long id){
        SalaDTO salaDTO = new SalaDTO(salaService.obtenerSala(id));
        return salaDTO;
    }

    @PostMapping("/salas")
    public ResponseEntity<Object> crearSala(@RequestBody SalaDTO sala){
        Academia academia = academiaService.getAcademiaClass(sala.getAcademia_id());

        if(sala.getNombre().isEmpty() || academia == null) {
            return new ResponseEntity<>("Complete los campos", HttpStatus.FORBIDDEN);
        }
        if(sala.getAforo() <= 0) {
            return new ResponseEntity<>("Ingrese aforo", HttpStatus.FORBIDDEN);
        }

        Sala salaNueva = new Sala(sala.getNombre(), sala.getAforo(), academia);
        salaService.guardarSala(salaNueva);

        return new ResponseEntity<>("Sala creada", HttpStatus.CREATED);
    }
}
