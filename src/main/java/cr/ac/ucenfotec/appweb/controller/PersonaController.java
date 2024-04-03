package cr.ac.ucenfotec.appweb.controller;

import cr.ac.ucenfotec.appweb.entity.Persona;
import cr.ac.ucenfotec.appweb.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/personas")
public class PersonaController {
    @Autowired
    GenericService<Persona> personaService;

    @RequestMapping("/")
    public String home(Model model) {
        return "index";
    }
    @RequestMapping(value="/insertarPersona", method = RequestMethod.GET)
    public String insertarPage(Model model) {
        model.addAttribute("persona", new Persona());
        return "insertarPersona";
    }
    @RequestMapping(value="/insertarPersona", method = RequestMethod.POST)
    public String insertarAction(Persona persona, BindingResult result, Model
            model) {
        personaService.save(persona);
        return "index";
    }
    @RequestMapping("/listarPersonas")
    public String listar(Model model) {
        model.addAttribute("personas", personaService.getAll());
        return "listarPersonas";
    }

}
