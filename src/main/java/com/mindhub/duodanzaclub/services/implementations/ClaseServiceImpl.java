package com.mindhub.duodanzaclub.services.implementations;

import com.mindhub.duodanzaclub.dtos.ClaseDTO;
import com.mindhub.duodanzaclub.models.Clase;
import com.mindhub.duodanzaclub.repositories.ClaseRepository;
import com.mindhub.duodanzaclub.services.ClaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClaseServiceImpl implements ClaseService {

    @Autowired
    ClaseRepository claseRepository;


    @Override
    public List<ClaseDTO> traerClases() {
        return claseRepository.findAll().stream().map(ClaseDTO::new).collect(Collectors.toList());
    }

    @Override
    public Clase traerClasePorId(Long id) {
        return claseRepository.findById(id).orElse(null);
    }

    @Override
    public void guardarClase(Clase clase) {
        claseRepository.save(clase);
    }
}
