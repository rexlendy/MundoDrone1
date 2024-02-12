package sena.mundodrone.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sena.mundodrone.app.model.ProveedorEntity;

public interface ProveedorRepository extends JpaRepository<ProveedorEntity,Integer> {
}
