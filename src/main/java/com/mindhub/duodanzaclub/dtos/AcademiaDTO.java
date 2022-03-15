package com.mindhub.duodanzaclub.dtos;

import com.mindhub.duodanzaclub.models.Academia;
import com.mindhub.duodanzaclub.models.Clase;
import com.mindhub.duodanzaclub.models.Sala;
import com.mindhub.duodanzaclub.models.Usuario;

import java.util.Set;
import java.util.stream.Collectors;

public class AcademiaDTO {
    private long id;
    private String nombre;
    private String ciudad;
    private Set<UsuarioDTO> usuarios;
    private Set<ClaseDTO> clases;
    private Set<SalaDTO> salas;

    public AcademiaDTO() {}
    public AcademiaDTO(Academia academia) {
        setId(academia.getId());
        setNombre(academia.getNombre());
        setCiudad(academia.getCiudad());
        setUsuarios(academia.getUsuarios().stream().map(UsuarioDTO::new).collect(Collectors.toSet()));
        setClases(academia.getClases().stream().map(ClaseDTO::new).collect(Collectors.toSet()));
        setSalas(academia.getSalas().stream().map(SalaDTO::new).collect(Collectors.toSet()));
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

    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Set<UsuarioDTO> getUsuarios() {
        return usuarios;
    }
    public void setUsuarios(Set<UsuarioDTO> usuarios) {
        this.usuarios = usuarios;
    }

    public Set<ClaseDTO> getClases() {
        return clases;
    }
    public void setClases(Set<ClaseDTO> clases) {
        this.clases = clases;
    }

    public Set<SalaDTO> getSalas() {
        return salas;
    }
    public void setSalas(Set<SalaDTO> salas) {
        this.salas = salas;
    }
}
