package com.mindhub.duodanzaclub.services;

import com.mindhub.duodanzaclub.dtos.AcademiaDTO;

import java.util.List;

public interface AcademiaService {
    public List<AcademiaDTO> getAcademias();
    public AcademiaDTO getAcademia(long id);
}
