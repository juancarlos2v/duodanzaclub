package com.mindhub.duodanzaclub.dtos;

import com.mindhub.duodanzaclub.models.*;

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
    private Estilos estilo;
    private String horario;
    private String direccion;
    private Set<SalaClaseDTO> salas = new HashSet<>();
    private Set<ProfesorClaseDTO> profesores = new HashSet<>();
    private List<UsuarioDTO> usuarios = new ArrayList<>();

    public ClaseDTO(){}
    public ClaseDTO(String nombre, Estilos estilo, long academiaId, String horario, String direccion, PrecioClase precioClase){
        setNombre(nombre);
        setEstilo(estilo);
        setAcademiaId(academiaId);
        setHorario(horario);
        setDireccion(direccion);
    }
    public ClaseDTO(Clase clase){
        setId(clase.getId());
        setNombre(clase.getNombre());
        setEstilo(clase.getEstilo());
        setHorario(clase.getHorario());
        setDireccion(clase.getDireccion());
        setSalas(clase.getSalaClases().stream().map(SalaClaseDTO::new).collect(Collectors.toSet()));
        setProfesores(clase.getProfesorClases().stream().map(ProfesorClaseDTO::new).collect(Collectors.toSet()));
        setUsuarios(clase.getUsuarios().stream().map(UsuarioDTO::new).collect(Collectors.toList()));
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

    public String getHorario() {return horario;}
    public void setHorario(String horario) {this.horario = horario;}

    public String getDireccion() {return direccion;}
    public void setDireccion(String direccion) {this.direccion = direccion;}

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

    public List<UsuarioDTO> getUsuarios() {return usuarios;}
    public void setUsuarios(List<UsuarioDTO> usuarios) {this.usuarios = usuarios;}
}
