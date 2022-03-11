package com.mindhub.duodanzaclub.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

@Entity
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private String nombre;
    private int numero;
    private int aforo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Academia_Id")
    private Academia academia;

    @OneToMany(mappedBy = "sala", fetch = FetchType.EAGER)
    private Set<SalaClase> salaClases = new HashSet<>();

    @OneToMany(mappedBy = "sala", fetch = FetchType.EAGER)
    private Set<SalaFestival> salaFestival = new HashSet<>();



    public Sala() {
    }

    public Sala(String nombre, int numero, int aforo, Academia academia) {
        this.nombre = nombre;
        this.numero = numero;
        this.aforo = aforo;
        this.academia = academia;
    }




    @JsonIgnore
    public List<Clase> getClases() {
        return  salaClases.stream().map(salaClase -> salaClase.getClase()).collect(toList());
    }

    @JsonIgnore
    public List<Festival> getFestivales() {
        return  salaFestival.stream().map(salaFestival -> salaFestival.getFestival()).collect(toList());
    }

    public long getId() {return id;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public int getNumero() {return numero;}
    public void setNumero(int numero) {this.numero = numero;}

    public int getAforo() {return aforo;}
    public void setAforo(int aforo) {this.aforo = aforo;}

    public Academia getAcademia() {return academia;}
    public void setAcademia(Academia academia) {this.academia = academia;}

    public Set<SalaClase> getSalaClases() {return salaClases;}
    public void setSalaClases(Set<SalaClase> salaClases) {this.salaClases = salaClases;}

    public Set<SalaFestival> getSalaFestival() {return salaFestival;}
    public void setSalaFestival(Set<SalaFestival> salaFestival) {this.salaFestival = salaFestival;}

}
