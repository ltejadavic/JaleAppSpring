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

import pe.edu.upc.entities.Marca;
import pe.edu.upc.entities.StateViaje;
import pe.edu.upc.service.IMarcaService;

@Controller
@RequestMapping("/brands")
public class MarcaController {
	@Autowired
	private IMarcaService mService;
	
	@GetMapping("/new")
	public String newState(Model model) {
		model.addAttribute("brand", new Marca());
		return "marca/marca";
	}
	
	@PostMapping("/save")
	public String saveBrand(@Valid @ModelAttribute(value = "brand") Marca m, BindingResult result, Model model,
			SessionStatus status) throws Exception {
		
		if(result.hasErrors()) {
			return "marca/marca";
		}else {
			mService.insert(m);
			model.addAttribute("mensaje", "Se realizo correctamente");
			status.setComplete();
			return "redirect:/brands/list";
		}
		
		
	}
	
	@GetMapping("/list")
	public String listPasajero(Model model) {
		try {
			model.addAttribute("listaBrand", mService.list());
		} catch (Exception e) {
			model.addAttribute("error en controller state viaje", e.getMessage());
		}

		return "marca/listMarca";

	}
	
	@RequestMapping("/delete")
	public String deleteState(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				mService.delete(id);
				model.put("mensaje", "Selimino Correctamente");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "Ocurrio un error");
		}

		return "redirect:/brands/list";
	}
	
	

}
