package com.mindhub.duodanzaclub.services;


import com.mindhub.duodanzaclub.dtos.ProductoDTO;
import com.mindhub.duodanzaclub.models.Productos;
import com.mindhub.duodanzaclub.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;


public interface ProductoService {


    public List<ProductoDTO> getProductsDTO();

    public Productos productoById(@PathVariable Long id);

    public void guardarProducto(Productos producto);
}
