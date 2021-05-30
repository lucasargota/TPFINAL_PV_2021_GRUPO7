package ar.edu.unju.edm.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;





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
		public String guardarNuevoPoi( Model model) {		
		
				return "redirect:/turista/mostrar";
					
				
		}
		

}
