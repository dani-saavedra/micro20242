package co.edu.unisabana.demo.bd.orm;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name = "cancion")
@Entity
@Data
@NoArgsConstructor
public class CancionORM {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String genero;
    @Column
    private Integer duracion;

    @Column
    private String titulo;
    //MENOS 2 EN EL TRABAJO
    @Column
    private LocalDate fechaLanzamiento;

}
