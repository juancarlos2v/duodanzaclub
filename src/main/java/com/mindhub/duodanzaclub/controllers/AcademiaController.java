package com.mindhub.duodanzaclub.controllers;

import com.mindhub.duodanzaclub.dtos.AcademiaDTO;
import com.mindhub.duodanzaclub.services.AcademiaService;
import com.mindhub.duodanzaclub.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AcademiaController {

    @Autowired
    AcademiaService academiaService;
    @Autowired
    UsuarioService usuarioService;

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
}
