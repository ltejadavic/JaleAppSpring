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

import pe.edu.upc.entities.Conductor;
import pe.edu.upc.service.IConductorService;

@Controller
@RequestMapping("/conductors")
public class ConductorController {
	@Autowired
	private IConductorService cService;

	/* localhost:8082/conductors/ */
	@GetMapping("/new")
	public String newConductor(Model model) {
		model.addAttribute("conductor", new Conductor());

		return "conductor/conductor";
	}

	@PostMapping("/save")
	public String saveConductor(@Valid @ModelAttribute(value = "conductor") Conductor con, BindingResult result,
			Model model, SessionStatus status) throws Exception {

		if (result.hasErrors()) {
			return "conductor/conductor";
		} else {
			cService.insert(con);
			model.addAttribute("mensaje", "Se realizo correctamente");
			status.setComplete();
			return "redirect:/conductors/list";
		}

	}

	@GetMapping("/list")
	public String listConductor(Model model) {
		try {
			model.addAttribute("listaConductores", cService.list());
		} catch (Exception e) {
			model.addAttribute("error en controller conductor", e.getMessage());
		}

		return "conductor/listConductor";

	}

	@RequestMapping("/delete")
	public String deleteConductor(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				cService.delete(id);
				model.put("mensaje", "Se elimino Correctamente");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "Ocurrio un error");
		}

		return "redirect:/conductors/list";
	}

}
