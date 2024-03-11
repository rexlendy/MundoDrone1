package sena.mundodrone.app.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Venta")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVenta;
    private LocalDate fechaVenta;
    private int cantidad;
    private BigDecimal subtotalFactura = BigDecimal.ZERO;
    private BigDecimal totalIvaFactura = BigDecimal.ZERO;
    private BigDecimal totalVenta = BigDecimal.ZERO;
    // Relación uno a muchos con los detalles de la venta
    @OneToMany(mappedBy = "Venta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleVentaEntity> detallesventa = new ArrayList<>();

    public void agregarDetalleAVenta(DetalleVentaEntity detalleVenta) {
        if (detallesventa == null) {
            detallesventa = new ArrayList<>();
        }
        detallesventa.add(detalleVenta);
    }

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private UsuarioEntity idUsuario;
    @ManyToOne
    @JoinColumn(name = "idCliente")
    private ClienteEntity idCliente;

}
