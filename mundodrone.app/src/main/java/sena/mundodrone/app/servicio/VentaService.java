package sena.mundodrone.app.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sena.mundodrone.app.model.VentaEntity;
import sena.mundodrone.app.repository.VentaRepository;

import java.util.List;
@Service
public class VentaService implements IVentaService{
    @Autowired
    private VentaRepository ventaRepository;
    @Override
    public List<VentaEntity> getAllVenta() {
        return ventaRepository.findAll();
    }
    @Override
    public VentaEntity findById(Integer idVenta) {
        return ventaRepository.findById(idVenta).orElse(null);
    }
    @Override
    public void saveVenta(VentaEntity ventaEntity) {
                ventaRepository.save(ventaEntity);
    }
    @Override
    public void deleteVenta(VentaEntity ventaEntity) {
                ventaRepository.delete(ventaEntity);
    }
}
