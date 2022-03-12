package com.mindhub.duodanzaclub.dtos;

import com.mindhub.duodanzaclub.models.*;

import java.time.LocalDate;

public class UsuarioDTO {
    private long id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private LocalDate fechaNacimiento;
    private Nivel nivel;
    private Rol rol;
    private Abono abono;
    private Academia academia;

    public UsuarioDTO(){}
    public UsuarioDTO(Usuario usuario){
        setId(usuario.getId());
        setNombre(usuario.getNombre());
        setApellido(usuario.getApellido());
        setTelefono(usuario.getTelefono());
        setEmail(usuario.getEmail());
        setFechaNacimiento(usuario.getFechaNacimiento());
        setNivel(usuario.getNivel());
        setRol(usuario.getRol());
        setAbono(usuario.getAbono());
        setAcademia(usuario.getAcademia());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {this.apellido = apellido;}

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Academia getAcademia() {
        return academia;
    }

    public void setAcademia(Academia academia) {
        this.academia = academia;
    }

    public Nivel getNivel() {return nivel;}

    public void setNivel(Nivel nivel) {this.nivel = nivel;}

    public Rol getRol() {return rol;}

    public void setRol(Rol rol) {this.rol = rol;}

    public Abono getAbono() {return abono;}

    public void setAbono(Abono abono) {this.abono = abono;}
}
