package cr.ac.ucenfotec.appweb.service.IMPL;

import cr.ac.ucenfotec.appweb.entity.Categoria;
import cr.ac.ucenfotec.appweb.repository.CategoriaRepo;
import cr.ac.ucenfotec.appweb.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements GenericService<Categoria> {

    @Autowired
    private CategoriaRepo categoriaRepo;
    @Override
    public Long save(Categoria nueva) {
        Categoria saved = categoriaRepo.save(nueva);
        return saved.getId();
    }

    @Override
    public List<Categoria> getAll() {
        return categoriaRepo.findAll();
    }

    @Override
    public Categoria getById(long id) {
        return categoriaRepo.getReferenceById(id);
    }

    @Override
    public void update(Categoria nuevaCategoria) {
        categoriaRepo.save(nuevaCategoria);
    }

    @Override
    public void delete(long id) {
        categoriaRepo.deleteById(id);
    }
}
