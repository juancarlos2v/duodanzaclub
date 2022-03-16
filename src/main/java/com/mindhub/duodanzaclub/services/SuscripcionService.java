package com.mindhub.duodanzaclub.services;

import com.mindhub.duodanzaclub.dtos.SuscripcionDTO;
import com.mindhub.duodanzaclub.models.Suscripcion;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface SuscripcionService {

    List<SuscripcionDTO> getSuscripciones();

    Suscripcion getSuscripcion(Long id);

    void guardarSuscripcion(Suscripcion suscripcion);
}
