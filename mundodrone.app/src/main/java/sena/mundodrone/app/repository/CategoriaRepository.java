package sena.mundodrone.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sena.mundodrone.app.model.CategoriaEntity;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity,Integer> {
}
