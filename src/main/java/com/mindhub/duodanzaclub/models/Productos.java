package com.mindhub.duodanzaclub.models;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
    private TipoProducto tipoProducto;

    public Productos() {}
    public Productos(String titulo, String descripcion, Double precio, String imagen, Estilos estilo, TipoProducto tipoProducto) {
        setTitulo(titulo);
        setDescripcion(descripcion);
        setPrecio(precio);
        setImagen(imagen);
        setEstilo(estilo);
        setTipoProducto(tipoProducto);
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

    public TipoProducto getTipoProducto() {return tipoProducto;}
    public void setTipoProducto(TipoProducto tipoProducto) {this.tipoProducto = tipoProducto;}

}
