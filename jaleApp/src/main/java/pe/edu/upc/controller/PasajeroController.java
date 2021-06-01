package pe.edu.upc.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.entities.Pasajero;
import pe.edu.upc.service.IPasajeroService;

@Controller
@RequestMapping("/passengers")
public class PasajeroController {
	@Autowired
	private IPasajeroService pService;

	/* localhost:8083/passengers/ */
	@GetMapping("/new")
	public String newPassenger(Model model) {
		model.addAttribute("passenger", new Pasajero());

		return "passenger/passenger";
	}

	@PostMapping("/save")
	public String savePassenger(@Valid @ModelAttribute(value = "passenger") Pasajero pas, BindingResult result,
			Model model, SessionStatus status) throws Exception {

		if (result.hasErrors()) {
			return "passenger/passenger";
		} else {
			pService.insert(pas);
			model.addAttribute("mensaje", "Se realizo correctamente");
			status.setComplete();
			return "redirect:/passengers/list";
		}

	}

	@GetMapping("/list")
	public String listPasajero(Model model) {
		try {
			model.addAttribute("listaPasajeros", pService.list());
		} catch (Exception e) {
			model.addAttribute("error en controller pasajero", e.getMessage());
		}

		return "passenger/listPassenger";

	}

	@RequestMapping("/delete")
	public String deletePasajero(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				pService.delete(id);
				model.put("mensaje", "Se elimino Correctamente");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "Ocurrio un error");
		}

		return "redirect:/passengers/list";
	}
}
