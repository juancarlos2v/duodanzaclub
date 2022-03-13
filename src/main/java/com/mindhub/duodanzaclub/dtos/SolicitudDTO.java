package com.mindhub.duodanzaclub.dtos;

public class SolicitudDTO {
    private long usuario1;
    private long usuario2;

    public SolicitudDTO(){}
    public SolicitudDTO(long usuario2){
        setUsuario2(usuario2);
    }
    public SolicitudDTO(long usuario1, long usuario2){
        setUsuario1(usuario1);
        setUsuario2(usuario2);
    }

    public long getUsuario1() {
        return usuario1;
    }

    public void setUsuario1(long usuario1) {
        this.usuario1 = usuario1;
    }

    public long getUsuario2() {
        return usuario2;
    }

    public void setUsuario2(long usuario2) {
        this.usuario2 = usuario2;
    }
}
