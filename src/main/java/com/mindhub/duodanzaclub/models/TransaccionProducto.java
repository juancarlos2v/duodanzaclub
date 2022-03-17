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
    private Productos producto;

    public TransaccionProducto(){}
    public TransaccionProducto(Transaccion transaccion, Productos producto){
        setTransaccion(transaccion);
        setProducto(producto);
    }

    public long getId() {return id;}

    public Transaccion getTransaccion() {return transaccion;}

    public void setTransaccion(Transaccion transaccion) {this.transaccion = transaccion;}

    public Productos getProducto() {return producto;}

    public void setProducto(Productos producto) {this.producto = producto;}
}
