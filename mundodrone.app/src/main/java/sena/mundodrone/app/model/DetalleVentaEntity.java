package sena.mundodrone.app.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
@Entity
@Table(name = "detalleventa")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleVentaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalleVenta;
    @ManyToOne
    @JoinColumn(name = "idVenta")
    private VentaEntity Venta;
    @ManyToOne
    @JoinColumn(name = "IdProducto")
    private ProductoEntity producto;
}
