package sena.mundodrone.app.servicio;
import sena.mundodrone.app.model.DetalleVentaEntity;
import java.util.List;

public interface IDetalleVentaService {
    public List<DetalleVentaEntity> getAllCDetalleVenta();
    public DetalleVentaEntity findById(Integer idDetalleVenta);
    public void saveDetalleVenta(DetalleVentaEntity detalleVentaEntity);
    public void deleteDetalleVenta(DetalleVentaEntity detalleVentaEntity);
}
