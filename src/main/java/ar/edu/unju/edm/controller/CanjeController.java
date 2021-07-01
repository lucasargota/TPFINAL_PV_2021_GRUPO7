package ar.edu.unju.edm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.edu.unju.edm.model.Turista;
import ar.edu.unju.edm.service.ITuristaService;

@Controller
public class CanjeController {

	@Autowired
	@Qualifier("implementacion2mysql")
	ITuristaService turistaService;

	// Get
	@GetMapping("/canjes")
	public String canjesPuntos(Model model, Authentication authentication) throws Exception {
		UserDetails userTurista = (UserDetails) authentication.getPrincipal();
		model.addAttribute("unTurista", turistaService.encontrarPorEmail(userTurista.getUsername()));
		return ("canjes");
	}

	@GetMapping("/canjear/canjear10")
	public String canjear10(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userTurista = (UserDetails) auth.getPrincipal();

		try {
			Turista turistaEncontrado = turistaService.encontrarPorEmail(userTurista.getUsername());
			if (turistaEncontrado != null) {
				if (turistaEncontrado.getPuntos() >= 50) {
					model.addAttribute("negativo", "false");
					turistaEncontrado.setPuntos(turistaEncontrado.getPuntos() - 50);
					turistaService.guardarTurista(turistaEncontrado);

				} else {
					return "insuficientes";
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
		return "canjeado";

	}

	@GetMapping("/canjear/canjear20")
	public String canjear20(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userTurista = (UserDetails) auth.getPrincipal();

		try {
			Turista turistaEncontrado = turistaService.encontrarPorEmail(userTurista.getUsername());
			if (turistaEncontrado != null) {
				if (turistaEncontrado.getPuntos() >= 600) {
					model.addAttribute("negativo", "false");
					turistaEncontrado.setPuntos(turistaEncontrado.getPuntos() - 600);
					turistaService.guardarTurista(turistaEncontrado);

				} else {
					return "insuficientes";
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
		return "canjeado";

	}

	@GetMapping("/canjear/canjear30")
	public String canjear30(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userTurista = (UserDetails) auth.getPrincipal();

		try {
			Turista turistaEncontrado = turistaService.encontrarPorEmail(userTurista.getUsername());
			if (turistaEncontrado != null) {
				if (turistaEncontrado.getPuntos() >= 350) {
					model.addAttribute("negativo", "false");
					turistaEncontrado.setPuntos(turistaEncontrado.getPuntos() - 350);
					turistaService.guardarTurista(turistaEncontrado);

				} else {
					return "insuficientes";
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
		return "canjeado";

	}
}
