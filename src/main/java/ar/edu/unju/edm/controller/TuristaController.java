package ar.edu.unju.edm.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.edu.unju.edm.service.ITuristaService;

@Controller
public class TuristaController{
	
@Autowired
@Qualifier("implementacionmysql")	
ITuristaService TuristaService;
	
	@GetMapping("/turista/registrar")
	public String cargarTurista(Model model) {
		
		return("turista");
	}

	
	
}
