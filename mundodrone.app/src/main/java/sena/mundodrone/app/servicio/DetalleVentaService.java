package sena.mundodrone.app.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sena.mundodrone.app.model.DetalleVentaEntity;
import sena.mundodrone.app.repository.DetalleVentaRepository;

import java.util.List;
@Service
public class DetalleVentaService implements IDetalleVentaService{
    @Autowired
    private DetalleVentaRepository detalleVentaRepository;
    @Override
    public List<DetalleVentaEntity> getAllCDetalleVenta() {
        return detalleVentaRepository.findAll();
    }
    @Override
    public DetalleVentaEntity findById(Integer idDetalleVenta) {
        return detalleVentaRepository.findById(idDetalleVenta).orElse(null);
    }
    @Override
    public void saveDetalleVenta(DetalleVentaEntity detalleVentaEntity) {
                detalleVentaRepository.save(detalleVentaEntity);
    }
    @Override
    public void deleteDetalleVenta(DetalleVentaEntity detalleVentaEntity) {
                detalleVentaRepository.delete(detalleVentaEntity);
    }
}
