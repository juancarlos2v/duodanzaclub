package com.mindhub.duodanzaclub.dtos;

import com.mindhub.duodanzaclub.models.Festival;
import com.mindhub.duodanzaclub.models.Sala;
import com.mindhub.duodanzaclub.models.SalaFestival;

public class SalaFestivalDTO {
    private long id;
    private Sala sala;
    private Festival festival;

    public SalaFestivalDTO(){}
    public SalaFestivalDTO(SalaFestival salaFestival){
        setId(salaFestival.getId());
        setSala(salaFestival.getSala());
        setFestival(salaFestival.getFestival());
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

    public Festival getFestival() {
        return festival;
    }

    public void setFestival(Festival festival) {
        this.festival = festival;
    }
}
