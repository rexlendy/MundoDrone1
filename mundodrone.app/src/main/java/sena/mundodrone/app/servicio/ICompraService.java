package sena.mundodrone.app.servicio;
import sena.mundodrone.app.model.CompraEntity;
import java.util.List;
public interface ICompraService {
    public List<CompraEntity> getAllCompra();
    public CompraEntity findById(Integer idCompra);
    public void saveCompra(CompraEntity compraEntity);
    public void deleteCompra(CompraEntity compraEntity);
}
