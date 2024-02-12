package sena.mundodrone.app.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "producto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;
    private String nombre;
    @Column(precision = 10, scale = 2)
    private BigDecimal precioCompra;
    @Column(precision = 10, scale = 2)
    private BigDecimal precioVenta;
    private Boolean iva;
    private BigDecimal porcentajeIva;
    private String color;
    private Integer stock;
    @ManyToOne
    @JoinColumn(name = "idMarca")
    private MarcaEntity idMarca;
    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private CategoriaEntity idCategoria;

}
