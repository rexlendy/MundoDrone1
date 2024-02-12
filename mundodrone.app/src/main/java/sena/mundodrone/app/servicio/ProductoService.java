package sena.mundodrone.app.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sena.mundodrone.app.model.ProductoEntity;
import sena.mundodrone.app.repository.ProductoRepository;

import java.util.List;
@Service
public class ProductoService implements IProductoService{
    @Autowired
    private ProductoRepository productoRepository;
    @Override
    public List<ProductoEntity> getAllProducto() {
        return productoRepository.findAll();
    }
    @Override
    public ProductoEntity findById(Integer idProducto) {
        return productoRepository.findById(idProducto).orElse(null);
    }
    @Override
    public void saveProducto(ProductoEntity productoEntity) {
                productoRepository.save(productoEntity);
    }
    @Override
    public void deleteProducto(ProductoEntity productoEntity) {
                productoRepository.delete(productoEntity);
    }
}
