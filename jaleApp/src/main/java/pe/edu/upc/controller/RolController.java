package pe.edu.upc.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.entities.Role;

import pe.edu.upc.service.IRolService;
import pe.edu.upc.service.IUserService;

@Controller
@Secured("ROLE_ADMIN")
@RequestMapping("/roles")
public class RolController {
	@Autowired
	private IRolService rS;
	@Autowired
	private IUserService uS;

	@GetMapping("/new")
	public String newRole(Model model) {
		model.addAttribute("role", new Role());
		model.addAttribute("listUsers", uS.list());
		return "rol/role";
	}

	@PostMapping("/save")
	public String saveRole(@Validated Role role, BindingResult result, Model model) throws Exception {
		if (result.hasErrors()) {
			return "role/role";
		} else {
			rS.insert(role);
			model.addAttribute("listRoles", rS.list());
			return "redirect:/roles/list";

		}
	}

	@GetMapping("/list")
	public String listRole(Model model) {
		try {
			model.addAttribute("listRoles", rS.list());
		} catch (Exception e) {
			
			model.addAttribute("error", e.getMessage());
		}
		return "rol/listRoles";

	}
	
	@GetMapping("/detalle/{id}")
	public String viewRol( @PathVariable(value = "id") Long id,Model model) {
		try {
			Optional<Role>role=rS.listarid(id);
			if (!role.isPresent()) {
				model.addAttribute("mensaje","Role no existe!!");
				return "redirect:/roles/list";
			}else {
				model.addAttribute("role",role.get());
				model.addAttribute("listUsers", uS.list());
				return "rol/update";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		
		return "rol/update";
		
	}

}
