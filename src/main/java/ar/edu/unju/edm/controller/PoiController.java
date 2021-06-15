package ar.edu.unju.edm.controller;


import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ar.edu.unju.edm.model.Poi;
import ar.edu.unju.edm.service.IPoiService;



@Controller
public class PoiController {
	@Autowired
	@Qualifier("implementacionmysql")	
	IPoiService poiService; 

		//Get
		@GetMapping("/poi/agregar")
		public String cargarPoi(Model model) {
		model.addAttribute("unPoi", poiService.crearPoi());
		model.addAttribute("pois", poiService.obtenerTodosPois());
			return("addpoi");
		} 
		
		@GetMapping("/poi/mostrar")
		public String mostrarPoi(Model model) {
		model.addAttribute("pois", poiService.obtenerTodosPois());
			return("pois");
		} 
		@GetMapping("/poi/mispuntos")
		public String mostrarPois(Model model) {
		model.addAttribute("pois", poiService.obtenerTodosPois());
			return("mypois");
		} 
		
		//
		
		@GetMapping("/poi/editar/{codigoPoi}")
		public String editarPoi(Model model, @PathVariable(name="codigoPoi") Integer codigoPoi) throws Exception {		
			try {
				Poi poiEncontrado = poiService.encontrarUnPoi(codigoPoi);
				model.addAttribute("unPoi", poiEncontrado);	
				model.addAttribute("editMode", "true");
			}
			catch (Exception e) {
				model.addAttribute("formUsuarioErrorMessage",e.getMessage());
				model.addAttribute("unPoi", poiService.crearPoi());
				model.addAttribute("editMode", "false");
			}				
			model.addAttribute("pois", poiService.obtenerTodosPois());		
			return "addpoi";
		}
		
		@GetMapping("/poi/eliminarPoi/{codigoPoi}")
		public String eliminarPoi(Model model, @PathVariable(name="codigoPoi") Integer codigoPoi) {
			
			try {
				poiService.eliminarPoi(codigoPoi);			
			}
			catch(Exception e){
				model.addAttribute("listErrorMessage",e.getMessage());
			}			
			return "mypois";
		}
		@GetMapping("/cancelar")
		public String cancelar() {
			return "redirect:/poi/agregar";
		}
		
		//Post
		@PostMapping("/poi/modificar")
		public String modificarPoi(@ModelAttribute("unPoi") Poi poiModificado, Model model) {
			try {
					poiService.modificarPoi(poiModificado);
					model.addAttribute("unPoi", new Poi());				
					model.addAttribute("editMode", "false");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					model.addAttribute("formUsuarioErrorMessage",e.getMessage());
					model.addAttribute("unPoi", poiModificado);			
					model.addAttribute("pois", poiService.obtenerTodosPois());
					model.addAttribute("editMode", "true");
				}		
				model.addAttribute("pois", poiService.obtenerTodosPois());
			return "mypois";
		}
		@PostMapping(value="/addpoi/guardar", consumes= "multipart/form-data")
		public String guardarNuevoPoI(@RequestParam("file") MultipartFile file, @ModelAttribute("unPoi") Poi nuevoPoi, Model model) throws IOException {
		
		byte[] content = file.getBytes();
		String base64 = Base64.getEncoder().encodeToString(content);
		nuevoPoi.setImagen(base64);
		poiService.guardarPoi(nuevoPoi);		
		
	
			return "redirect:/poi/mostrar";
				
			
	}
		

}
