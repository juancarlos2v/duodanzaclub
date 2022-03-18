package com.mindhub.duodanzaclub.dtos;

public class SolicitudDTO {
    private long usuario;
    private long usuario2;

    public SolicitudDTO(){}
    public SolicitudDTO(long usuario){
        setUsuario(usuario);
    }
    public SolicitudDTO(long usuario, long usuario2){
        setUsuario(usuario);
        setUsuario2(usuario2);
    }

    public long getUsuario() {
        return usuario;
    }
    public void setUsuario(long usuario) {
        this.usuario = usuario;
    }

    public long getUsuario2() {return usuario2;}
    public void setUsuario2(long usuario2) {this.usuario2 = usuario2;}
}
