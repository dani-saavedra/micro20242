package co.edu.unisabana.demo.controller;

import co.edu.unisabana.demo.bd.orm.CancionORM;
import co.edu.unisabana.demo.controller.dto.CancionDTO;
import co.edu.unisabana.demo.logica.CancionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
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

    @GetMapping(path = "/canciones")
    public List<CancionORM> guardarCancion(@RequestParam String titulo) {
        System.out.println("este es un log malo");
        log.info("Esto es un log bueno");
        return cancionService.consultarCancion(titulo);
    }
}
