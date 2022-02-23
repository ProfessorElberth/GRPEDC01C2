package br.edu.infnet.apppedido.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import br.edu.infnet.apppedido.model.domain.Usuario;
import br.edu.infnet.apppedido.model.service.UsuarioService;

@SessionAttributes("user")
@Controller
public class AcessoController {
	
	@Autowired
	private UsuarioService usuarioService;

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
		
		Usuario usuario = usuarioService.autenticacao(email, senha);

		if(usuario != null) {
			model.addAttribute("user", usuario);
			
			return "redirect:/home";
		} else {
			model.addAttribute(
					"mensagem", 
					"As credenciais do usuário "+ email +" estão incorretas!!!"
				);

			return telaLogin();
		}	

	}
}