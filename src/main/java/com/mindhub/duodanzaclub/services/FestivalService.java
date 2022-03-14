package com.mindhub.duodanzaclub.services;


import com.mindhub.duodanzaclub.dtos.FestivalDTO;
import com.mindhub.duodanzaclub.models.Festival;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public interface FestivalService {

    public List<FestivalDTO> traerFestivales();

    public Festival traerFestival(@PathVariable Long id);

    public void guardarFestival(Festival festival);
}
