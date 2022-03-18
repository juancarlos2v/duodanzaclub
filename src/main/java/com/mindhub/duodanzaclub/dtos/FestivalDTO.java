package com.mindhub.duodanzaclub.dtos;

import com.mindhub.duodanzaclub.models.Dias;
import com.mindhub.duodanzaclub.models.Estilos;
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
    private String horarios;
    private String imagen;
    private String descripcion;
    private Estilos estilo;
    private List<Dias> dias = new ArrayList<>();
    private Set<SalaFestivalDTO> salas = new HashSet<>();



    public FestivalDTO(){}
    public FestivalDTO(Festival festival){
        setId(festival.getId());
        setNombre(festival.getNombre());
        setPrecio(festival.getPrecio());
        setImagen(festival.getImagen());
        setDescripcion(festival.getDescripcion());
        setEstilo(festival.getEstilo());
        setDias(festival.getDias());
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

    public String getHorarios() {
        return horarios;
    }
    public void setHorarios(String horarios) {
        this.horarios = horarios;
    }

    public Set<SalaFestivalDTO> getSalas() {
        return salas;
    }
    public void setSalas(Set<SalaFestivalDTO> salas) {
        this.salas = salas;
    }

    public String getImagen() {return imagen;}
    public void setImagen(String imagen) {this.imagen = imagen;}

    public String getDescripcion() {return descripcion;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

    public Estilos getEstilo() {return estilo;}
    public void setEstilo(Estilos estilo) {this.estilo = estilo;}

    public List<Dias> getDias() {return dias;}
    public void setDias(List<Dias> dias) {this.dias = dias;}

}
