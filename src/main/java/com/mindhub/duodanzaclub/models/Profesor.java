package com.mindhub.duodanzaclub.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private String nombre;
    private String apellido;

    @OneToMany(mappedBy = "profesor", fetch = FetchType.EAGER)
    private Set<ProfesorClase> profesorClases = new HashSet<>();



    public Profesor(){}
    public Profesor(String nombre, String apellido) {
        setNombre(nombre);
        setApellido(apellido);

    }



    @JsonIgnore
    public List<Clase> getClases(){
        return profesorClases.stream().map(ProfesorClase::getClase).collect(Collectors.toList());
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Set<ProfesorClase> getProfesorClases() {
        return profesorClases;
    }
    public void setProfesorClases(Set<ProfesorClase> profesorClases) {
        this.profesorClases = profesorClases;
    }

}
