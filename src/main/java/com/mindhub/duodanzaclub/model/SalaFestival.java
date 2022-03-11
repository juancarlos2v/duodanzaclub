package com.mindhub.duodanzaclub.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class SalaFestival {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Sala_Id")
    private Sala sala;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Festival_Id")
    private Festival festival;




    public SalaFestival() {
    }

    public SalaFestival(Sala sala, Festival festival) {
        this.sala = sala;
        this.festival = festival;
    }




    public long getId() {return id;}

    public Sala getSala() {return sala;}
    public void setSala(Sala sala) {this.sala = sala;}

    public Festival getFestival() {return festival;}
    public void setFestival(Festival festival) {this.festival = festival;}

}
