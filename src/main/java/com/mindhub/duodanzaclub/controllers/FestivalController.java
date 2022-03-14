package com.mindhub.duodanzaclub.controllers;

import com.mindhub.duodanzaclub.dtos.FestivalDTO;
import com.mindhub.duodanzaclub.models.Festival;
import com.mindhub.duodanzaclub.repositories.FestivalRepository;
import com.mindhub.duodanzaclub.services.FestivalService;
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
    FestivalService festivalService;



    @GetMapping("/festivales")
    public List<FestivalDTO> getFestivales(){
        List<FestivalDTO> festivalesDTO = festivalService.traerFestivales();

        return festivalesDTO;
    }


    @GetMapping("/festivales/{id}")
    public FestivalDTO getFestivales(@PathVariable Long id){
        FestivalDTO festivalDTO = new FestivalDTO(festivalService.traerFestival(id));

        return festivalDTO;
    }




    @PostMapping("/festivales")
    public ResponseEntity<Object> crearFestival(@RequestBody Festival festival){

        if(festival.getNombre() == null || festival.getPrecio() == null || festival.getHorarios().isEmpty() || festival.getEstilo() == null){
            return new ResponseEntity<>("Complete los campos", HttpStatus.FORBIDDEN);
        }


            Festival festivalNuevo = new Festival(festival.getNombre(), festival.getEstilo(), festival.getPrecio(), festival.getHorarios());
            festivalService.guardarFestival(festivalNuevo);
            return new ResponseEntity<>("Festival creado", HttpStatus.CREATED);

    }

}
