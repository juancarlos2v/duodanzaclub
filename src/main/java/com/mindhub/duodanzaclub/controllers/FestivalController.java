package com.mindhub.duodanzaclub.controllers;

import com.mindhub.duodanzaclub.dtos.FestivalDTO;
import com.mindhub.duodanzaclub.models.Festival;
import com.mindhub.duodanzaclub.repositories.FestivalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class FestivalController {

    @Autowired
    FestivalRepository festivalRepository;




    @GetMapping("/festivales")
    public List<FestivalDTO> getFestivales(){
        List<Festival> festivales = festivalRepository.findAll();
        List<FestivalDTO> festivalesDTO = festivales.stream().map(FestivalDTO::new).collect(Collectors.toList());

        return festivalesDTO;
    }


    @GetMapping("/festivales/{id}")
    public FestivalDTO getFestivales(@PathVariable Long id){
        Festival festival = festivalRepository.findById(id).orElse(null);
        FestivalDTO festivalDTO = new FestivalDTO(festival);

        return festivalDTO;
    }




    @PostMapping("/festivales")
    public ResponseEntity<Object> crearFestival(@RequestBody Festival festival){

        if(festival.getNombre() == null || festival.getPrecio() == null || festival.getHorarios().isEmpty() || festival.getEstilo() == null){
            return new ResponseEntity<>("Complete los campos", HttpStatus.FORBIDDEN);
        }

        else {
            Festival festivalNuevo = new Festival(festival.getNombre(), festival.getEstilo(), festival.getPrecio(), festival.getHorarios());
            festivalRepository.save(festivalNuevo);
            return new ResponseEntity<>("Festival creado", HttpStatus.CREATED);
        }
    }

}
