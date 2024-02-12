package sena.mundodrone.app.model;

import jakarta.persistence.*;
import lombok.*;

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
    private TipoCliente tipoUsuario;
    private String nombre;
    private String apellido;
    private String dni;
    private String rut;
    private String razonSocialJuridica;
    private String direccion;
    private String telefono;
    public enum TipoCliente{
        natural,
        juridico
    }
}
