package sena.mundodrone.app.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sena.mundodrone.app.model.ClienteEntity;
import sena.mundodrone.app.repository.ClienteRepository;
import java.util.List;
@Service
public class ClienteService implements IClienteService{
    @Autowired
    private ClienteRepository clienteRepository;
    @Override
    public List<ClienteEntity> getAllCliente() {
        return clienteRepository.findAll();
    }
    @Override
    public ClienteEntity findById(Integer idCliente) {
        return clienteRepository.findById(idCliente).orElse(null);
    }
    @Override
    public void saveCliente(ClienteEntity clienteEntity) {
                clienteRepository.save(clienteEntity);
    }
    @Override
    public void deleteCliente(ClienteEntity clienteEntity) {
                clienteRepository.delete(clienteEntity);
    }
}
