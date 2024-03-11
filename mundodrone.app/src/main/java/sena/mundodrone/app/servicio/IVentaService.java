package sena.mundodrone.app.servicio;
import sena.mundodrone.app.model.VentaEntity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface IVentaService {
	
	int saveVenta(VentaEntity VentaEntity);
	void deleteVenta(Integer idVenta);
    List<VentaEntity> obtenerVentasDelDia(LocalDate fecha);
    
    List<VentaEntity> obtenerTodasLasVentas();

    List<VentaEntity> obtenerVentasDelMes(LocalDate inicio, LocalDate fin);

    BigDecimal calcularFacturacionDelDia(LocalDate fecha);

    BigDecimal calcularFacturacionTotal();
}
