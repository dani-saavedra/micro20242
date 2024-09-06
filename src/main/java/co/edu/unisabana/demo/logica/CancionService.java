package co.edu.unisabana.demo.logica;

import co.edu.unisabana.demo.bd.jpa.CancionJPA;
import co.edu.unisabana.demo.bd.orm.CancionORM;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class CancionService {

    private final CancionJPA cancionJPA;

    public void componerCancion() {
        System.out.println("Estoy componiendo una canción");
    }

    //La logica de negocio, se escribe en los SERVICE!
    //Los controladores no tienen logica de negocio, y los controladores no acceden directamente a la BD.
    public boolean guardarCancion(String genero, int duracion, String titulo) {
        if ("Baladas".equals(genero)) {
            throw new ArithmeticException("no se permite guardar baladas");
        }
        if (duracion < 100 || duracion > 600) {
            throw new IllegalArgumentException("Cancion con duracion invalida");
        }
        CancionORM nuevaCancion = new CancionORM();
        nuevaCancion.setDuracion(duracion);
        nuevaCancion.setTitulo(titulo);
        nuevaCancion.setFechaLanzamiento(LocalDate.now());
        nuevaCancion.setGenero(genero);
        cancionJPA.save(nuevaCancion);
        return true;
    }

    public int sumar(int numero1, int numero2) {
        return numero1 + numero2;
    }

}
