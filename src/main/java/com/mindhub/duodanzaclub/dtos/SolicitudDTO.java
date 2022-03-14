package com.mindhub.duodanzaclub.dtos;

public class SolicitudDTO {
    private long usuario;

    public SolicitudDTO(){}
    public SolicitudDTO(long usuario){
        setUsuario(usuario);
    }

    public long getUsuario() {
        return usuario;
    }

    public void setUsuario(long usuario) {
        this.usuario = usuario;
    }
}
