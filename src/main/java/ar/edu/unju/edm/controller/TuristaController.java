package ar.edu.unju.edm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.edm.service.ITuristaService;

@Controller
public class TuristaController{
	
@Autowired
@Qualifier("implementacion2mysql")	
ITuristaService turistaService;
	
	@GetMapping("/turista/mostrar")
	public String cargarTurista(Model model) {
		model.addAttribute("unTurista", turistaService.crearTurista());
		model.addAttribute("turistas", turistaService.obtenerTodosTuristas());
		return("turistas");
	} 
	@PostMapping("/turista/guardar")
	public String guardarNuevoturista( Model model) {		
	
			return "redirect:/turista/mostrar";
				
			
	}
	

	
	
}
