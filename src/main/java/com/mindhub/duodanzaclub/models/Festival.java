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
public class Festival {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private String nombre;
    private Double precio;
    private Estilos estilo;
    private String imagen;
    private String ciudad;
    private String descripcion;


    @ElementCollection
    @Column(name="días")
    private List<Dias> dias = new ArrayList<>();


    private String horarios;

    @OneToMany(mappedBy = "festival", fetch = FetchType.EAGER)
    private Set<SalaFestival> salaFestival = new HashSet<>();

    public Festival() {}
    public Festival(String nombre, String imagen, String descripcion, Estilos estilo, Double precio, List<Dias> dias) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.estilo = estilo;
        this.precio = precio;

        this.dias = dias;

    }

    @JsonIgnore
    public List<Sala> getSalas() {return  salaFestival.stream().map(SalaFestival::getSala).collect(toList());}

    public long getId() {return id;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public Double getPrecio() {return precio;}
    public void setPrecio(Double precio) {this.precio = precio;}

    public Estilos getEstilo() {return estilo;}
    public void setEstilo(Estilos estilo) {this.estilo = estilo;}

    public String getHorarios() {return horarios;}
    public void setHorarios(String horarios) {this.horarios = horarios;}

    public Set<SalaFestival> getSalaFestival() {return salaFestival;}
    public void setSalaFestival(Set<SalaFestival> salaFestival) {this.salaFestival = salaFestival;}

    public String getImagen() {return imagen;}
    public void setImagen(String imagen) {this.imagen = imagen;}

    public String getCiudad() {return ciudad;}
    public void setCiudad(String ciudad) {this.ciudad = ciudad;}

    public String getDescripcion() {return descripcion;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

    public List<Dias> getDias() {return dias;}
    public void setDias(List<Dias> dias) {this.dias = dias;}
}
