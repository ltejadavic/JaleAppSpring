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

import pe.edu.upc.entities.Reservacion;

import pe.edu.upc.service.IConductorService;
import pe.edu.upc.service.IReservaService;
import pe.edu.upc.service.IRutaService;

@Controller
@RequestMapping("/reservas")
public class ReservaController {

	@Autowired
	private IReservaService reService;

	@Autowired
	private IRutaService ruService;
	@Autowired
	private IConductorService coService;

	@RequestMapping("/reports")
	public String Report()
	{
		return "reports/reporteReserva";
	}
	
	@GetMapping("/new")
	public String newReserva(Model model) {

		model.addAttribute("reserva", new Reservacion());
		model.addAttribute("listaRutas", ruService.list());
		model.addAttribute("listaConductores", coService.list());
		return "reserva/reserva";
	}

	@PostMapping("/save")
	public String saveRute(@Valid @ModelAttribute(value = "reserva") Reservacion re, BindingResult result, Model model,
			SessionStatus status) throws Exception {
		if (result.hasErrors()) {
			model.addAttribute("listaRutas", ruService.list());
			model.addAttribute("listaConductores", coService.list());
			return "reserva/reserva";
		} else {
			reService.insert(re);
			model.addAttribute("listaRutas", ruService.list());
			model.addAttribute("listaConductores", coService.list());
			model.addAttribute("mensaje", "Se realizo correctamente");
			status.setComplete();
			return "redirect:/reservas/list";
		}

	}

	@GetMapping("/list")
	public String listConductor(Model model) {
		try {
			model.addAttribute("listaReservas", reService.list());
		} catch (Exception e) {
			model.addAttribute("error en controller reserva", e.getMessage());
		}

		return "reserva/listReserva";

	}

	@GetMapping("/delete")
	public String deleteRuta(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				reService.delete(id);
				model.put("mensaje", "Se elimino Correctamente");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "Ocurrio un error");
		}

		return "redirect:/reservas/list";
	}
	
	@GetMapping("/listRuta")
	public String listrutaM(Map<String, Object> model) {
		model.put("listReservasRuta", reService.rutasmayor());

		return "reports/listReservaRuta";
		
	}
	@GetMapping("/listCond")
	public String listcondM(Map<String, Object> model) {
		model.put("listReservasCond", reService.conductormayor());

		return "reports/listReservaCon";
		
	}

}
