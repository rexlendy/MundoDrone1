package sena.mundodrone.app.servicio;
import sena.mundodrone.app.model.ProveedorEntity;
import java.util.List;

public interface IProveedorService {
    public List<ProveedorEntity> getAllProveedor();
    public ProveedorEntity findById(Integer idProveedor);
    public void saveProveedor(ProveedorEntity proveedorEntity);
    public void deleteProveedor(ProveedorEntity proveedorEntity);
}
