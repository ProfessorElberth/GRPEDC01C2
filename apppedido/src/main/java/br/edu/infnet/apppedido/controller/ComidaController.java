package br.edu.infnet.apppedido.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.apppedido.model.domain.Comida;
import br.edu.infnet.apppedido.model.domain.Usuario;
import br.edu.infnet.apppedido.model.service.ComidaService;
import br.edu.infnet.apppedido.model.service.ProdutoService;

@Controller
public class ComidaController {
	
	@Autowired
	private ComidaService comidaService;
	@Autowired
	private ProdutoService produtoService;

	@GetMapping(value = "/comidas")
	public String telaLista(Model model) {

		model.addAttribute("comidaLista", comidaService.obterLista());
		
		return "comida/lista";
	}

	@GetMapping(value = "/comida")
	public String telaCadastro() {
		return "comida/cadastro";
	}

	@PostMapping(value = "/comida/incluir")
	public String incluir(Comida comida, @SessionAttribute("user") Usuario usuario) {
		
		comida.setUsuario(usuario);

		produtoService.incluir(comida);
		
		return "redirect:/comidas";
	}

	@GetMapping(value = "/comida/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		produtoService.excluir(id);
		
		return "redirect:/comidas";
	}
}