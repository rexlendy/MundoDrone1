package sena.mundodrone.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sena.mundodrone.app.model.CompraEntity;

public interface CompraRepository extends JpaRepository<CompraEntity,Integer> {
}
