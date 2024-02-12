package sena.mundodrone.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sena.mundodrone.app.model.VentaEntity;

public interface VentaRepository extends JpaRepository<VentaEntity,Integer> {
}
