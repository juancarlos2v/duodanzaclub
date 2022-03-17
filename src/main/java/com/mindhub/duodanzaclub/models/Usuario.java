package com.mindhub.duodanzaclub.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mindhub.duodanzaclub.dtos.SuscripcionDTO;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

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
    private String ciudad;
    private Nivel nivel;
    private Rol rol;
    private Abono abono;
    private String foto;
    private String descripcion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="academia_id")
    private Academia academia;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
    private Set<UsuarioClase> usuarioClases = new HashSet<UsuarioClase>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "UserRel", joinColumns = {@JoinColumn(name = "followers")}, inverseJoinColumns = {@JoinColumn(name = "following")})
    private Set<Usuario> followers = new HashSet<Usuario>();

    @ManyToMany(mappedBy = "followers", cascade = CascadeType.ALL)
    private Set<Usuario> following = new HashSet<Usuario>();

    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
    private List<Transaccion> transacciones = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "suscripcion_id")
    private Suscripcion suscripcion;

    @ElementCollection
    @Column(name = "contactos")
    private List<Long> contactos = new ArrayList<Long>();


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
    public Usuario(String nombre, String apellido, String telefono, String email, String password, LocalDate fechaNacimiento, String ciudad, Nivel nivel, Rol rol) {
        setNombre(nombre);
        setApellido(apellido);
        setTelefono(telefono);
        setEmail(email);
        setPassword(password);
        setFechaNacimiento(fechaNacimiento);
        setCiudad(ciudad);
        setNivel(nivel);
        setRol(rol);
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

    public String getCiudad() {return ciudad;}
    public void setCiudad(String ciudad) {this.ciudad = ciudad;}

    public Nivel getNivel() {return nivel;}
    public void setNivel(Nivel nivel) {this.nivel = nivel;}

    public Rol getRol() {return rol;}
    public void setRol(Rol rol) {this.rol = rol;}

    public Abono getAbono() {return abono;}
    public void setAbono(Abono abono) {this.abono = abono;}

    public Academia getAcademia() {return academia;}
    public void setAcademia(Academia academia) {this.academia = academia;}

    @JsonIgnore
    public Set<Usuario> getFollowers() {return followers;}

    public void setFollowers(Set<Usuario> followers) {this.followers = followers;}

    @JsonIgnore
    public Set<Usuario> getFollowing() {return following;}

    public void setFollowing(Set<Usuario> following) {this.following = following;}

    @JsonIgnore
    public List<Long> getContactos() {return contactos;}

    public void setContactos(List<Long> contactos) {this.contactos = contactos;}

    public Set<UsuarioClase> getUsuarioClases() {return usuarioClases;}

    public void setUsuarioClases(Set<UsuarioClase> usuarioClases) {this.usuarioClases = usuarioClases;}

    @JsonIgnore
    public List<Clase> getClases(){
        return usuarioClases.stream().map(usuarioClase -> usuarioClase.getClase()).collect(toList());
    }

    @JsonIgnore
    public List<Transaccion> getTransacciones() {return transacciones;}
    public void setTransacciones(List<Transaccion> transaccions) {this.transacciones = transaccions;}

    public Suscripcion getSuscripcion() {return suscripcion;}

    public void setSuscripcion(Suscripcion suscripcion) {this.suscripcion = suscripcion;}

    public void addTransaccion(Transaccion transaccion){
        transaccion.setUsuario(this);
        transacciones.add(transaccion);
    }

    public String getFoto() {return foto;}
    public void setFoto(String foto) {this.foto = foto;}

    public String getDescripcion() {return descripcion;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
}
