package co.edu.unisabana.demo.bd.jpa;

import co.edu.unisabana.demo.bd.orm.CancionORM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository//pendiente de explicar
public interface CancionJPA extends JpaRepository<CancionORM, Long> {

}
