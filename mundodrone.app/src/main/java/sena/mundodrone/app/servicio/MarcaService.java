package sena.mundodrone.app.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sena.mundodrone.app.model.MarcaEntity;
import sena.mundodrone.app.repository.MarcaRepository;
import java.util.List;
@Service
public class MarcaService implements IMarcaService{
    @Autowired
    private MarcaRepository marcaRepository;
    @Override
    public List<MarcaEntity> getAllMarca() {
        return marcaRepository.findAll();
    }
    @Override
    public MarcaEntity findById(Integer idMarca) {
        return marcaRepository.findById(idMarca).orElse(null);
    }
    @Override
    public void saveMarca(MarcaEntity marcaEntity) {
                marcaRepository.save(marcaEntity);
    }
    @Override
    public void deleteMarca(MarcaEntity marcaEntity) {
                marcaRepository.delete(marcaEntity);
    }
}
