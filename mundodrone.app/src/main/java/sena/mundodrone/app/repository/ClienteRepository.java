package sena.mundodrone.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sena.mundodrone.app.model.ClienteEntity;

public interface ClienteRepository extends JpaRepository<ClienteEntity,Integer> {
}
