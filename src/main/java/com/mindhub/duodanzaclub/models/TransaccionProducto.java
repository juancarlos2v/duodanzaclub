package com.mindhub.duodanzaclub.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class TransaccionProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "transaccion_id")
    private Transaccion transaccion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "producto_id")
    private Producto producto;

    public TransaccionProducto(){}
    public TransaccionProducto(Transaccion transaccion, Producto producto){
        setTransaccion(transaccion);
        setProducto(producto);
    }

    public long getId() {return id;}

    public Transaccion getTransaccion() {return transaccion;}

    public void setTransaccion(Transaccion transaccion) {this.transaccion = transaccion;}

    public Producto getProducto() {return producto;}

    public void setProducto(Producto producto) {this.producto = producto;}
}
