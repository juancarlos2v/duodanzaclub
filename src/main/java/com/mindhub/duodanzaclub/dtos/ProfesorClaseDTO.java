package com.mindhub.duodanzaclub.dtos;

import com.mindhub.duodanzaclub.models.Clase;
import com.mindhub.duodanzaclub.models.Profesor;
import com.mindhub.duodanzaclub.models.ProfesorClase;

public class ProfesorClaseDTO {
    private long id;
    private Profesor profesor;
    private Clase clase;



    public ProfesorClaseDTO(){}
    public ProfesorClaseDTO(ProfesorClase profesorClase){
        setId(profesorClase.getId());
        setProfesor(profesorClase.getProfesor());
        setClase(profesorClase.getClase());
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
