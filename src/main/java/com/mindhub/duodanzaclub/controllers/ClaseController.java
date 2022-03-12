package com.mindhub.duodanzaclub.controllers;

import com.mindhub.duodanzaclub.dtos.ClaseDTO;
import com.mindhub.duodanzaclub.models.Academia;
import com.mindhub.duodanzaclub.models.Clase;
import com.mindhub.duodanzaclub.models.PrecioClase;
import com.mindhub.duodanzaclub.models.Usuario;
import com.mindhub.duodanzaclub.repositories.AcademiaRepository;
import com.mindhub.duodanzaclub.repositories.ClaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ClaseController {

    @Autowired
    ClaseRepository claseRepository;

    @Autowired
    AcademiaRepository academiaRepository;



    @GetMapping("/clases")
    public List<ClaseDTO> getClases(){
        List<ClaseDTO> clases = claseRepository.findAll().stream().map(ClaseDTO::new).collect(Collectors.toList());
        return clases;
    }



    @GetMapping("/clases/{id}")
    public ClaseDTO getClase(@PathVariable Long id){
        Clase clase = claseRepository.findById(id).orElse(null);
        ClaseDTO claseDTO = new ClaseDTO(clase);
        return claseDTO;
    }

    @PatchMapping("clases/{id}")
    public ResponseEntity<Object> cambiarPrecio(@PathVariable Long id,
                               @PathVariable List<Double> horarios){
        Clase clase = claseRepository.findById(id).orElse(null);


        if(clase == null) {
            return new ResponseEntity<>("La clase no existe", HttpStatus.FORBIDDEN);
        }

        else {
            clase.setHorarios(horarios);


            return  new ResponseEntity<>("Clase creada", HttpStatus.CREATED);
        }
    }

    @PostMapping("/clases")
    public ResponseEntity<Object> crearClase(@RequestBody ClaseDTO clase){


        Academia academia = academiaRepository.findById(clase.getAcademiaId()).orElse(null);

        if(clase.getNombre().isEmpty() || clase.getEstilo() == null || clase.getHorarios().isEmpty() ){
            return new ResponseEntity<>("Complete todos los campos", HttpStatus.FORBIDDEN);
        }

        if(academia == null) {
            return new ResponseEntity<>("La academia no existe", HttpStatus.FORBIDDEN);
        }

        else {
            Clase claseNueva = new Clase(clase.getNombre(), clase.getEstilo(), clase.getHorarios(), clase.getPrecioClase(), academia);
            claseRepository.save(claseNueva);

            return  new ResponseEntity<>("Clase creada", HttpStatus.CREATED);
        }
    }

}
