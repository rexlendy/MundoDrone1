package sena.mundodrone.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sena.mundodrone.app.model.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity,Integer> {
}
