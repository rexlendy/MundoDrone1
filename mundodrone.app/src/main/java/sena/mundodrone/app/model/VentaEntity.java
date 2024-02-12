package sena.mundodrone.app.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "venta")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVenta;
    private Date fechaVenta;
    @Column(precision = 10, scale = 2)
    private BigDecimal subtotalFactura;
    @Column(precision = 10, scale = 2)
    private BigDecimal totalIvaFactura;
    @Column(precision = 10, scale = 2)
    private BigDecimal montoRecibido;
    @Column(precision = 10, scale = 2)
    private BigDecimal cambio;
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private UsuarioEntity idUsuario;
    @ManyToOne
    @JoinColumn(name = "idCliente")
    private ClienteEntity idCliente;
}
