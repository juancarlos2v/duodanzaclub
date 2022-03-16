package com.mindhub.duodanzaclub.dtos;

import com.mindhub.duodanzaclub.models.Transaccion;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TransaccionDTO {
    private long id;
    private double amount;
    private LocalDateTime date;
    private List<TransaccionProductoDTO> productos = new ArrayList<>();
    private ArrayList<Long> productosTransaccion = new ArrayList<Long>();

    public TransaccionDTO(){}
    public TransaccionDTO(double amount, ArrayList<Long> productos){
        setAmount(amount);
        setProductosTransaccion(productos);
    }
    public TransaccionDTO(Transaccion transaccion){
        setId(transaccion.getId());
        setAmount(transaccion.getAmount());
        setDate(transaccion.getDate());
        setProductos(transaccion.getTransaccionProductos().stream().map(TransaccionProductoDTO::new).collect(Collectors.toList()));
    }

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public double getAmount() {return amount;}

    public void setAmount(double amount) {this.amount = amount;}

    public LocalDateTime getDate() {return date;}

    public void setDate(LocalDateTime date) {this.date = date;}

    public List<TransaccionProductoDTO> getProductos() {return productos;}

    public void setProductos(List<TransaccionProductoDTO> productos) {this.productos = productos;}

    public ArrayList<Long> getProductosTransaccion() {return productosTransaccion;}

    public void setProductosTransaccion(ArrayList<Long> productosTransaccion) {this.productosTransaccion = productosTransaccion;}
}
