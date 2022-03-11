package com.mindhub.duodanzaclub.models;

public enum Abono {
    MENSUAL(1000.0),
    TRIMESTRAL(2500.0),
    ANUAL(8000.0);

    private Double precio;

    Abono(Double precio){
        this.precio = precio;
    }
}
