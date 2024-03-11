package sena.mundodrone.app.servicio;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sena.mundodrone.app.model.VentaEntity;
import sena.mundodrone.app.repository.VentaRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
@Service
public class VentaService implements IVentaService{
    @Autowired
    private VentaRepository ventaRepository;


    @Override
    public int saveVenta(VentaEntity VentaEntity) {
        return 0;
    }

    @Override
    public void deleteVenta(Integer idVenta) {

    }

    @Override
    public List<VentaEntity> obtenerVentasDelDia(LocalDate fecha) {
        return ventaRepository.findByFechaVenta(fecha);
    }

    public List<VentaEntity> obtenerTodasLasVentas() {
        return ventaRepository.findAll();
    }

    @Override
    @Transactional
    public List<VentaEntity> obtenerVentasDelMes(LocalDate inicio, LocalDate fin) {
        List<VentaEntity> ventas = ventaRepository.findByFechaVentaBetween(inicio, fin);
        // Forzar la inicialización de la colección detallesVenta
        for (VentaEntity venta : ventas) {
            venta.getDetallesventa().size(); // Esto carga la colección
        }
        return ventas;
    }

    @Override
    public BigDecimal calcularFacturacionDelDia(LocalDate fecha) {
        List<VentaEntity> ventasDelDia = obtenerVentasDelDia(fecha);
        BigDecimal facturacionTotal = BigDecimal.ZERO;
        for (VentaEntity venta : ventasDelDia) {
            facturacionTotal = facturacionTotal.add(venta.getTotalVenta());
        }
        return facturacionTotal;
    }

    @Override
    public BigDecimal calcularFacturacionTotal() {
        List<VentaEntity> ventas = ventaRepository.findAll();
        BigDecimal facturacionTotal = BigDecimal.ZERO;
        for (VentaEntity venta : ventas) {
            facturacionTotal = facturacionTotal.add(venta.getTotalVenta());
        }
        return facturacionTotal;
    }
}
