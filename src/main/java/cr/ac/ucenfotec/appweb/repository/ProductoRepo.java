package cr.ac.ucenfotec.appweb.repository;

import cr.ac.ucenfotec.appweb.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepo extends JpaRepository <Producto, Long> {

}
