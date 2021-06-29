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

import pe.edu.upc.entities.Conductor;
import pe.edu.upc.service.IConductorService;

@Controller
@RequestMapping("/conductors")
public class ConductorController {
	@Autowired
	private IConductorService cService;

	/* localhost:8083/conductors/ */
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

	@Secured({"ROLE_DRIVER", "ROLE_DEV" })
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
	
	@GetMapping("/detalle/{id}")
	public String viewConductor( @PathVariable(value = "id") int id,Model model) {
		try {
			Optional<Conductor>conductor=cService.listarid(id);
			if (!conductor.isPresent()) {
				model.addAttribute("mensaje","Centro medico no exite!!");
				return "redirect:/conductors/list";
			}else {
				model.addAttribute("conductor",conductor.get());
				return "conductor/updateConductor";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		
		return "conductor/updateConductor";
		
	}
	
	@GetMapping("/listFind")
	public String listCategoriesFind(Model model) {
		try {
			model.addAttribute("conductor", new Conductor());
			model.addAttribute("listaConductores", cService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/conductor/find";
	}
	@RequestMapping("/find")
	public String findbyMedice(Model model,@ModelAttribute Conductor conductor) throws ParseException{
		
		model.addAttribute("conductor", new Conductor());
		List<Conductor> listcondu;
		
		conductor.setNameConductor(conductor.getNameConductor());
		listcondu=cService.findByname(conductor.getNameConductor());
		
		if(listcondu.isEmpty()) {
			listcondu=cService.findBynameConductorLikeIgnoreCase(conductor.getNameConductor());
			
			
		}
		if(listcondu.isEmpty()) {
			
			model.addAttribute("mensaje","No se encontró");
			
		}
		
		model.addAttribute("listaConductores", listcondu);
		return "/conductor/find";
		
	}
	
	
	

}
