package sena.mundodrone.app.servicio;
import sena.mundodrone.app.model.LoginEntity;
import java.util.List;

public interface ILoginService {
    public List<LoginEntity> getAllLogins();
    public LoginEntity findById(Integer idLogin);
    public void saveLogin(LoginEntity loginEntity);
    public void deleteLogin(LoginEntity loginEntity);
    boolean autenticar(String nombreUsuario, String contrasena);
}
