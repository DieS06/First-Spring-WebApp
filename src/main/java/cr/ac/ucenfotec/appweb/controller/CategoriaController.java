package cr.ac.ucenfotec.appweb.controller;

import cr.ac.ucenfotec.appweb.entity.Categoria;
import cr.ac.ucenfotec.appweb.entity.Producto;
import cr.ac.ucenfotec.appweb.service.GenericService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    GenericService<Categoria> categoriaService;

    Logger logger = LoggerFactory.getLogger(ProductoController.class);

    @RequestMapping("/")
    public String home(Model model) {
        return "index";
    }
    @RequestMapping(value="/insertarCategoria", method = RequestMethod.GET)
    public String insertarPage(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "insertarCategoria";
    }
    @RequestMapping(value="/insertarCategoria", method = RequestMethod.POST)
    public String insertarAction(Categoria categoria, BindingResult result, Model
            model) {
        categoriaService.save(categoria);
        return "index";
    }

    @RequestMapping(value="/editarCategoria/{id}", method = RequestMethod.GET)
    public String editar(Model model, @PathVariable long id) {
        try {
            Categoria categoria = categoriaService.getById(id);
            model.addAttribute("categoria", categoria);
            model.addAttribute("name", categoria.getName());
            model.addAttribute("descripcion", categoria.getDescripcion());
            model.addAttribute("prefijo", categoria.getPrefijo());
            return "editarCategoria";
        } catch (Exception e) {
            logger.error("Can't recover category from database", e);
            return "notFound";
        }
    }

    @RequestMapping(value="/editarCategoria/{id}", method = RequestMethod.POST)
    public String guardarEdicion(Model model, @PathVariable long id,
                                 Categoria editado, BindingResult result) {
        try {
            Categoria categoria = categoriaService.getById(id);
            categoria.setName(editado.getName());
            categoria.setDescripcion(editado.getDescripcion());
            categoria.setPrefijo(editado.getPrefijo());
            categoriaService.save(categoria);
            return "index";
        } catch (Exception e) {
            logger.error("Can't edit", e);
            return "error";
        }
    }

    @RequestMapping(value="/borrarCategoria/{id}", method = RequestMethod.GET)
    public String prepararBorrado(Model model, @PathVariable long id) {
        try {
            Categoria categoria  = categoriaService.getById(id);
            model.addAttribute("categoria", categoria);
            return "borrarCategoria";
        } catch (Exception e) {
            logger.error("Can't edit", e);
            return "error";
        }
    }

    @RequestMapping(value="/borrarCategoria/{id}", method = RequestMethod.POST)
    public String ejecutarBorrado(Model model, @PathVariable long id) {
        try {
            categoriaService.delete(id);
            return "index";
        } catch (Exception e) {
            logger.error("Can't edit", e);
            return "error";
        }
    }

    @RequestMapping("/listarCategorias")
    public String listar(Model model) {
        model.addAttribute("categorias", categoriaService.getAll());
        return "listarCategorias";
    }

}
