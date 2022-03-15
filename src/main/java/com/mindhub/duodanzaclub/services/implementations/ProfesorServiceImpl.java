package com.mindhub.duodanzaclub.services.implementations;

import com.mindhub.duodanzaclub.dtos.ProfesorDTO;
import com.mindhub.duodanzaclub.models.Profesor;
import com.mindhub.duodanzaclub.repositories.ProfesorRepository;
import com.mindhub.duodanzaclub.services.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfesorServiceImpl implements ProfesorService {

    @Autowired
    ProfesorRepository profesorRepository;


    @Override
    public List<ProfesorDTO> getProfesores() {
        return profesorRepository.findAll().stream().map(ProfesorDTO::new).collect(Collectors.toList());
    }

    @Override
    public Profesor getProfesor(Long id) {
        return profesorRepository.findById(id).orElse(null);
    }

    @Override
    public void guardarProfesor(Profesor profesor) {
        profesorRepository.save(profesor);
    }
}
