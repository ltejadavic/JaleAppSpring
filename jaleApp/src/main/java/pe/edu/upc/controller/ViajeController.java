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

import pe.edu.upc.entities.Viaje;
import pe.edu.upc.service.IReservaService;
import pe.edu.upc.service.IStateViajeService;
import pe.edu.upc.service.IViajeService;

@Controller
@RequestMapping("/viajes")
public class ViajeController {
	@Autowired
	private IViajeService vService;
	
	@Autowired
	private IStateViajeService sService;
	
	@Autowired
	private IReservaService reService;
	
	
	@GetMapping("/new")
	public String newViaje(Model model) {
		
		model.addAttribute("viaje",new Viaje());
		model.addAttribute("listaState",sService.list());
		model.addAttribute("listaReservas",reService.list());
		
		return "viaje/viaje";
	}
	@PostMapping("/save")
	public String saveViaje(@Valid @ModelAttribute(value = "viaje") Viaje vi,BindingResult result,
			Model model, SessionStatus status) {
		
		if (result.hasErrors()) {
			model.addAttribute("listaState",sService.list());
			model.addAttribute("listaReservas",reService.list());
			return "viaje/viaje";
		}else {
			vService.insert(vi);
			model.addAttribute("listaState",sService.list());
			model.addAttribute("listaReservas",reService.list());
			model.addAttribute("mensaje", "Se realizo correctamente");
			status.setComplete();
			return "redirect:/viajes/list";
		}
			
		
	}
	
	
	
	
	@GetMapping("/list")
	public String listViaje(Model model) {

		try {
			
			model.addAttribute("listViaje", vService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "viaje/listViaje";
	}
	
	@RequestMapping("/delete")
	public String deleteState(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				vService.delete(id);
				model.put("mensaje", "Selimino Correctamente");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "Ocurrio un error");
		}

		return "redirect:/viajes/list";
	}
	
	
	
}
