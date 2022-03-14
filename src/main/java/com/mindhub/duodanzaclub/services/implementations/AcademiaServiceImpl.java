package com.mindhub.duodanzaclub.services.implementations;

import com.mindhub.duodanzaclub.dtos.AcademiaDTO;
import com.mindhub.duodanzaclub.models.Academia;
import com.mindhub.duodanzaclub.repositories.AcademiaRepository;
import com.mindhub.duodanzaclub.services.AcademiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AcademiaServiceImpl implements AcademiaService {

    @Autowired
    AcademiaRepository academiaRepository;

    @Override
    public List<AcademiaDTO> getAcademias(){
        return academiaRepository.findAll().stream().map(AcademiaDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<Academia> getAcademies() {
        return academiaRepository.findAll();
    }

    @Override
    public AcademiaDTO getAcademia(long id){
        Academia academia = academiaRepository.findById(id).orElse(null);;
        AcademiaDTO academiaDTO = new AcademiaDTO(academia);
        return academiaDTO;
    }

    @Override
    public Academia getAcademiaClass(long id) {
        return academiaRepository.findById(id).orElse(null);
    }

    @Override
    public void guardarAcademia(Academia academia) {
        academiaRepository.save(academia);
    }
}
