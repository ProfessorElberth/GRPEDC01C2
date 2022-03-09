package br.edu.infnet.apppedido.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.apppedido.model.domain.Usuario;
import br.edu.infnet.apppedido.model.service.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping(value = "/usuario")
	public String telaCadastro() {
		return "usuario/cadastro";
	}
	
	@GetMapping(value = "/usuarios")
	public String telaLista(Model model) {

		model.addAttribute("usuarioLista", usuarioService.obterLista());

		return "usuario/lista";
	}

	@PostMapping(value = "/usuario/incluir")
	public String incluir(Usuario usuario){

		usuarioService.incluir(usuario);

		return "redirect:/";
	}

	@GetMapping(value = "/usuario/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id) {
		
		Usuario usuario = usuarioService.obterPorId(id);

		if(usuario != null) {			
			usuarioService.excluir(id);
			
			model.addAttribute("mensagem", "O usuário "+usuario.getNome()+" foi excluído com sucesso!!!");
		} else {
			model.addAttribute("mensagem", "Usuário inexistente.. impossível realizar a exclusão!!!");			
		}
		
		return telaLista(model);
	}
}