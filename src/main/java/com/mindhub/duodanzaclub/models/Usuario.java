package com.mindhub.duodanzaclub.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private String password;
    private LocalDate fechaNacimiento;
    private Nivel nivel;
    private Rol rol;
    private Abono abono;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="Academia_Id")
    private Academia academia;

    /*@OneToMany(mappedBy = "usuario1", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<ContactoUsuario> contactoUsuarios = new HashSet<>();*/

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "UserRel", joinColumns = {@JoinColumn(name = "followers")}, inverseJoinColumns = {@JoinColumn(name = "following")})
    private Set<Usuario> followers = new HashSet<Usuario>();

    @ManyToMany(mappedBy = "followers", cascade = CascadeType.ALL)
    private Set<Usuario> following = new HashSet<Usuario>();

    @ElementCollection
    @Column(name = "contactos")
    private Set<Long> contactos = new HashSet<Long>();

    public Usuario() {}
    public Usuario(String email, String password){
        this.email = email;
        this.password = password;
    }
    public Usuario(String nombre, String apellido, String telefono, String email, String password, LocalDate fechaNacimiento) {
        setNombre(nombre);
        setApellido(apellido);
        setTelefono(telefono);
        setEmail(email);
        setPassword(password);
        setFechaNacimiento(fechaNacimiento);
    }
    public Usuario(String nombre, String apellido, String telefono, String email, String password, LocalDate fechaNacimiento, Nivel nivel, Rol rol, Abono abono, Academia academia) {
        setNombre(nombre);
        setApellido(apellido);
        setTelefono(telefono);
        setEmail(email);
        setPassword(password);
        setFechaNacimiento(fechaNacimiento);
        setNivel(nivel);
        setRol(rol);
        setAbono(abono);
        setAcademia(academia);
    }

    public long getId() {return id;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getApellido() {return apellido;}
    public void setApellido(String apellido) {this.apellido = apellido;}

    public String getTelefono() {return telefono;}
    public void setTelefono(String telefono) {this.telefono = telefono;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public LocalDate getFechaNacimiento() {return fechaNacimiento;}
    public void setFechaNacimiento(LocalDate fechaNacimiento) {this.fechaNacimiento = fechaNacimiento;}

    public Nivel getNivel() {return nivel;}
    public void setNivel(Nivel nivel) {this.nivel = nivel;}

    public Rol getRol() {return rol;}
    public void setRol(Rol rol) {this.rol = rol;}

    public Abono getAbono() {return abono;}
    public void setAbono(Abono abono) {this.abono = abono;}

    public Academia getAcademia() {return academia;}
    public void setAcademia(Academia academia) {this.academia = academia;}

    /*public Set<ContactoUsuario> getContactoUsuarios() {return contactoUsuarios;}

    public void setContactoUsuarios(Set<ContactoUsuario> contactoUsuarios) {this.contactoUsuarios = contactoUsuarios;}*/

    @JsonIgnore
    public Set<Usuario> getFollowers() {return followers;}

    public void setFollowers(Set<Usuario> followers) {this.followers = followers;}

    @JsonIgnore
    public Set<Usuario> getFollowing() {return following;}

    public void setFollowing(Set<Usuario> following) {this.following = following;}

    @JsonIgnore
    public Set<Long> getContactos() {return contactos;}

    public void setContactos(Set<Long> contactos) {this.contactos = contactos;}
}
