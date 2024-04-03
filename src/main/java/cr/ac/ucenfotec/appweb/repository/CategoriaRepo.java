package cr.ac.ucenfotec.appweb.repository;

import cr.ac.ucenfotec.appweb.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepo extends JpaRepository <Categoria, Long> {

}
