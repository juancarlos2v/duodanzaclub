package com.mindhub.duodanzaclub.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Clase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private String nombre;
    private List<Double> horarios;
    private String profesor; //PENDIENTE: tipo de dato




    public Clase() {
    }

    public Clase(String nombre, List<Double> horarios, String profesor) {
        this.nombre = nombre;
        this.horarios = horarios;
        this.profesor = profesor;
    }




    public long getId() {return id;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public List<Double> getHorarios() {return horarios;}
    public void setHorarios(List<Double> horarios) {this.horarios = horarios;}

    public String getProfesor() {return profesor;}
    public void setProfesor(String profesor) {this.profesor = profesor;}

}
