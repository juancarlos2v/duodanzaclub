package com.mindhub.duodanzaclub.services;

import com.mindhub.duodanzaclub.dtos.SalaDTO;
import com.mindhub.duodanzaclub.models.Sala;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface SalaService {
    public List<SalaDTO> obtenerSalasDTO();
    public Sala obtenerSala(@PathVariable Long id);
    public void guardarSala(Sala sala);
}
