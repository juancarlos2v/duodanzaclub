package com.mindhub.duodanzaclub.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Academia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private String nombre;
    private String ciudad;

    @OneToMany(mappedBy = "academia", fetch = FetchType.EAGER)
    Set<Usuario> usuarios = new HashSet<>();

    @OneToMany(mappedBy = "academia", fetch = FetchType.EAGER)
    Set<Clase> clases = new HashSet<>();

    @OneToMany(mappedBy = "academia", fetch = FetchType.EAGER)
    Set<Sala> salas = new HashSet<>();

    public Academia() {}
    public Academia(String nombre, String ciudad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
    }

    public long getId() {return id;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getCiudad() {return ciudad;}
    public void setCiudad(String ciudad) {this.ciudad = ciudad;}

    public Set<Usuario> getUsuarios() {return usuarios;}
    public void setUsuarios(Set<Usuario> usuarios) {this.usuarios = usuarios;}

    public Set<Clase> getClases() {return clases;}
    public void setClases(Set<Clase> clases) {this.clases = clases;}

    public Set<Sala> getSalas() {return salas;}
    public void setSalas(Set<Sala> salas) {this.salas = salas;}

}
