package com.mindhub.duodanzaclub.dtos;

import com.mindhub.duodanzaclub.models.Academia;
import com.mindhub.duodanzaclub.models.Profesor;
import com.mindhub.duodanzaclub.models.ProfesorClase;

import java.util.Set;
import java.util.stream.Collectors;

public class ProfesorDTO {
    private long id;
    private String nombre;
    private String apellido;
    private Set<ProfesorClaseDTO> profesorClase;


    public ProfesorDTO() {
    }

    public ProfesorDTO(Profesor profesor) {
        this.id = profesor.getId();
        this.nombre = profesor.getNombre();
        this.apellido = profesor.getApellido();
        this.profesorClase = profesor.getProfesorClases().stream().map(ProfesorClaseDTO::new).collect(Collectors.toSet());
    }


    public long getId() {return id;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getApellido() {return apellido;}
    public void setApellido(String apellido) {this.apellido = apellido;}

    public Set<ProfesorClaseDTO> getProfesorClase() {return profesorClase;}
    public void setProfesorClase(Set<ProfesorClaseDTO> profesorClase) {this.profesorClase = profesorClase;}

}
