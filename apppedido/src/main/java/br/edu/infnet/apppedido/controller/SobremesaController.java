package br.edu.infnet.apppedido.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.apppedido.model.domain.Sobremesa;
import br.edu.infnet.apppedido.model.service.ProdutoService;
import br.edu.infnet.apppedido.model.service.SobremesaService;

@Controller
public class SobremesaController {
	
	@Autowired
	private SobremesaService sobremesaService;
	@Autowired
	private ProdutoService produtoService;

	@GetMapping(value = "/sobremesas")
	public String telaLista(Model model) {

		model.addAttribute("sobremesaLista", sobremesaService.obterLista());
		
		return "sobremesa/lista";
	}

	@GetMapping(value = "/sobremesa")
	public String telaCadastro() {
		return "sobremesa/cadastro";
	}

	@PostMapping(value = "/sobremesa/incluir")
	public String incluir(Sobremesa sobremesa) {

		produtoService.incluir(sobremesa);
		
		return "redirect:/sobremesas";
	}

	@GetMapping(value = "/sobremesa/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		produtoService.excluir(id);
		
		return "redirect:/sobremesas";
	}
}