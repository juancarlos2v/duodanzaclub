package com.mindhub.duodanzaclub.controllers;


import com.mindhub.duodanzaclub.dtos.TransaccionDTO;
import com.mindhub.duodanzaclub.models.Productos;
import com.mindhub.duodanzaclub.models.Transaccion;
import com.mindhub.duodanzaclub.models.TransaccionProducto;
import com.mindhub.duodanzaclub.models.Usuario;
import com.mindhub.duodanzaclub.repositories.TransaccionProductoRepository;
import com.mindhub.duodanzaclub.repositories.TransaccionRepository;
import com.mindhub.duodanzaclub.services.EmailService;
import com.mindhub.duodanzaclub.services.ProductoService;
import com.mindhub.duodanzaclub.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class TransaccionController {

    @Autowired
    TransaccionRepository transaccionRepository;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    ProductoService productoService;
    @Autowired
    TransaccionProductoRepository transaccionProductoRepository;
    @Autowired
    EmailService emailService;

    @GetMapping("/transacciones")
    public List<TransaccionDTO> getTransacciones(){
        return transaccionRepository.findAll().stream().map(TransaccionDTO::new).collect(Collectors.toList());
    }

    @Transactional
    @PostMapping("/comprar")
    public ResponseEntity<Object> nuevaTransaccion(Authentication authentication, @RequestBody TransaccionDTO transaccionDTO){
        Usuario usuario = usuarioService.findUsuarioByEmail(authentication.getName());
        List<Productos> productos = new ArrayList<>();

        if(transaccionDTO.getAmount() <= 0 || transaccionDTO.getProductosTransaccion().size() <= 0){
            return new ResponseEntity<>("No ha seleccionado ningún producto", HttpStatus.FORBIDDEN);
        }

        Transaccion transaccion = (new Transaccion(transaccionDTO.getAmount(), LocalDateTime.now(), usuario));
        transaccionRepository.save(transaccion);

        transaccionDTO.getProductosTransaccion().stream().forEach(productoTransaccion -> {
            Productos producto = productoService.productoById(productoTransaccion);
            productos.add(producto);
            producto.setStock(producto.getStock() - 1);
            productoService.guardarProducto(producto);
            TransaccionProducto transaccionProducto = transaccionProductoRepository.save(new TransaccionProducto(transaccion, producto));
        });

        emailService.sendEmail("ignaciomolina.95@hotmail.com", "Gracias por tu compra", "El contenido de tu compra es:");
        usuario.addTransaccion(transaccion);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
