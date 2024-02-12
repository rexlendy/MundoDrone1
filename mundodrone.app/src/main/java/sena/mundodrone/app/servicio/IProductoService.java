package sena.mundodrone.app.servicio;

import sena.mundodrone.app.model.ProductoEntity;

import java.util.List;

public interface IProductoService {
    public List<ProductoEntity> getAllProducto();
    public ProductoEntity findById(Integer idProducto);
    public void saveProducto(ProductoEntity productoEntity);
    public void deleteProducto(ProductoEntity productoEntity);
}
