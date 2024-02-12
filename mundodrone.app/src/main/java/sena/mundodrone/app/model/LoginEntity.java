package sena.mundodrone.app.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "login")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLogin;
    private String usuario;
    private String contraseña;
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private UsuarioEntity idUsuario;
}
