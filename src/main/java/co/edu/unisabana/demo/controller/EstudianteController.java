package co.edu.unisabana.demo.controller;

import co.edu.unisabana.demo.bd.jpa.EstudianteJPA;
import co.edu.unisabana.demo.bd.orm.EstudianteORM;
import co.edu.unisabana.demo.controller.dto.EstudianteDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//Estilo arquitectonico
//Tesis doctoral, 2001
//Soap, MUY COMPLEJO DE ENTENDER
//rest facilito la comunicacion
@RestController
@AllArgsConstructor
public class EstudianteController {

    private EstudianteJPA estudianteJPA;


    //API: Contrato: Como nos vamos a comunicar
    //Que vamos a enviar
    //Que vamos a recibir
    //Formato
    //A donde se va hacer la petición
    List<EstudianteDTO> estudiantes = new ArrayList<>();


    //Endpoint: Un lugar donde donde llega la petición
    @GetMapping(path = "/saludo")
    public String saludar() {
        return "Hola mundo";
    }

    //Hay dos maneras:
    //1.  Query param: Filtrar, Ordenar, paginar
    //2. Path variable: Obtener un recurso en especifico

    @GetMapping(path = "/estudiantes")
    public List<EstudianteDTO> obtenerEstudiantes(@RequestParam String carrera, @RequestParam String genero) {
        return estudiantes
                .stream()
                .filter(estudianteDTO -> estudianteDTO.carrera().equals(carrera) && estudianteDTO.genero().equals(genero))
                .toList();

    }

    @GetMapping(path = "/estudiantes/todos")
    public List<EstudianteDTO> obtenerEstudiantes() {
        return estudiantes;

    }

    @GetMapping(path = "/estudiantes/{codigo}")
    public EstudianteDTO obtenerEstudiante(@PathVariable String codigo) {
        for (EstudianteDTO estudiante : estudiantes) {
            if (estudiante.codigo().equals(codigo)) {
                return estudiante;
            }
        }
        return null;
    }

    //4 Metodos principales: CRUD
    //GET Read, POST Create, PUT Update, DELETE Delete


    @PostMapping(path = "/estudiante")
    public String guardarEstudiante(@RequestBody EstudianteDTO estudiante) {
        estudiantes.add(estudiante);
        estudianteJPA.save(new EstudianteORM(estudiante.nombre(), estudiante.carrera()));
        return "Estudiante guardado";
    }

    @GetMapping(path = "/estudiantes-bd")
    public List<EstudianteORM> obtenerEstudiantesBD() {
        return estudianteJPA.findAll();
    }

    @DeleteMapping(path = "/estudiant/{codigo}")
    public String eliminarEstudiante(@PathVariable Long codigo) {
        estudianteJPA.deleteById(codigo);
        return "Estudiante eliminado";
    }


    //ORM Object Relational Mapping
    //Una estrategia para trabajar la base de datos como si fuera objetos de Java
    //Las tablas en su base de datos, se van a convertir en clases de Java


}
