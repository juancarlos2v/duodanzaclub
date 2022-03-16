package com.mindhub.duodanzaclub.services.implementations;


import com.mindhub.duodanzaclub.dtos.SuscripcionDTO;
import com.mindhub.duodanzaclub.models.Suscripcion;
import com.mindhub.duodanzaclub.repositories.SuscripcionRepository;
import com.mindhub.duodanzaclub.services.SuscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class SuscripcionServiceImpl implements SuscripcionService {

     @Autowired
     SuscripcionRepository suscripcionRepository;

    @Override
    public List<SuscripcionDTO> getSuscripciones() {
        return suscripcionRepository.findAll().stream().map(SuscripcionDTO::new).collect(Collectors.toList());
    }

    @Override
    public Suscripcion getSuscripcion(Long id) {
        return suscripcionRepository.findById(id).orElse(null);
    }

    @Override
    public void guardarSuscripcion(Suscripcion suscripcion) {
        suscripcionRepository.save(suscripcion);
    }


}
