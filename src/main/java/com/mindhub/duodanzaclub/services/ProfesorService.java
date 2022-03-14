package com.mindhub.duodanzaclub.services;

import com.mindhub.duodanzaclub.dtos.ProfesorDTO;
import com.mindhub.duodanzaclub.models.Profesor;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ProfesorService {

    public List<ProfesorDTO> getProfesores();

    public Profesor getProfesor(@PathVariable Long id);

    public void guardarProfesor(Profesor profesor);
}
