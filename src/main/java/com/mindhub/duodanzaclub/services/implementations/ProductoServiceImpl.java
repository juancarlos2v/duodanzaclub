package com.mindhub.duodanzaclub.services.implementations;

import com.mindhub.duodanzaclub.dtos.ProductoDTO;
import com.mindhub.duodanzaclub.models.Productos;
import com.mindhub.duodanzaclub.repositories.ProductoRepository;
import com.mindhub.duodanzaclub.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    @Override
    public List<ProductoDTO> getProductsDTO() {
        return productoRepository.findAll().stream().map(ProductoDTO::new).collect(Collectors.toList());
    }

    @Override
    public Productos productoById(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public void guardarProducto(Productos producto) {
        productoRepository.save(producto);
    }
}
