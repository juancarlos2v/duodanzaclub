package com.mindhub.duodanzaclub.dtos;

import com.mindhub.duodanzaclub.models.Estilos;
import com.mindhub.duodanzaclub.models.Producto;
import com.mindhub.duodanzaclub.models.TipoProducto;

public class ProductoDTO {

    private long id;
    private String titulo;
    private String descripcion;
    private Double precio;
    private String imagen;
    private Estilos estilo;
    private TipoProducto tipoProducto;
    private int stock;

    public ProductoDTO() {}
    public ProductoDTO(Producto producto) {
        this.id = producto.getId();
        this.titulo = producto.getTitulo();
        this.descripcion = producto.getDescripcion();
        this.precio = producto.getPrecio();
        this.imagen = producto.getImagen();
        this.estilo = producto.getEstilo();
        this.tipoProducto = producto.getTipoProducto();
        this.stock = producto.getStock();
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

    public int getStock() {return stock;}
    public void setStock(int stock) {this.stock = stock;}

}
