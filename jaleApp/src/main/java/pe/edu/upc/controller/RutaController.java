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

import pe.edu.upc.entities.Ruta;
import pe.edu.upc.service.IPasajeroService;
import pe.edu.upc.service.IRutaService;
@Controller
@RequestMapping("/rutas")
public class RutaController {
	@Autowired
	private IRutaService rService;
	
	@Autowired
	private IPasajeroService pService;
	
	@GetMapping("/new")
	public String newRuta(Model model) {
		
		model.addAttribute("ruta", new Ruta());
		model.addAttribute("listPasajero", pService.list());
		return "ruta/ruta";
	}
	
	@PostMapping("/save")
	public String saveRute(@Valid @ModelAttribute(value = "ruta")Ruta ru,BindingResult result,
	Model model, SessionStatus status) throws Exception {
		if (result.hasErrors()) {
			model.addAttribute("listPasajero", pService.list());
			return "ruta/ruta";
		} else {
			rService.insert(ru);
			model.addAttribute("listPasajero", pService.list());
			model.addAttribute("mensaje", "Se realizo correctamente");
			status.setComplete();
			return "redirect:/rutas/list";
		}
		
	}
	
	@GetMapping("/list")
	public String listConductor(Model model) {
		try {
			model.addAttribute("listaRutas", rService.list());
		} catch (Exception e) {
			model.addAttribute("error en controller ruta", e.getMessage());
		}

		return "ruta/listRuta";

	}
	@GetMapping("/delete")
	public String deleteRuta(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				rService.delete(id);
				model.put("mensaje", "Se elimino Correctamente");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "Ocurrio un error");
		}

		return "redirect:/rutas/list";
	}
	
	
	
	
	
}
