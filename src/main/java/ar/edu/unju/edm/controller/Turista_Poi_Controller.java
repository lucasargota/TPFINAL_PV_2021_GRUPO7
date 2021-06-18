package ar.edu.unju.edm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.edm.model.Poi;
import ar.edu.unju.edm.model.Turista;
import ar.edu.unju.edm.model.Turista_Poi;
import ar.edu.unju.edm.service.IPoiService;
import ar.edu.unju.edm.service.ITuristaService;
import ar.edu.unju.edm.service.ITurista_PoiService;
@Controller
public class Turista_Poi_Controller {

	@Autowired
	@Qualifier("implementacionmysql")	
	IPoiService poiService; 
	@Autowired
	@Qualifier("implementacion2mysql")	
	ITuristaService turistaService;
	@Autowired
	@Qualifier("implementacion3mysql")
	ITurista_PoiService tpService;
	
	//GET
	@GetMapping("/detallespoi/{codigoPoi}")
	public String cargarValoracion(Model model,@PathVariable(name="codigoPoi") Integer codigoPoi) {
		Turista_Poi cargarDetalles = tpService.crearTurista_Poi();
		System.out.println("hola");
		try {
			Poi poiEncontrado = poiService.encontrarUnPoi(codigoPoi);
            model.addAttribute("unPoi", poiEncontrado);
			cargarDetalles.setOtroPoi(poiService.encontrarUnPoi(codigoPoi));
			System.out.println(cargarDetalles.getOtroPoi().getCodigoPoi());
			model.addAttribute("unDetalle", cargarDetalles);
		    model.addAttribute("detalles", tpService.obtenerTodosTuristas_Pois());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	    return ("detallespoi");
	}
	
	
	@GetMapping("/detallespoi/editar/{idTP}")
	public String editarValoracion(Model model, @PathVariable(name="idTP") Integer idTP) throws Exception {
		try {
			Turista_Poi detalleEncontrado = tpService.encontrarUnTurista_Poi(idTP);
			model.addAttribute("unDetalle", detalleEncontrado);
		    model.addAttribute("editMode", "true");
			
		}
		catch (Exception e) {
			model.addAttribute("formUsuarioErrorMessage",e.getMessage());
			model.addAttribute("unDetalle", tpService.crearTurista_Poi());
			model.addAttribute("editMode", "false");
		}
		
		model.addAttribute("detalles" , tpService.obtenerTodosTuristas_Pois());
		return("detallespoi");
		
	}
	
	
	@GetMapping("/detallespoi/eliminarDetalle/{idTP}")
	public String eliminarValoracion(Model model, @PathVariable(name="idTp") Integer idTP) {		
		try {	
			tpService.eliminarTurista_Poi(idTP);
		}
		catch(Exception e){
			model.addAttribute("listErrorMessage",e.getMessage());
		}			
		return "redirect:/pois";
	}



	//POST
	@PostMapping("/detallespoi/guardar/{codigoPoi}")
	public String guardarNuevoDetalle( @ModelAttribute("unDetalle") Turista_Poi nuevoDetalle,@PathVariable(name="codigoPoi") Integer codigoPoi, Model model) {		
		
		//System.out.println(valoracionService.obtenerTodasValoraciones());
		model.addAttribute("detalles", tpService.obtenerTodosTuristas_Pois().size());
		
		Authentication auth = SecurityContextHolder
	            .getContext()
	            .getAuthentication();
	    UserDetails userDetail = (UserDetails) auth.getPrincipal();
	    
	    System.out.println(userDetail.getUsername());
	    try {
	    	Poi poiEncontrado = poiService.encontrarUnPoi(codigoPoi);
	    	nuevoDetalle.setOtroPoi(poiEncontrado);
			System.out.println(nuevoDetalle.getOtroPoi().getCodigoPoi());
			Turista turistaEncontrado = turistaService.encontrarPorEmail(userDetail.getUsername() );
			if (turistaEncontrado != null) {
				
				if (nuevoDetalle.getComentario().isEmpty()) {
					nuevoDetalle.setComentario(null);
				}
				else {
					turistaEncontrado.setPuntos(turistaEncontrado.getPuntos() + 5);
				}
				
				if(nuevoDetalle.getValoracion() != 0) {
					turistaEncontrado.setPuntos(turistaEncontrado.getPuntos() + 8);
				}
				
				turistaService.guardarTurista(turistaEncontrado);
				nuevoDetalle.setOtroTurista(turistaEncontrado);
				tpService.guardarTurista_Poi(nuevoDetalle);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		return "redirect:/detallespoi/{codigoPoi}";
	}
	
	
	
	@PostMapping("/valoracion/modificar")
	public String modificarDetalle(@ModelAttribute("unDetalle") Turista_Poi detalleModificado, Model model) {
		try {
			tpService.modificarTurista_Poi(detalleModificado);
			model.addAttribute("unDetalle", new Turista_Poi());
			model.addAttribute("editMode", "false");
			
		} catch (Exception e) {
			model.addAttribute("formUsuarioErrorMessage",e.getMessage());
			model.addAttribute("unDetalle", detalleModificado);
			model.addAttribute("detalles", tpService.obtenerTodosTuristas_Pois());
			model.addAttribute("editMode", "true");
		}
		model.addAttribute("detalles", tpService.obtenerTodosTuristas_Pois());
		return("detallespoi");
	}
	
}
