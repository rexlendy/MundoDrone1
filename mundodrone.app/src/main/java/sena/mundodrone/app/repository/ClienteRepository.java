package sena.mundodrone.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sena.mundodrone.app.model.ClienteEntity;

import java.time.LocalDate;
import java.util.List;

public interface ClienteRepository extends JpaRepository<ClienteEntity,Integer> {

    List<ClienteEntity> findByTipoCliente(ClienteEntity.TipoCliente tipoCliente);

    @Query("SELECT c FROM ClienteEntity c WHERE c.tipoCliente = ?1 AND (c.nombre LIKE %?2% OR c.apellido LIKE %?2% OR c.cedula LIKE %?2%)")
    List<ClienteEntity> buscarClientes(ClienteEntity.TipoCliente tipoCliente, String valorBusqueda);
    List<ClienteEntity> findByFechaCreacion(LocalDate fechaCreacion);
}
