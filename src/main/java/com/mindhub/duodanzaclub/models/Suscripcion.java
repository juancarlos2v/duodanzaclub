package com.mindhub.duodanzaclub.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Suscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private String nombre;

    @ElementCollection
    @Column(name = "precio")
    private List<Double> precios = new ArrayList<>();

    @ElementCollection
    @Column(name = "clases")
    private List<Integer> clases = new ArrayList<>();

    @OneToMany(mappedBy = "suscripcion", fetch = FetchType.EAGER)
    private Set<Usuario> usuarios = new HashSet<>();


    public Suscripcion() {
    }

    public Suscripcion(String nombre, List<Double> precios, List<Integer> clases) {
        setNombre(nombre);
        setPrecios(precios);
        setClases(clases);
    }


    public long getId() {return id;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public List<Double> getPrecios() {return precios;}
    public void setPrecios(List<Double> precios) {this.precios = precios;}

    public List<Integer> getClases() {return clases;}
    public void setClases(List<Integer> clases) {this.clases = clases;}

    @JsonIgnore
    public Set<Usuario> getUsuarios() {return usuarios;}
    public void setUsuarios(Set<Usuario> usuarios) {this.usuarios = usuarios;}



}
