package com.mindhub.duodanzaclub.dtos;

import com.mindhub.duodanzaclub.models.Clase;
import com.mindhub.duodanzaclub.models.Sala;
import com.mindhub.duodanzaclub.models.SalaClase;

public class SalaClaseDTO {
    private long id;
    private Sala sala;
    private Clase clase;



    public SalaClaseDTO(){}
    public SalaClaseDTO(SalaClase salaClase){
        setId(salaClase.getId());
        setSala(salaClase.getSala());
        setClase(salaClase.getClase());
    }



    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public Sala getSala() {
        return sala;
    }
    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Clase getClase() {
        return clase;
    }
    public void setClase(Clase clase) {
        this.clase = clase;
    }
}
