package com.mindhub.duodanzaclub.model;

public enum PrecioClase {
    ESTANDAR(300.0),
    DESCUENTO(220.0),
    USUARIO(270.0);

    private Double precio;

    PrecioClase(Double precio) {
         this.precio = precio;
    }
}

