package com.mindhub.duodanzaclub.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

@Entity
public class Clase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private String nombre;

    @ElementCollection
    @Column(name="horarios")
    private List<Double> horarios = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Academia_Id")
    private Academia academia;

    @OneToMany(mappedBy = "clase", fetch = FetchType.EAGER)
    private Set<SalaClase> salaClases = new HashSet<>();

    @OneToMany(mappedBy = "clase", fetch = FetchType.EAGER)
    private Set<ProfesorClase> profesorClases = new HashSet<>();

    public Clase() {}
    public Clase(String nombre, List<Double> horarios, Academia academia) {
        setNombre(nombre);
        setHorarios(horarios);
        setAcademia(academia);
    }

    @JsonIgnore
    public List<Sala> getSalas() {
        return  salaClases.stream().map(salaClase -> salaClase.getSala()).collect(toList());
    }

    @JsonIgnore
    public List<Profesor> getProfesores(){
        return profesorClases.stream().map(profesorClase -> profesorClase.getProfesor()).collect(toList());
    }

    public long getId() {return id;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public List<Double> getHorarios() {return horarios;}
    public void setHorarios(List<Double> horarios) {this.horarios = horarios;}

    public Academia getAcademia() {return academia;}
    public void setAcademia(Academia academia) {this.academia = academia;}

    public Set<SalaClase> getSalaClases() {return salaClases;}
    public void setSalaClases(Set<SalaClase> salaClases) {this.salaClases = salaClases;}

    public Set<ProfesorClase> getProfesorClases() {return profesorClases;}
    public void setProfesorClases(Set<ProfesorClase> profesorClases) {this.profesorClases = profesorClases;}
}
