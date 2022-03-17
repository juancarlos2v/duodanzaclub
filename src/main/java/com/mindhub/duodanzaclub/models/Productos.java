package com.mindhub.duodanzaclub.models;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Productos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private String titulo;
    private String descripcion;
    private Double precio;
    private String imagen;
    private Estilos estilo;
    private String talle;
    private TipoProducto tipoProducto;
    private int stock;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "producto_id")
    private Transaccion transaccion;

    @OneToMany(mappedBy = "producto", fetch = FetchType.EAGER)
    private List<TransaccionProducto> transaccionProductos = new ArrayList<>();


    public Productos() {}
    public Productos(String titulo, String descripcion, Double precio, String imagen, Estilos estilo, String talle, TipoProducto tipoProducto, int stock) {
        setTitulo(titulo);
        setDescripcion(descripcion);
        setPrecio(precio);
        setImagen(imagen);
        setEstilo(estilo);
        setTalle(talle);
        setTipoProducto(tipoProducto);
        setStock(stock);
    }

    public long getId() {return id;}

    public String getTitulo() {return titulo;}
    public void setTitulo(String titulo) {this.titulo = titulo;}

    public String getDescripcion() {return descripcion;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

    public Double getPrecio() {return precio;}
    public void setPrecio(Double precio) {this.precio = precio;}

    public String getImagen() {return imagen;}
    public void setImagen(String imagen) {this.imagen = imagen;}

    public Estilos getEstilo() {return estilo;}
    public void setEstilo(Estilos estilo) {this.estilo = estilo;}

    public String getTalle() {return talle;}
    public void setTalle(String talle) {this.talle = talle;}

    public TipoProducto getTipoProducto() {return tipoProducto;}
    public void setTipoProducto(TipoProducto tipoProducto) {this.tipoProducto = tipoProducto;}

    public int getStock() {return stock;}
    public void setStock(int stock) {this.stock = stock;}

    public Transaccion getTransaccion() {return transaccion;}
    public void setTransaccion(Transaccion transaccion) {this.transaccion = transaccion;}

}


