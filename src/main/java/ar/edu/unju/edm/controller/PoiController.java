package ar.edu.unju.edm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.edm.model.Poi;



@Controller
public class PoiController {
	@Autowired
	@Qualifier("implementacionmysql")	
	//ITuristaService TuristaService;
		
		@GetMapping("/poi/registrar")
		public String cargarPoi(Model model) {
			
			return("poi");
		} 
		@PostMapping("/poi/guardar")
		public String guardarNuevoPoi(@Valid @ModelAttribute("unPoi") Poi nuevoPoi, BindingResult result, Model model) {		
		
				return "redirect:/turista/mostrar";
					
				
		}
		

}
