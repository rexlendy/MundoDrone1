package sena.mundodrone.app.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sena.mundodrone.app.model.ProveedorEntity;
import sena.mundodrone.app.repository.ProveedorRepository;
import java.util.List;
@Service
public class ProveedorService implements IProveedorService{
    @Autowired
    private ProveedorRepository proveedorRepository;
    @Override
    public List<ProveedorEntity> getAllProveedor() {
        return proveedorRepository.findAll();
    }
    @Override
    public ProveedorEntity findById(Integer idProveedor) {
        return proveedorRepository.findById(idProveedor).orElse(null);
    }
    @Override
    public void saveProveedor(ProveedorEntity proveedorEntity) {
                proveedorRepository.save(proveedorEntity);
    }
    @Override
    public void deleteProveedor(ProveedorEntity proveedorEntity) {
            proveedorRepository.delete(proveedorEntity);
    }
}
