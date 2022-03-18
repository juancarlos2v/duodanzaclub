package com.mindhub.duodanzaclub.dtos;

import com.mindhub.duodanzaclub.models.Clase;
import com.mindhub.duodanzaclub.models.Profesor;
import com.mindhub.duodanzaclub.models.ProfesorClase;

public class ProfesorClaseDTO {
    private long id;
    private Profesor profesor;
    private Clase clase;
    private String profesorString;

    public ProfesorClaseDTO(){}
    public ProfesorClaseDTO(ProfesorClase profesorClase){
        setId(profesorClase.getId());
        this.profesorString = profesorClase.getProfesor().getNombre() + " " + profesorClase.getProfesor().getApellido();
    }

    public String getProfesorString() {
        return profesorString;
    }

    public void setProfesorString(String profesorString) {
        this.profesorString = profesorString;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {this.id = id;}

    public Profesor getProfesor() {
        return profesor;
    }
    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Clase getClase() {
        return clase;
    }
    public void setClase(Clase clase) {
        this.clase = clase;
    }
}
