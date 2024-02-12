package sena.mundodrone.app.servicio;
import sena.mundodrone.app.model.UsuarioEntity;
import java.util.List;
public interface IUsuarioService {
    public List<UsuarioEntity> getAllUsuario();
    public UsuarioEntity findById(Integer idUsuario);
    public void saveUsuario(UsuarioEntity usuarioEntity);
    public void deleteUsuario(UsuarioEntity usuarioEntity);
}
