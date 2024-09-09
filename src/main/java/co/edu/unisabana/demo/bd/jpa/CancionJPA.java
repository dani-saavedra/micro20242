package co.edu.unisabana.demo.bd.jpa;

import co.edu.unisabana.demo.bd.orm.CancionORM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CancionJPA extends JpaRepository<CancionORM, Long> {

    List<CancionORM> findByTitulo(String nombre);

    @Query(nativeQuery = true,value = "select bla bla bla")
    List<CancionORM> findByDuracionBetween();
}
