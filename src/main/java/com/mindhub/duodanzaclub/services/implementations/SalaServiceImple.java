package com.mindhub.duodanzaclub.services.implementations;

import com.mindhub.duodanzaclub.dtos.SalaDTO;
import com.mindhub.duodanzaclub.models.Sala;
import com.mindhub.duodanzaclub.repositories.SalaRepository;
import com.mindhub.duodanzaclub.services.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SalaServiceImple implements SalaService {

    @Autowired
    SalaRepository salaRepository;

    @Override
    public List<SalaDTO> obtenerSalasDTO() {
        return salaRepository.findAll().stream().map(SalaDTO::new).collect(Collectors.toList());
    }

    @Override
    public Sala obtenerSala(Long id) {
        return salaRepository.findById(id).orElse(null);
    }

    @Override
    public void guardarSala(Sala sala) {
        salaRepository.save(sala);
    }

}
