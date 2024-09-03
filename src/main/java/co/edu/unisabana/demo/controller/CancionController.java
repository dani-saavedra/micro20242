package co.edu.unisabana.demo.controller;

import co.edu.unisabana.demo.bd.orm.CancionORM;
import co.edu.unisabana.demo.bd.jpa.CancionJPA;
import co.edu.unisabana.demo.controller.dto.CancionDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import co.edu.unisabana.demo.logica.CancionService;

import java.time.LocalDate;

@RestController
@AllArgsConstructor
public class CancionController {

    //Inversion de control, Framework, mmmmm veo que tu necesitas esta variable CancionJPA, voy a inyectartela.
    //Es el framework que viene y pasa la instancia

    private CancionService cancionService;

    //mmm Veo que juanes esta neceistando esta instancia (cancionJPA)... VOY A INYECTARLA el framework.


    @PostMapping(path = "/cancion")
    public String guardarCancion(@RequestBody CancionDTO cancionDTO) {
        cancionService.guardarCancion(cancionDTO.genero(), cancionDTO.duracion(), cancionDTO.titulo());
        return "Cancion guardada";
    }

}
