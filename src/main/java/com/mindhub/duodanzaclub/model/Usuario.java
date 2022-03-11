package com.mindhub.duodanzaclub.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

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
    //private Abono abono;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="Academia_Id")
    private Academia academia;




    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String telefono, String email, String password, LocalDate fechaNacimiento, Nivel nivel, Rol rol/*, AEliminar abono*/, Academia academia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.password = password;
        this.fechaNacimiento = fechaNacimiento;
        this.nivel = nivel;
        this.rol = rol;
        //this.abono = abono;
        this.academia = academia;
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

    /*public Abono getAbono() {return abono;}
    public void setAbono(Abono abono) {this.abono = abono;}*/

    public Academia getAcademia() {return academia;}
    public void setAcademia(Academia academia) {this.academia = academia;}

}
