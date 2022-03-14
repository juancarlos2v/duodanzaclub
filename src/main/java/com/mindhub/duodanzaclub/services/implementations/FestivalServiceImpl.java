package com.mindhub.duodanzaclub.services.implementations;

import com.mindhub.duodanzaclub.dtos.FestivalDTO;
import com.mindhub.duodanzaclub.models.Festival;
import com.mindhub.duodanzaclub.repositories.FestivalRepository;
import com.mindhub.duodanzaclub.services.FestivalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FestivalServiceImpl implements FestivalService {

    @Autowired
    FestivalRepository festivalRepository;


    @Override
    public List<FestivalDTO> traerFestivales() {
        return festivalRepository.findAll().stream().map(FestivalDTO::new).collect(Collectors.toList());
    }

    @Override
    public Festival traerFestival(Long id) {
        return festivalRepository.findById(id).orElse(null);
    }

    @Override
    public void guardarFestival(Festival festival) {
        festivalRepository.save(festival);
    }
}
