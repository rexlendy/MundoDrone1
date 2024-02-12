package sena.mundodrone.app.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sena.mundodrone.app.model.UsuarioEntity;
import sena.mundodrone.app.repository.UsuarioRepository;

import java.util.List;
@Service
public class UsuarioService implements IUsuarioService{
@Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public List<UsuarioEntity> getAllUsuario() {
        return usuarioRepository.findAll();
    }
    @Override
    public UsuarioEntity findById(Integer idUsuario) {
        return usuarioRepository.findById(idUsuario).orElse(null);
    }
    @Override
    public void saveUsuario(UsuarioEntity usuarioEntity) {
        usuarioRepository.save(usuarioEntity);
    }
    @Override
    public void deleteUsuario(UsuarioEntity usuarioEntity) {
        usuarioRepository.delete(usuarioEntity);
    }
}
