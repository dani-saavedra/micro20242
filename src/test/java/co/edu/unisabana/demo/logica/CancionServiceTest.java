package co.edu.unisabana.demo.logica;

import co.edu.unisabana.demo.bd.jpa.CancionJPA;
import co.edu.unisabana.demo.bd.orm.CancionORM;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

//El alcance de una prueba unitaria, es la clase, no las dependencias que tenga esta clase.
//Para trabajar con las dependencias, se utilizan Mocks
@ExtendWith(MockitoExtension.class)
class CancionServiceTest {


    //ESTAN LOS MOCKS Y A QUIEN SE LE INYECTAN LOS MOCKS
    @Mock
    CancionJPA cancionJPA;

    @InjectMocks
    CancionService service;

    //La cantidad de test MINIMO que va a tener un metodo esta directamente relacionado
    //Con la complejidad ciclomatica

    // Cuando corremos un test saldra tres tipos de colores:
    // 1. Verde: TODO QUEDO BIEN
    // 2. Amarillo: Algo no se cumplio
    // 3. Rojo: algo exploto, se fue de madres.
    @Test
    void Given_generoInvalido_When_guardarCancion_Then_throwArithmeticException() {
        //un test se compone de tres partes:
        // (AAA) Arrange, Act, Assertion
        //1. Preparacion de la data
        //2. Ejecucción del método
        //3. Validar los resultados (comparar)
        Assertions.assertThrows(ArithmeticException.class,
                () -> service.guardarCancion("Baladas", 1, "Soledad")
        );

    }

    //Los test los vamos a llamar de esta manera
    //The given part describes the state of the world before you begin
    // the behavior you're specifying in this scenario.
    // You can think of it as the pre-conditions to the test.
    //The when section is that behavior that you're specifying.
    //Finally the then section describes the changes you expect
    // due to the specified behavior.
    @Test
    void Given_duracionInvalida_When_guardarCancion_Then_throwIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> service.guardarCancion("Rock", 50, "Soledad")
        );
    }

    @Test
    void Given_duracionInvalida2_When_guardarCancion_Then_throwIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> service.guardarCancion("Rock", 700, "Soledad")
        );
    }

    @Test
    void When_guardarCancion_Then_returnTrue() {
        boolean resultado = service.guardarCancion("Rock", 500, "Soledad");
        Assertions.assertTrue(resultado);
        Mockito.verify(cancionJPA).save(Mockito.any());
    }

    //@Test
    void GivenNoExisteElTitulo_WhenConsulteCancion_Then_returnException() {
        String cancion = "Living on prayer";
        Mockito.when(cancionJPA.findByTitulo(cancion)).thenReturn(new ArrayList<>());
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.consultarCancion(cancion);
        });
    }

    @Test
    void GiveExisteElTitulo_WhenConsulteCancion_Then_returLista() {
        //AAA =
        // Inicia Preracion
        ArrayList<CancionORM> cancionesSimuladas = new ArrayList<>();
        cancionesSimuladas.add(new CancionORM());
        String cancion = "Permitame";
        Mockito.when(cancionJPA.findByTitulo(cancion)).thenReturn(cancionesSimuladas);
        //Finaliza Arrange

        //Inicia ejecuccion
        List<CancionORM> cancionesORMS = service.consultarCancion(cancion);
        //Finaliza Act

        //Inicia Afirmacion
        Assertions.assertEquals(1, cancionesORMS.size());
        Assertions.assertFalse(cancionesORMS.isEmpty());
        Mockito.verify(cancionJPA).findByTitulo(cancion);
        //Finaliza Assertions
    }

    @Test
    void test1() {
        int resultado = service.sumar(10, 20);
        //SIN ASSERTIONS, LA PRUEBA NO ES NADA, ES BASURA
        Assertions.assertEquals(30, resultado);
    }
    //TDD (TEST DRIVEN DEVELOPMENT)
}