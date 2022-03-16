package com.mindhub.duodanzaclub.dtos;

import com.mindhub.duodanzaclub.models.Estilos;
import com.mindhub.duodanzaclub.models.Productos;
import com.mindhub.duodanzaclub.models.TipoProducto;

public class ProductoDTO {

    private long id;
    private String titulo;
    private String descripcion;
    private Double precio;
    private String imagen;
    private Estilos estilo;
    private String talle;
    private TipoProducto tipoProducto;
    private int stock;

    public ProductoDTO() {}



    public ProductoDTO(Productos productos) {
        this.id = productos.getId();
        this.titulo = productos.getTitulo();
        this.descripcion = productos.getDescripcion();
        this.precio = productos.getPrecio();
        this.imagen = productos.getImagen();
        this.estilo = productos.getEstilo();
        this.talle = productos.getTalle();
        this.tipoProducto = productos.getTipoProducto();
        this.stock = productos.getStock();
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


}
