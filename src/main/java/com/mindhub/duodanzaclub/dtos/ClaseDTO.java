package com.mindhub.duodanzaclub.dtos;

import com.mindhub.duodanzaclub.models.Academia;
import com.mindhub.duodanzaclub.models.Clase;
import com.mindhub.duodanzaclub.models.Estilos;
import com.mindhub.duodanzaclub.models.PrecioClase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ClaseDTO {
    private long id;
    private String nombre;
    private Academia academia;
    private long academiaId;
    private List<Double> horarios = new ArrayList<>();
    private Estilos estilo;
    private PrecioClase precioClase;
    private Set<SalaClaseDTO> salas = new HashSet<>();
    private Set<ProfesorClaseDTO> profesores = new HashSet<>();

    public ClaseDTO(){}
    public ClaseDTO(String nombre, Estilos estilo, long academiaId, List<Double> horarios, PrecioClase precioClase  ){

        setNombre(nombre);
        setEstilo(estilo);
        setAcademiaId(academiaId);
        setHorarios(horarios);
        setPrecioClase(precioClase);
    }

    public ClaseDTO(Clase clase){
        setId(clase.getId());
        setNombre(clase.getNombre());

        setHorarios(clase.getHorarios());
        setPrecioClase(clase.getPrecioClase());
        setHorarios(clase.getHorarios());
        setSalas(clase.getSalaClases().stream().map(SalaClaseDTO::new).collect(Collectors.toSet()));
        setProfesores(clase.getProfesorClases().stream().map(ProfesorClaseDTO::new).collect(Collectors.toSet()));
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

    public Academia getAcademia() {
        return academia;
    }

    public void setAcademia(Academia academia) {
        this.academia = academia;
    }

    public List<Double> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Double> horarios) {
        this.horarios = horarios;
    }

    public Set<SalaClaseDTO> getSalas() {
        return salas;
    }

    public void setSalas(Set<SalaClaseDTO> salas) {
        this.salas = salas;
    }

    public Set<ProfesorClaseDTO> getProfesores() {
        return profesores;
    }

    public void setProfesores(Set<ProfesorClaseDTO> profesores) {
        this.profesores = profesores;
    }

    public long getAcademiaId() {
        return academiaId;
    }

    public void setAcademiaId(long academiaId) {
        this.academiaId = academiaId;
    }

    public Estilos getEstilo() {
        return estilo;
    }

    public void setEstilo(Estilos estilo) {
        this.estilo = estilo;
    }

    public PrecioClase getPrecioClase() {
        return precioClase;
    }

    public void setPrecioClase(PrecioClase precioClase) {
        this.precioClase = precioClase;
    }
}
