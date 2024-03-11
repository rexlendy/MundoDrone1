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
    private BigDecimal precio_Venta;
    private Boolean tiene_iva;
    private String color;
    private Integer stock;
    public static final BigDecimal IVA = BigDecimal.valueOf(0.19) ;
    @ManyToOne
    @JoinColumn(name = "idMarca")
    private MarcaEntity idMarca;
    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private CategoriaEntity categoria;

}
