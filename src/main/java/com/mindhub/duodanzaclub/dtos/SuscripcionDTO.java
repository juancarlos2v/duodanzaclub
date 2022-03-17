package com.mindhub.duodanzaclub.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mindhub.duodanzaclub.models.Suscripcion;
import com.mindhub.duodanzaclub.models.Usuario;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SuscripcionDTO {
    private long id;
    private String nombre;
    private List<Double> precios = new ArrayList<>();
    private int clases;
    private Set<UsuarioDTO> usuarios = new HashSet<>();



    public SuscripcionDTO() {
    }

    public SuscripcionDTO(Suscripcion suscripcion) {
        this.id = suscripcion.getId();
        this.nombre = suscripcion.getNombre();
        this.precios = suscripcion.getPrecios();
        this.clases = suscripcion.getClases();
        this.usuarios = suscripcion.getUsuarios().stream().map(UsuarioDTO::new).collect(Collectors.toSet());
    }


    public long getId() {return id;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public List<Double> getPrecios() {return precios;}
    public void setPrecios(List<Double> precios) {this.precios = precios;}

    public int getClases() {return clases;}
    public void setClases(int clases) {this.clases = clases;}

    @JsonIgnore
    public Set<UsuarioDTO> getUsuarios() {return usuarios;}
    public void setUsuarios(Set<UsuarioDTO> usuarios) {this.usuarios = usuarios;}

}
