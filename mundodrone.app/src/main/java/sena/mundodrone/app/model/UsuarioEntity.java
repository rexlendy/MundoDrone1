package sena.mundodrone.app.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;
    private String nombre;
    private String apellido;
    private String telefono;
    private String ciudad;
    private String email;
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;
    public enum TipoUsuario {
        vendedor,
        administrador
    }
}
