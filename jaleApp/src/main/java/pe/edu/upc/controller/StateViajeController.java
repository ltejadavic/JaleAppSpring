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

import pe.edu.upc.entities.StateViaje;
import pe.edu.upc.service.IStateViajeService;

@Controller
@RequestMapping("/states")
public class StateViajeController {

	@Autowired
	private IStateViajeService svService;

	@GetMapping("/new")
	public String newState(Model model) {
		model.addAttribute("state", new StateViaje());
		return "state/state";
	}

	@PostMapping("/save")
	public String saveState(@Valid @ModelAttribute(value = "state") StateViaje sv, BindingResult result, Model model,
			SessionStatus status) throws Exception {
		
		if(result.hasErrors()) {
			return "state/state";
		}else {
			svService.insert(sv);
			model.addAttribute("mensaje", "Se realizo correctamente");
			status.setComplete();
			return "redirect:/states/list";
		}
		
		
	}
	
	
	@GetMapping("/list")
	public String listPasajero(Model model) {
		try {
			model.addAttribute("listaState", svService.list());
		} catch (Exception e) {
			model.addAttribute("error en controller state viaje", e.getMessage());
		}

		return "state/listState";

	}
	
	@RequestMapping("/delete")
	public String deleteState(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				svService.delete(id);
				model.put("mensaje", "Selimino Correctamente");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "Ocurrio un error");
		}

		return "redirect:/states/list";
	}
	
	

}
