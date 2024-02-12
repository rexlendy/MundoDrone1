package sena.mundodrone.app.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sena.mundodrone.app.model.LoginEntity;
import sena.mundodrone.app.repository.LoginRepository;
import sena.mundodrone.app.repository.UsuarioRepository;

import java.util.List;
@Service
public class LoginService implements ILoginService{
    @Autowired
    private LoginRepository loginRepository;
    @Override
    public List<LoginEntity> getAllLogins() {
        return loginRepository.findAll();
    }
    @Override
    public LoginEntity findById(Integer idLogin) {
        return loginRepository.findById(idLogin).orElse(null);
    }
    @Override
    public void saveLogin(LoginEntity loginEntity) {
        loginRepository.save(loginEntity);
    }
    @Override
    public void deleteLogin(LoginEntity loginEntity) {
        loginRepository.delete(loginEntity);
    }
}
