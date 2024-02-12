package sena.mundodrone.app.servicio;
import sena.mundodrone.app.model.ClienteEntity;
import java.util.List;
public interface IClienteService {
    public List<ClienteEntity> getAllCliente();
    public ClienteEntity findById(Integer idCliente);
    public void saveCliente(ClienteEntity clienteEntity);
    public void deleteCliente(ClienteEntity clienteEntity);
}
