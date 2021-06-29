package pe.edu.upc.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

	/* localhost:8082/passengers/ */
	@GetMapping("/new")
	public String newPassenger(Model model) {
		model.addAttribute("passenger", new Pasajero());

		return "passenger/passenger";
	}

	@PostMapping("/save")
	public String saveMedic(@Valid @ModelAttribute(value = "passenger") Pasajero pas, BindingResult result, Model model,
			SessionStatus status) throws Exception {

		if (result.hasErrors()) {
			return "passenger/passenger";
		} else {
			pService.insert(pas);
			model.addAttribute("mensaje", "Se realizo correctamente");
			status.setComplete();
			return "redirect:/passengers/list";
		}

	}
	
	@Secured({"ROLE_PASSENGER", "ROLE_DEV" })
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
				model.put("mensaje", "Selimino Correctamente");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "Ocurrio un error");
		}

		return "redirect:/passengers/list";
	}
	
	
	@GetMapping("/detalle/{id}")
	public String viewPassenger( @PathVariable(value = "id") int id,Model model) {
		try {
			Optional<Pasajero>pasajero=pService.listarid(id);
			if (!pasajero.isPresent()) {
				model.addAttribute("mensaje","Pasajero no existe!!");
				return "redirect:/passengers/list";
			}else {
				model.addAttribute("passenger",pasajero.get());
				return "passenger/updatePassenger";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		
		return "passenger/updatePassenger";
		
	}
	
	@GetMapping("/listFind")
	public String listCategoriesFind(Model model) {
		try {
			model.addAttribute("passenger", new Pasajero());
			model.addAttribute("listaPasajeros", pService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/passenger/find";
	}
	
	@RequestMapping("/find")
	public String findbyMedice(Model model,@ModelAttribute Pasajero pass) throws ParseException{
		
		model.addAttribute("passenger", new Pasajero());
		List<Pasajero> listpass;
		
		pass.setNamePasajero(pass.getNamePasajero());
		listpass=pService.findByname(pass.getNamePasajero());
		
		if(listpass.isEmpty()) {
			listpass=pService.findBynamePasajeroLikeIgnoreCase(pass.getNamePasajero());
			
			
		}
		if(listpass.isEmpty()) {
			
			model.addAttribute("mensaje","No se encontró");
			
		}
		
		model.addAttribute("listaPasajeros", listpass);
		return "/passenger/find";
		
	}
	
	
}
