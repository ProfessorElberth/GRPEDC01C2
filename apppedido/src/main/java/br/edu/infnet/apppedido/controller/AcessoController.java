package br.edu.infnet.apppedido.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AcessoController {

	@GetMapping(value = "/home")
	public String telaHome() {
		return "home";		
	}

	@GetMapping(value = "/")
	public String telaLogin() {
		return "login";		
	}
	
	@PostMapping(value = "/login")
	public String validar(Model model, @RequestParam String email, @RequestParam String senha){

		if(email.equalsIgnoreCase(senha)) {
			return "redirect:/home";
		} else {
			model.addAttribute(
					"mensagem", 
					"As credenciais do usuário estão incorretas!!!"
				);

			return telaLogin();
		}	

	}
}