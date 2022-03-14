package com.mindhub.duodanzaclub.services;

import com.mindhub.duodanzaclub.dtos.AcademiaDTO;
import com.mindhub.duodanzaclub.models.Academia;

import java.util.List;

public interface AcademiaService {
    public List<AcademiaDTO> getAcademias();
    public List<Academia> getAcademies();
    public AcademiaDTO getAcademia(long id);
    public Academia getAcademiaClass(long id);
    public void guardarAcademia(Academia academia);
}
