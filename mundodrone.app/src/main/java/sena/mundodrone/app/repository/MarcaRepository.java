package sena.mundodrone.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sena.mundodrone.app.model.MarcaEntity;

public interface MarcaRepository extends JpaRepository<MarcaEntity,Integer> {
}
