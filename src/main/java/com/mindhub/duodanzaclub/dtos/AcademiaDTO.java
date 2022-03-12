package com.mindhub.duodanzaclub.dtos;

import com.mindhub.duodanzaclub.models.Academia;
import com.mindhub.duodanzaclub.models.Clase;
import com.mindhub.duodanzaclub.models.Sala;
import com.mindhub.duodanzaclub.models.Usuario;

import java.util.Set;

public class AcademiaDTO {
    private long id;
    private String nombre;
    private String ciudad;
    private Set<Usuario> usuarios;
    private Set<Clase> clases;
    private Set<Sala> salas;

    public AcademiaDTO() {}
    public AcademiaDTO(Academia academia) {
        setId(academia.getId());
        setNombre(academia.getNombre());
        setCiudad(academia.getCiudad());
        setUsuarios(academia.getUsuarios());
        setClases(academia.getClases());
        setSalas(academia.getSalas());
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

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Set<Clase> getClases() {
        return clases;
    }

    public void setClases(Set<Clase> clases) {
        this.clases = clases;
    }

    public Set<Sala> getSalas() {
        return salas;
    }

    public void setSalas(Set<Sala> salas) {
        this.salas = salas;
    }
}
