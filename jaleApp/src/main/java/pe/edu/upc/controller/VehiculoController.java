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

import pe.edu.upc.entities.Vehiculo;
import pe.edu.upc.service.IConductorService;
import pe.edu.upc.service.IMarcaService;
import pe.edu.upc.service.IVehiculoService;

@Controller
@RequestMapping("/vehicles")
public class VehiculoController {

	@Autowired
	private IVehiculoService vService;

	@Autowired
	private IConductorService cService;
	
	@Autowired
	private IMarcaService mService;

	/* localhost: 8083/vehicles/ */
	@GetMapping("/new")
	public String newSpecialty(Model model) {
		model.addAttribute("vehiculo", new Vehiculo());
		model.addAttribute("listaConductor", cService.list());
		model.addAttribute("listaBrand", mService.list());

		return "vehiculo/vehiculo";
	}

	@PostMapping("/save")
	public String saveVehiculo(@Valid @ModelAttribute(value = "vehiculo") Vehiculo vehiculo, BindingResult result,
			Model model, SessionStatus status) throws Exception {

		if (result.hasErrors()) {
			model.addAttribute("listaConductor",cService.list());
			model.addAttribute("listaBrand",mService.list());
			return "vehiculo/vehiculo";
		} else {
			vService.insert(vehiculo);
			model.addAttribute("listaConductor",cService.list());
			model.addAttribute("listaBrand",mService.list());
			model.addAttribute("mensaje", "Se realizo correctamente");
			status.setComplete();
			return "redirect:/vehicles/list";
		}
	}

	@GetMapping("/list")
	public String listVehiculo(Model model) {
		try {
			model.addAttribute("listaVehiculos", vService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}

		return "vehiculo/listVehiculo";
	}

	@RequestMapping("/delete")
	public String deleteVehiculo(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				vService.delete(id);
				model.put("mensaje", "Se elimino correctamente");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "Ocurrio un error");
		}

		return "redirect:/vehicles/list";
	}
	
	@GetMapping("/listVehicleRep")
	public String listvehicleR(Map<String, Object> model) {
		model.put("listVehiclesReport", vService.vehiculoyear());

		return "reports/listVehicleReport";
	}
		
}
