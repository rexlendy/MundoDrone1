package sena.mundodrone.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sena.mundodrone.app.model.CategoriaEntity;
import sena.mundodrone.app.model.VentaEntity;

import java.time.LocalDate;
import java.util.List;

public interface VentaRepository extends JpaRepository<VentaEntity,Integer> {
    List<VentaEntity> findByFechaVenta(LocalDate fechaVenta);

    List<VentaEntity> findByFechaVentaBetween(LocalDate inicio, LocalDate fin);
}
