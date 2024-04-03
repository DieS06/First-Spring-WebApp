package cr.ac.ucenfotec.appweb.controller;

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
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    GenericService<Producto> productoService;

    Logger logger = LoggerFactory.getLogger(ProductoController.class);

    @RequestMapping("/")
    public String home(Model model) {
        return "index";
    }
    @RequestMapping(value="/insertarProducto", method = RequestMethod.GET)
    public String insertarPage(Model model) {
        model.addAttribute("producto", new Producto());
        return "insertarProducto";
    }
    @RequestMapping(value="/insertarProducto", method = RequestMethod.POST)
    public String insertarAction(Producto producto, BindingResult result, Model
            model) {
        productoService.save(producto);
        return "index";
    }

    @RequestMapping(value="/editarProducto/{id}", method = RequestMethod.GET)
    public String editar(Model model, @PathVariable long id) {
        try {
            Producto producto = productoService.getById(id);
            model.addAttribute("producto", producto);
            model.addAttribute("nombre", producto.getNombre());
            model.addAttribute("precio", producto.getPrecio());
            return "editarProducto";
        } catch (Exception e) {
            logger.error("Can't recover product from database", e);
            return "notFound";
        }
    }

    @RequestMapping(value="/editarProducto/{id}", method = RequestMethod.POST)
    public String guardarEdicion(Model model, @PathVariable long id,
                                 Producto editado, BindingResult result) {
        try {
            Producto producto = productoService.getById(id);
            producto.setNombre(editado.getNombre());
            producto.setPrecio(editado.getPrecio());
            productoService.save(producto);
            return "index";
        } catch (Exception e) {
            logger.error("Can't edit", e);
            return "error";
        }
    }

    @RequestMapping(value="/borrarProducto/{id}", method = RequestMethod.GET)
    public String prepararBorrado(Model model, @PathVariable long id) {
        try {
            Producto producto = productoService.getById(id);
            model.addAttribute("producto", producto);
            return "borrarProducto";
        } catch (Exception e) {
            logger.error("Can't edit", e);
            return "error";
        }
    }

    @RequestMapping(value="/borrarProducto/{id}", method = RequestMethod.POST)
    public String ejecutarBorrado(Model model, @PathVariable long id) {
        try {
            productoService.delete(id);
            return "index";
        } catch (Exception e) {
            logger.error("Can't edit", e);
            return "error";
        }
    }

    @RequestMapping("/listarProductos")
    public String listar(Model model) {
        model.addAttribute("productos", productoService.getAll());
        return "listarProductos";
    }
}
