package com.mindhub.duodanzaclub.dtos;

import com.mindhub.duodanzaclub.models.TransaccionProducto;

public class TransaccionProductoDTO {
    private long id;
    private ProductoDTO productoDTO;

    public TransaccionProductoDTO(){}
    public TransaccionProductoDTO(TransaccionProducto transaccionProducto){
        setId(transaccionProducto.getId());
        setProductoDTO(new ProductoDTO(transaccionProducto.getProducto()));
    }

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public ProductoDTO getProductoDTO() {return productoDTO;}

    public void setProductoDTO(ProductoDTO productoDTO) {this.productoDTO = productoDTO;}
}
