package com.mindhub.duodanzaclub.services;

import com.mindhub.duodanzaclub.dtos.ClaseDTO;
import com.mindhub.duodanzaclub.models.Clase;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ClaseService {

    public List<ClaseDTO> traerClases();

    public Clase traerClasePorId(@PathVariable Long id);

    public void guardarClase(Clase clase);
}
