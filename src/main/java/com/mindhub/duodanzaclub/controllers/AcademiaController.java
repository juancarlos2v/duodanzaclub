package com.mindhub.duodanzaclub.controllers;

import com.mindhub.duodanzaclub.dtos.AcademiaDTO;
import com.mindhub.duodanzaclub.models.Academia;
import com.mindhub.duodanzaclub.repositories.AcademiaRepository;
import com.mindhub.duodanzaclub.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class AcademiaController {

    @Autowired
    AcademiaRepository academiaRepository;
    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/academias")
    public List<AcademiaDTO> getAcademias(){
        List<AcademiaDTO> academiaDTOS = academiaRepository.findAll().stream().map(AcademiaDTO::new).collect(Collectors.toList());
        return academiaDTOS;
    }

    @GetMapping("/academias/{id}")
    public AcademiaDTO getAcademia(@PathVariable long id){
        Academia academia = academiaRepository.findById(id).orElse(null);
        AcademiaDTO academiaDTO = new AcademiaDTO(academia);
        return academiaDTO;
    }
}
