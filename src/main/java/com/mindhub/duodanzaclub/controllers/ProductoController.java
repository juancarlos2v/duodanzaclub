package com.mindhub.duodanzaclub.controllers;


import com.mindhub.duodanzaclub.dtos.ProductoDTO;
import com.mindhub.duodanzaclub.models.Estilos;
import com.mindhub.duodanzaclub.models.Productos;
import com.mindhub.duodanzaclub.models.TipoProducto;
import com.mindhub.duodanzaclub.models.Usuario;
import com.mindhub.duodanzaclub.repositories.ProductoRepository;
import com.mindhub.duodanzaclub.repositories.UsuarioRepository;
import com.mindhub.duodanzaclub.services.ProductoService;
import com.mindhub.duodanzaclub.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ProductoController {

    @Autowired
    ProductoService productoService;
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/productos")
    public List<ProductoDTO> getProductos(){
        List<ProductoDTO> productoDTOS = productoService.getProductsDTO();
        return productoDTOS;
    }

    @GetMapping("/productos/{id}")
    public ProductoDTO getProducto(@PathVariable Long id){
        Productos producto = productoService.productoById(id);
        ProductoDTO productoDTO = new ProductoDTO(producto);
        return productoDTO;
    }

    @PatchMapping("/productos/{id}")
    public ResponseEntity<Object> actualizarPrecio(@PathVariable Long id,
                                                   @RequestParam Double precio){
        Productos producto = productoService.productoById(id);

        if(producto == null) {
            return new ResponseEntity<>("El producto seleccionado no existe", HttpStatus.FORBIDDEN);
        }
        if(producto.getPrecio() <= 0) {
            return new ResponseEntity<>("Agregue un precio", HttpStatus.FORBIDDEN);
        }

        producto.setPrecio(precio);
        productoService.guardarProducto(producto);
        return new ResponseEntity<>("Precio actualizado", HttpStatus.CREATED);
    }

    @PostMapping("/productos")
    public ResponseEntity<Object> crearProducto(Authentication authentication,
                                                @RequestBody Productos producto){

        if(producto.getTitulo().isEmpty() || producto.getDescripcion().isEmpty() || producto.getPrecio() == null || producto.getImagen().isEmpty() || producto.getEstilo() == null || producto.getTipoProducto() == null || producto.getStock() <= 0){
            return new ResponseEntity<>("Complete todos los campos", HttpStatus.FORBIDDEN);
        }
        if(producto.getPrecio() <= 0) {
            return new ResponseEntity<>("Agregue un precio", HttpStatus.FORBIDDEN);
        }

        Productos productoNuevo = new Productos(producto.getTitulo(), producto.getDescripcion(), producto.getPrecio(), producto.getImagen(), producto.getEstilo(), producto.getTipoProducto(), producto.getStock());
        productoService.guardarProducto(productoNuevo);

        return new ResponseEntity<>("Producto creado", HttpStatus.FORBIDDEN);
    }
}
