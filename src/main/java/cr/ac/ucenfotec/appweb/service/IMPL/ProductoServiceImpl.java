package cr.ac.ucenfotec.appweb.service.IMPL;

import cr.ac.ucenfotec.appweb.entity.Producto;
import cr.ac.ucenfotec.appweb.repository.ProductoRepo;
import cr.ac.ucenfotec.appweb.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements GenericService<Producto> {

    @Autowired
    private ProductoRepo productoRepo;

    @Override
    public Long save(Producto nuevo) {
        Producto saved = productoRepo.save(nuevo);
        return saved.getId();
    }

    @Override
    public List<Producto> getAll() {
        return productoRepo.findAll();
    }

    @Override
    public Producto getById(long id) {
        return productoRepo.getReferenceById(id);
    }

    @Override
    public void update(Producto nuevoProducto) {
        productoRepo.save(nuevoProducto);
    }

    @Override
    public void delete(long id) {
        productoRepo.deleteById(id);
    }
}
