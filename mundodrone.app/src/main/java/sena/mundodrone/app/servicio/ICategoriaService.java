package sena.mundodrone.app.servicio;
import sena.mundodrone.app.model.CategoriaEntity;
import java.util.List;
public interface ICategoriaService {
    public List<CategoriaEntity> getAllLogins();
    public CategoriaEntity findById(Integer idCategoria);
    public void save(CategoriaEntity categoriaEntity);
    public void delete(CategoriaEntity categoriaEntity);
}
