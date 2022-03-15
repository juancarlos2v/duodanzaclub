package com.mindhub.duodanzaclub.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private double amount;
    private LocalDateTime date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "transaccion", fetch = FetchType.EAGER)
    private List<TransaccionProducto> transaccionProductos = new ArrayList<>();

    public Transaccion(){}
    public Transaccion(double amount, LocalDateTime date, Usuario usuario){
        setAmount(amount);
        setDate(date);
        setUsuario(usuario);
    }

    public long getId() {return id;}

    public double getAmount() {return amount;}

    public void setAmount(double amount) {this.amount = amount;}

    public LocalDateTime getDate() {return date;}

    public void setDate(LocalDateTime date) {this.date = date;}

    public Usuario getUsuario() {return usuario;}

    public void setUsuario(Usuario usuario) {this.usuario = usuario;}

    public List<TransaccionProducto> getTransaccionProductos() {return transaccionProductos;}

    public void setTransaccionProductos(List<TransaccionProducto> transaccionProductos) {this.transaccionProductos = transaccionProductos;}
}
