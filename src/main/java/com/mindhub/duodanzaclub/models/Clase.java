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
    private Estilos estilo;
    private String direccion;
    private String horario;
    private long academiaId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "academias_id")
    private Academia academia;

    @OneToMany(mappedBy = "clase", fetch = FetchType.EAGER)
    private Set<UsuarioClase> usuarioClases = new HashSet<>();

    @OneToMany(mappedBy = "clase", fetch = FetchType.EAGER)
    private Set<SalaClase> salaClases = new HashSet<>();

    @OneToMany(mappedBy = "clase", fetch = FetchType.EAGER)
    private Set<ProfesorClase> profesorClases = new HashSet<>();

    //nivel y cambiar horarios

    public Clase() {}
    public Clase(String nombre, String horario, Academia academia) {
        setNombre(nombre);
        setHorario(horario);
        setAcademia(academia);
    }

    public Clase(String nombre, Estilos estilo, String horario, String direccion, Academia academia) {
        setNombre(nombre);
        setEstilo(estilo);
        setHorario(horario);
        setDireccion(direccion);
        setAcademia(academia);
        setAcademiaId(academia.getId());
        //setProfesorClases(profesores);
    }

    @JsonIgnore
    public List<Sala> getSalas() {
        return  salaClases.stream().map(SalaClase::getSala).collect(toList());
    }

    @JsonIgnore
    public List<Profesor> getProfesores(){
        return profesorClases.stream().map(ProfesorClase::getProfesor).collect(toList());
    }

    @JsonIgnore
    public List<Usuario> getUsuarios(){
        return usuarioClases.stream().map(UsuarioClase::getUsuario).collect(toList());
    }

    public long getId() {return id;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public Estilos getEstilo() {return estilo;}
    public void setEstilo(Estilos estilo) {this.estilo = estilo;}

    public String getHorario() {return horario;}
    public void setHorario(String horario) {this.horario = horario;}

    public String getDireccion() {return direccion;}
    public void setDireccion(String direccion) {this.direccion = direccion;}

    public Academia getAcademia() {return academia;}
    public void setAcademia(Academia academia) {this.academia = academia;}

    public Set<SalaClase> getSalaClases() {return salaClases;}
    public void setSalaClases(Set<SalaClase> salaClases) {this.salaClases = salaClases;}

    public Set<ProfesorClase> getProfesorClases() {return profesorClases;}
    public void setProfesorClases(Set<ProfesorClase> profesorClases) {this.profesorClases = profesorClases;}

    public Set<UsuarioClase> getUsuarioClases() {return usuarioClases;}
    public void setUsuarioClases(Set<UsuarioClase> usuarioClases) {this.usuarioClases = usuarioClases;}

    public long getAcademiaId() {return academiaId;}
    public void setAcademiaId(long academiaId) {this.academiaId = academiaId;}
}
