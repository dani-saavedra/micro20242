package co.edu.unisabana.demo.integration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;

//Levantar la aplicacion en puerto super X
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//Este senor es el que levanta el contexto
public class MiPrimeraPruebaDeIntegration {

    @Autowired
    private TestRestTemplate testRestTemplate;


    @Test
    void CAMBIARNOMBREDELAPRUEBADEINTEGRACION() {
        ResponseEntity<List> resultado = testRestTemplate.getForEntity("/canciones?titulo=EstrillitaDondeEstas", List.class);
        Assertions.assertFalse(Objects.requireNonNull(resultado.getBody()).isEmpty());
        Assertions.assertTrue(resultado.getStatusCode().is2xxSuccessful());
    }
    //Condiciones que debe una cumplir una prueba de integracion
    //DEBE LEVANTAR EL CONTEXTO
    //Debe hacer la peticion a través del Protocolo que este exponiendo (Http/Rest)

    //Debe hacer el llamado a la base de datos
    //En muchos casos, se usa una base de datos embebida y no trabaja con la base de datos real
    //si usa la real, estaría bien, pero es mejor la simulada (se crea y se destruye)

}
