package co.edu.unisabana.demo.bd.jpa;

import co.edu.unisabana.demo.bd.orm.EstudianteORM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteJPA extends JpaRepository<EstudianteORM, Long> {
}
