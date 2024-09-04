package co.edu.unisabana.demo.bd.orm;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "estudiante")
@Entity
//Lombo es una libreria de java que te ahorra Codigo
@Data
@NoArgsConstructor
public class EstudianteORM {

    //CREAR MAS INDICES VA HACER LAS CONSULTAS MAS RAPIDAS, SE HACEN INDECES CON RELACION A LAS COLUMNAS CON LAS QUE ESTA FILTRANDO
    //a mayor cantidad de indices las inserciones se hacen mas lentas
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column
    private String carrera;

    public EstudianteORM(String nombre, String carrera) {
        this.nombre = nombre;
        this.carrera = carrera;
    }

}
