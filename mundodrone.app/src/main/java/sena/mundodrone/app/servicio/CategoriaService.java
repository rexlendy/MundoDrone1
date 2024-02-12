package sena.mundodrone.app.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sena.mundodrone.app.model.CategoriaEntity;
import sena.mundodrone.app.repository.CategoriaRepository;
import java.util.List;
@Service
public class CategoriaService implements ICategoriaService{
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Override
    public List<CategoriaEntity> getAllLogins() {
        return categoriaRepository.findAll();
    }
    @Override
    public CategoriaEntity findById(Integer idCategoria) {
        return categoriaRepository.findById(idCategoria).orElse(null);
    }
    @Override
    public void save(CategoriaEntity categoriaEntity) {
        categoriaRepository.save(categoriaEntity);
    }
    @Override
    public void delete(CategoriaEntity categoriaEntity) {
        categoriaRepository.delete(categoriaEntity);
    }
}
