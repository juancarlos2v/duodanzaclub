package com.mindhub.duodanzaclub.controllers;

import com.mindhub.duodanzaclub.models.Productos;
import com.mindhub.duodanzaclub.models.Usuario;
import com.mindhub.duodanzaclub.repositories.ProductoRepository;
import com.mindhub.duodanzaclub.services.ProductoService;
import com.mindhub.duodanzaclub.services.UsuarioService;
import com.mindhub.duodanzaclub.services.implementations.PdfServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping("/api")
public class PdfCompraController {

    @Autowired
    PdfServiceImpl pdfService;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    ProductoService productoService;

    @Autowired
    ProductoRepository productoRepository;

    @GetMapping("/pdf/generate")
    public void generatePDF(HttpServletResponse response, Authentication authentication, @RequestParam List<Long> productos_id) throws IOException {

        Usuario currentClient = usuarioService.findUsuarioByEmail(authentication.getName());
        List<Productos> productos = productoRepository.findAllById(productos_id);

        response.setContentType("application/pdf");

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=compra_"+currentClient.getNombre()+"_"+currentClient.getApellido()+".pdf";
        response.setHeader(headerKey,headerValue);

        pdfService.export(response,productos,currentClient);

    }
}
