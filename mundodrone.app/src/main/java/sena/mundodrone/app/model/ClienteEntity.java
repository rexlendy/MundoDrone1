package sena.mundodrone.app.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Table(name = "cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;
    @Enumerated(EnumType.STRING)
    private TipoCliente tipoCliente;
    private String cedula;
    private String nombre;
    private String apellido;
    private String rut;
    @Column(name = "razon_social_juridica")
    private String razonSocialJuridica;
    private String direccion;
    private String telefono;
    private Date fechaCreacion;
    public enum TipoCliente{
        NATURAL,
        JURIDICO
    }
}
