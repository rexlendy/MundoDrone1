package sena.mundodrone.app.servicio;
import sena.mundodrone.app.model.VentaEntity;
import java.util.List;

public interface IVentaService {
    public List<VentaEntity> getAllVenta();
    public VentaEntity findById(Integer idVenta);
    public void saveVenta(VentaEntity ventaEntity);
    public void deleteVenta(VentaEntity ventaEntity);
}
