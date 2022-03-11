package com.mindhub.duodanzaclub.dtos;

import com.mindhub.duodanzaclub.models.Festival;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FestivalDTO {
    private long id;
    private String nombre;
    private Double precio;
    private List<Double> horarios = new ArrayList<>();
    private Set<SalaFestivalDTO> salas = new HashSet<>();

    public FestivalDTO(){}
    public FestivalDTO(Festival festival){
        setId(festival.getId());
        setNombre(festival.getNombre());
        setPrecio(festival.getPrecio());
        setHorarios(festival.getHorarios());
        setSalas(festival.getSalaFestival().stream().map(SalaFestivalDTO::new).collect(Collectors.toSet()));
    }

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

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public List<Double> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Double> horarios) {
        this.horarios = horarios;
    }

    public Set<SalaFestivalDTO> getSalas() {
        return salas;
    }

    public void setSalas(Set<SalaFestivalDTO> salas) {
        this.salas = salas;
    }
}
