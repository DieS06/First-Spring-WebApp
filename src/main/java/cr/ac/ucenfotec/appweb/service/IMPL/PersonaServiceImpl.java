package cr.ac.ucenfotec.appweb.service.IMPL;

import cr.ac.ucenfotec.appweb.entity.Persona;
import cr.ac.ucenfotec.appweb.repository.PersonaRepo;
import cr.ac.ucenfotec.appweb.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements GenericService<Persona> {

    @Autowired
    private PersonaRepo personaRepo;

    @Override
    public Long save(Persona nueva) {
        Persona saved = personaRepo.save(nueva);
        return saved.getId();
    }

    @Override
    public List<Persona> getAll() {
        return personaRepo.findAll();
    }

    @Override
    public Persona getById(long id) {
        return personaRepo.getReferenceById(id);
    }

    @Override
    public void update(Persona nuevaPersona) {
        personaRepo.save(nuevaPersona);
    }

    @Override
    public void delete(long id) {
        personaRepo.deleteById(id);
    }
}
