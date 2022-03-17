package com.mindhub.duodanzaclub.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mindhub.duodanzaclub.models.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UsuarioDTO {
    private long id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private String password;
    private int dia;
    private int mes;
    private int anio;
    private Nivel nivel;
    private Rol rol;
    private Abono abono;
    private Academia academia;
    private LocalDate fechaNacimiento;
    private String ciudad;
    private String descripcion;
    private String foto;
    private Set<Usuario> followers = new HashSet<Usuario>();
    private Set<Usuario> following = new HashSet<Usuario>();
    private List<Long> contactos = new ArrayList<Long>();
    public List<UsuarioClaseDTO> clases = new ArrayList<>();
    private List<TransaccionDTO> transacciones = new ArrayList<>();
    private Suscripcion suscripcion;


    public UsuarioDTO(){}
    public UsuarioDTO(String nombre, String apellido, String telefono, String email, String password, int dia, int mes, int anio){
        setNombre(nombre);
        setApellido(apellido);
        setTelefono(telefono);
        setEmail(email);
        setPassword(password);
        setDia(dia);
        setMes(mes);
        setAnio(anio);
    }
    public UsuarioDTO(String nombre, String apellido, String telefono, String email, String password, int dia, int mes,
                      int anio, Nivel nivel, Rol rol, Abono abono, Academia academia){
        setNombre(nombre);
        setApellido(apellido);
        setTelefono(telefono);
        setEmail(email);
        setPassword(password);
        setDia(dia);
        setMes(mes);
        setAnio(anio);
        setNivel(nivel);
        setRol(rol);
        setAbono(abono);
        setAcademia(academia);
    }
    public UsuarioDTO(Usuario usuario){
        setId(usuario.getId());
        setNombre(usuario.getNombre());
        setApellido(usuario.getApellido());
        setTelefono(usuario.getTelefono());
        setEmail(usuario.getEmail());
        setFechaNacimiento(usuario.getFechaNacimiento());
        setDescripcion(usuario.getDescripcion());
        setFoto(usuario.getFoto());
        setCiudad(usuario.getCiudad());
        setNivel(usuario.getNivel());
        setRol(usuario.getRol());
        setAbono(usuario.getAbono());
        setAcademia(usuario.getAcademia());
        setFollowers(usuario.getFollowers());
        setFollowing(usuario.getFollowing());
        setContactos(usuario.getContactos());
        setClases(usuario.getUsuarioClases().stream().map(UsuarioClaseDTO::new).collect(Collectors.toList()));
        setTransacciones(usuario.getTransacciones().stream().map(TransaccionDTO::new).collect(Collectors.toList()));
        setSuscripcion(usuario.getSuscripcion());
    }

    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getApellido() {return apellido;}
    public void setApellido(String apellido) {this.apellido = apellido;}

    public String getTelefono() {return telefono;}
    public void setTelefono(String telefono) {this.telefono = telefono;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public LocalDate getFechaNacimiento() {return fechaNacimiento;}
    public void setFechaNacimiento(LocalDate fechaNacimiento) {this.fechaNacimiento = fechaNacimiento;}

    public String getCiudad() {return ciudad;}
    public void setCiudad(String ciudad) {this.ciudad = ciudad;}

    public Academia getAcademia() {return academia;}
    public void setAcademia(Academia academia) {this.academia = academia;}

    public Nivel getNivel() {return nivel;}
    public void setNivel(Nivel nivel) {this.nivel = nivel;}

    public Rol getRol() {return rol;}
    public void setRol(Rol rol) {this.rol = rol;}

    public Abono getAbono() {return abono;}
    public void setAbono(Abono abono) {this.abono = abono;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public int getDia() {return dia;}
    public void setDia(int dia) {this.dia = dia;}

    public int getMes() {return mes;}
    public void setMes(int mes) {this.mes = mes;}

    public int getAnio() {return anio;}
    public void setAnio(int anio) {this.anio = anio;}

    public String getDescripcion() {return descripcion;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

    public String getFoto() {return foto;}
    public void setFoto(String foto) {this.foto = foto;}

    public Set<Usuario> getFollowers() {return followers;}
    public void setFollowers(Set<Usuario> followers) {this.followers = followers;}

    public Set<Usuario> getFollowing() {return following;}
    public void setFollowing(Set<Usuario> following) {this.following = following;}

    public List<Long> getContactos() {return contactos;}
    public void setContactos(List<Long> contactos) {this.contactos = contactos;}

    public List<UsuarioClaseDTO> getClases() {return clases;}
    public void setClases(List<UsuarioClaseDTO> clases) {this.clases = clases;}

    public List<TransaccionDTO> getTransacciones() {return transacciones;}
    public void setTransacciones(List<TransaccionDTO> tickets) {this.transacciones = tickets;}

    //@JsonIgnore
    public Suscripcion getSuscripcion() {return suscripcion;}
    public void setSuscripcion(Suscripcion suscripcion) {this.suscripcion = suscripcion;}



}
