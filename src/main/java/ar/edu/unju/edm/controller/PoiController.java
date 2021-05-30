package ar.edu.unju.edm.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.edm.model.Poi;
import ar.edu.unju.edm.service.IPoiService;



@Controller
public class PoiController {
	@Autowired
	@Qualifier("implementacionmysql")	
	IPoiService poiService; 

		
		@GetMapping("/poi/agregar")
		public String cargarPoi(Model model) {
		model.addAttribute("unPoi", poiService.crearPoi());
		model.addAttribute("pois", poiService.obtenerTodosPois());
			return("addpoi");
		} 
		@PostMapping("/addpoi/guardar")
		public String guardarNuevoPoI (@ModelAttribute("unPoi") Poi nuevoPoi, Model model) {	
			
			poiService.guardarPoi(nuevoPoi);		
			
		
				return "pois";
					
				
		}
		

}
