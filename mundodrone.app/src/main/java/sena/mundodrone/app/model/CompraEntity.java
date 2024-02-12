package sena.mundodrone.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "compra")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompraEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCompra;
    private Date fechaCompra;
    private Integer cantidad;
    @Column(precision = 10, scale = 2)
    private BigDecimal precioUnitario;
    @Column(precision = 10, scale = 2)
    private BigDecimal total;
    @ManyToOne
    @JoinColumn(name = "idProducto")
    private ProductoEntity idProducto;
    @ManyToOne
    @JoinColumn(name = "idProveedor")
    private ProveedorEntity idProveedor;
}
