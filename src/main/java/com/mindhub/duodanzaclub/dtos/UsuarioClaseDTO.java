package com.mindhub.duodanzaclub.dtos;

import com.mindhub.duodanzaclub.models.Rol;
import com.mindhub.duodanzaclub.models.UsuarioClase;

public class UsuarioClaseDTO {
    private long id;
    private long clase_id;
    private Rol rol;



    public UsuarioClaseDTO(){}
    public UsuarioClaseDTO(UsuarioClase usuarioClase){
        setId(usuarioClase.getId());
        setClase_id(usuarioClase.getClase().getId());
        setRol(usuarioClase.getRol());
    }



    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    public long getClase_id() {return clase_id;}
    public void setClase_id(Long id) {this.clase_id = id;}

    public Rol getRol() {return rol;}
    public void setRol(Rol rol) {this.rol = rol;}
}
