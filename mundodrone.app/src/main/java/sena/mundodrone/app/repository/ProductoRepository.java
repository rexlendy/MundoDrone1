package sena.mundodrone.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sena.mundodrone.app.model.ProductoEntity;

public interface ProductoRepository extends JpaRepository<ProductoEntity,Integer> {
}
