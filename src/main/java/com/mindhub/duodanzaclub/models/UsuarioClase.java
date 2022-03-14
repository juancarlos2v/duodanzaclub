package com.mindhub.duodanzaclub.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class UsuarioClase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "clase_id")
    private Clase clase;

    private Rol rol;



    public UsuarioClase(){}
    public UsuarioClase(Usuario usuario, Clase clase){
        setUsuario(usuario);
        setClase(clase);
        setRol(usuario.getRol());
    }



    public long getId() {return id;}

    public Usuario getUsuario() {return usuario;}
    public void setUsuario(Usuario usuario) {this.usuario = usuario;}

    public Clase getClase() {return clase;}
    public void setClase(Clase clase) {this.clase = clase;}

    public Rol getRol() {return rol;}
    public void setRol(Rol rol) {this.rol = rol;}
}
