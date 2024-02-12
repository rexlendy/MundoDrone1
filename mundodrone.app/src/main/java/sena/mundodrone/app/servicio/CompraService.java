package sena.mundodrone.app.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sena.mundodrone.app.model.CompraEntity;
import sena.mundodrone.app.repository.CompraRepository;

import java.util.List;
@Service
public class CompraService implements ICompraService{
    @Autowired
    private CompraRepository compraRepository;
    @Override
    public List<CompraEntity> getAllCompra() {
        return compraRepository.findAll();
    }
    @Override
    public CompraEntity findById(Integer idCompra) {
        return compraRepository.findById(idCompra).orElse(null);
    }
    @Override
    public void saveCompra(CompraEntity compraEntity) {
                compraRepository.save(compraEntity);
    }
    @Override
    public void deleteCompra(CompraEntity compraEntity) {
                compraRepository.delete(compraEntity);
    }
}
