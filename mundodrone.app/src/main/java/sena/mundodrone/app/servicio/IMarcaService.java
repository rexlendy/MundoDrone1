package sena.mundodrone.app.servicio;
import sena.mundodrone.app.model.MarcaEntity;
import java.util.List;

public interface IMarcaService {
    public List<MarcaEntity> getAllMarca();
    public MarcaEntity findById(Integer idMarca);
    public void saveMarca(MarcaEntity marcaEntity);
    public void deleteMarca(MarcaEntity marcaEntity);
}
