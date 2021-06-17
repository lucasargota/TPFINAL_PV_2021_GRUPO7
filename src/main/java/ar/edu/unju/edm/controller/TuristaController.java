package ar.edu.unju.edm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ar.edu.unju.edm.model.Turista;
import ar.edu.unju.edm.service.IPoiService;
import ar.edu.unju.edm.service.ITuristaService;

@Controller
public class TuristaController{
	@Autowired
	@Qualifier("implementacionmysql")	
	IPoiService poiService; 
	
@Autowired
@Qualifier("implementacion2mysql")	
ITuristaService turistaService;
	//Get
//acá cambié el get mapping, si quieren abrir el turistas usen turista registrar.
	@GetMapping("/turista/registrar")
	public String cargarTurista(Model model) {
		model.addAttribute("unTurista", turistaService.crearTurista());
		model.addAttribute("turistas", turistaService.obtenerTodosTuristas());
		return("turistas");
	} 
	
	@GetMapping("/perfil")
	public String perfilTurista(Model model, Authentication authentication) throws Exception {
		//model.addAttribute("turistas", turistaService.obtenerTodosTuristas());
		UserDetails userTurista = (UserDetails) authentication.getPrincipal();
		model.addAttribute("unTurista", turistaService.encontrarPorEmail(userTurista.getUsername()));
		return("perfil");
	} 
	
	//Para la pagina usuario
	@GetMapping("/turista/buscar/{id}")
	public String buscarTurista(Model model, @PathVariable(name="id") Integer id) throws Exception {		
		try {
			Turista turistaEncontrado = turistaService.encontrarUnTurista(id);
			model.addAttribute("unTurista", turistaEncontrado);	
			model.addAttribute("editMode", "true");
		}
		catch (Exception e) {
			model.addAttribute("formUsuarioErrorMessage",e.getMessage());
			model.addAttribute("unTurista", turistaService.crearTurista());
			model.addAttribute("editMode", "false");
		}				
		model.addAttribute("turistas", turistaService.obtenerTodosTuristas());		
		return "usuario";
	}
	@GetMapping("/turista/editar/{id}")
	public String editarTurista(Model model, @PathVariable(name="id") Integer id) throws Exception {		
		try {
			Turista turistaEncontrado = turistaService.encontrarUnTurista(id);
			model.addAttribute("unTurista", turistaEncontrado);	
			model.addAttribute("editMode", "true");
		}
		catch (Exception e) {
			model.addAttribute("formUsuarioErrorMessage",e.getMessage());
			model.addAttribute("unTurista", turistaService.crearTurista());
			model.addAttribute("editMode", "false");
		}				
		model.addAttribute("turistas", turistaService.obtenerTodosTuristas());		
		return "turistas";
	}
	@GetMapping("/turista/eliminarTurista/{id}")
	public String eliminarTurista(Model model, @PathVariable(name="id") Integer id) {
		
		try {
			turistaService.eliminarTurista(id);	
			
				
			
			return "redirect:/home";
			
		}
		catch(Exception e){
			model.addAttribute("listErrorMessage",e.getMessage());
			return "redirect:/perfil";
		}			
		
	}
	@GetMapping("/cancelar/turista")
	public String cancelar() {
		return "redirect:turistas/redirect";
	}
	
	//Post
	@PostMapping("/turista/guardar")
	public String guardarNuevoturista(@ModelAttribute("UnTurista") Turista nuevoTurista, Model model ) {		
	
		turistaService.guardarTurista(nuevoTurista);
			return "redirect:/home";
				
			
	}
	
	@PostMapping("/turista/modificar")
	public String modificarPoi(@ModelAttribute("unTurista") Turista turistaModificado, Model model) {
			try {
				turistaService.modificarTurista(turistaModificado);
				model.addAttribute("unTurista", new Turista());				
				model.addAttribute("editMode", "false");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				model.addAttribute("formUsuarioErrorMessage",e.getMessage());
				model.addAttribute("unTurista", turistaModificado);			
				model.addAttribute("turistas", turistaService.obtenerTodosTuristas());
				model.addAttribute("editMode", "true");
			}		
			model.addAttribute("turistas", turistaService.obtenerTodosTuristas());
		return "redirect:/perfil";
	}
}
