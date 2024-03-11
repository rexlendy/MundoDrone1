package sena.mundodrone.app.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import sena.mundodrone.app.model.ClienteEntity;
import sena.mundodrone.app.model.VentaEntity;
import sena.mundodrone.app.repository.ClienteRepository;

import java.time.LocalDate;
import java.util.List;
@Service
public class ClienteService implements IClienteService{
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<ClienteEntity> listarClientes() {
        return null;
    }

    @Override
    public List<ClienteEntity> obtenerClientesDelDia(LocalDate fecha) {
        return clienteRepository.findByFechaCreacion(fecha);
    }

    @Override
    public ClienteEntity buscarClientePorId(Integer idCliente) {
        return null;
    }

    @Override
    public void guardarCliente(ClienteEntity cliente) {

    }

    @Override
    public void eliminarCliente(ClienteEntity cliente) {

    }

    @Override
    public ClienteEntity obtenerClientePorNombre(String clienteSeleccionada) {
        return null;
    }

    @Override
    public List<ClienteEntity> listarClientesPorTipo(ClienteEntity.TipoCliente tipoCliente) throws DataAccessException {
        return null;
    }

    @Override
    public void asociarClienteAVenta(ClienteEntity clienteSeleccionado, VentaEntity ventaActual) {

    }

    @Override
    public List<ClienteEntity> buscarClientes(String tipoBusqueda, String valorBusqueda) {
        return null;
    }

    @Override
    public List<ClienteEntity> buscarClientesPorNombre(String nombreCliente) {
        return null;
    }
}
