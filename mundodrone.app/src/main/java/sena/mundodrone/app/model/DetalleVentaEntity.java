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
    private Integer cantidad;
    @Column(precision = 10, scale = 2)
    private BigDecimal precioUnitario;
    @Column(precision = 10, scale = 2)
    private  BigDecimal descuento;
    @ManyToOne
    @JoinColumn(name = "idVenta")
    private VentaEntity idVenta;
    @ManyToOne
    @JoinColumn(name = "idProducto")
    private ProductoEntity idUsuario;
}
