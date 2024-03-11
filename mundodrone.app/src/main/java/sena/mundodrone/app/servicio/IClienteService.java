package sena.mundodrone.app.servicio;
import org.springframework.dao.DataAccessException;
import sena.mundodrone.app.model.ClienteEntity;
import sena.mundodrone.app.model.VentaEntity;

import java.time.LocalDate;
import java.util.List;
public interface IClienteService {
	
	public List<ClienteEntity> listarClientes();
    public List<ClienteEntity> obtenerClientesDelDia(LocalDate fecha);

    public ClienteEntity buscarClientePorId(Integer idCliente);
    public void guardarCliente(ClienteEntity cliente);

    public void eliminarCliente(ClienteEntity cliente);

    ClienteEntity obtenerClientePorNombre(String clienteSeleccionada);

    List<ClienteEntity> listarClientesPorTipo(ClienteEntity.TipoCliente tipoCliente) throws DataAccessException;


    void asociarClienteAVenta(ClienteEntity clienteSeleccionado, VentaEntity ventaActual);

    List<ClienteEntity> buscarClientes(String tipoBusqueda, String valorBusqueda);

    List<ClienteEntity> buscarClientesPorNombre(String nombreCliente);
}
