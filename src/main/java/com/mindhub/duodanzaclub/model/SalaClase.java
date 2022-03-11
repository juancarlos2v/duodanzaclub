package com.mindhub.duodanzaclub.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class SalaClase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Clase_Id")
    private Clase clase;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Sala_Id")
    private Sala sala;




    public SalaClase() {
    }

    public SalaClase(Clase clase, Sala sala) {
        this.clase = clase;
        this.sala = sala;
    }




    public long getId() {return id;}

    public Clase getClase() {return clase;}
    public void setClase(Clase clase) {this.clase = clase;}

    public Sala getSala() {return sala;}
    public void setSala(Sala sala) {this.sala = sala;}

}
//JOYA
