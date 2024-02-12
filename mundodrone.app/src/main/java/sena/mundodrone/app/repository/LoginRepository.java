package sena.mundodrone.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sena.mundodrone.app.model.LoginEntity;
public interface LoginRepository extends JpaRepository<LoginEntity,Integer> {

}

