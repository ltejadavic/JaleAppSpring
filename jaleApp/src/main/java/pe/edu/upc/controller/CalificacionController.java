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

import pe.edu.upc.entities.Calificacion;

import pe.edu.upc.service.ICalificacionService;
import pe.edu.upc.service.IViajeService;

@Controller
@RequestMapping("/calificacions")
public class CalificacionController {

	@Autowired
	private ICalificacionService cService;
	
	@Autowired
	private IViajeService vService;
	
	@RequestMapping("/reports")
	public String Report()
	{
		return "reports/reporteCali";
	}
	@GetMapping("/new")
	public String newViaje(Model model) {
		
		model.addAttribute("calificacion",new Calificacion());
		model.addAttribute("listaViaje",vService.list());
		
		
		return "calificacion/calificacion";
	}
	@PostMapping("/save")
	public String saveViaje(@Valid @ModelAttribute(value = "calificacion") Calificacion ca,BindingResult result,
			Model model, SessionStatus status) {
		
		if (result.hasErrors()) {
			model.addAttribute("listaViaje",vService.list());
			
			return "calificacion/calificacion";
		}else {
			cService.insert(ca);
			model.addAttribute("listaViaje",vService.list());
		
			model.addAttribute("mensaje", "Se realizo correctamente");
			status.setComplete();
			return "redirect:/calificacions/list";
		}
			
		
	}
	
	
	
	
	@GetMapping("/list")
	public String listViaje(Model model) {

		try {
			
			model.addAttribute("listCalificacion", cService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "calificacion/listCalificacion";
	}
	
	@RequestMapping("/delete")
	public String deleteState(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				cService.delete(id);
				model.put("mensaje", "Selimino Correctamente");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "Ocurrio un error");
		}

		return "redirect:/calificacions/list";
	}
	@GetMapping("/listCali")
	public String listcondM(Map<String, Object> model) {
		model.put("listCalificacionM", cService.calificacionmayor());

		return "reports/listCalificacionPC";
		
	}
	
}
