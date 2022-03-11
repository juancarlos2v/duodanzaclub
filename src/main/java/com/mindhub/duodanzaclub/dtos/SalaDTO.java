package com.mindhub.duodanzaclub.dtos;

import com.mindhub.duodanzaclub.models.Academia;
import com.mindhub.duodanzaclub.models.Sala;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class SalaDTO {
    private long id;
    private String nombre;
    private int aforo;
    private Academia academia;
    private Set<SalaClaseDTO> clases = new HashSet<>();
    private Set<SalaFestivalDTO> festivales = new HashSet<>();

    public SalaDTO(){}
    public SalaDTO(Sala sala){
        setId(sala.getId());
        setNombre(sala.getNombre());
        setAforo(sala.getAforo());
        setAcademia(sala.getAcademia());
        setClases(sala.getSalaClases().stream().map(SalaClaseDTO::new).collect(Collectors.toSet()));
        setFestivales(sala.getSalaFestival().stream().map(SalaFestivalDTO::new).collect(Collectors.toSet()));
    }
 //JOYA
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAforo() {
        return aforo;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }

    public Academia getAcademia() {
        return academia;
    }

    public void setAcademia(Academia academia) {
        this.academia = academia;
    }

    public Set<SalaClaseDTO> getClases() {
        return clases;
    }

    public void setClases(Set<SalaClaseDTO> clases) {
        this.clases = clases;
    }

    public Set<SalaFestivalDTO> getFestivales() {
        return festivales;
    }

    public void setFestivales(Set<SalaFestivalDTO> festivales) {
        this.festivales = festivales;
    }
}
