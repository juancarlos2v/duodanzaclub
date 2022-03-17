package com.mindhub.duodanzaclub.models;

public enum PrecioClase {
    ESTANDAR(600.0),
    DESCUENTO(500.0),
    USUARIO(400.0);

    private Double precio;

    PrecioClase(Double precio) {
         this.precio = precio;
    }
}

