package ar.edu.unju.edm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeController {


	@GetMapping({"/","/login","/home", "/index","/login?error=true"})
	public String cargarHome(Model model){	
	return "home";
	}


}