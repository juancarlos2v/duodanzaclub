package com.mindhub.duodanzaclub.models;

public enum Abono {
    CLASESUELTA(1000.0),
    MENSUAL(2500.0),
    TRIMESTRAL(8000.0);

    private Double precio;

    Abono(Double precio){
        this.precio = precio;
    }
}
