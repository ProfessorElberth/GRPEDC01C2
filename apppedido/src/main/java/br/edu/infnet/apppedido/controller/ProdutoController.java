package br.edu.infnet.apppedido.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProdutoController {

	@PostMapping(value = "/produto/incluir")
	public String incluir() {//Produto produto
		System.out.println("Inclusão realizada com sucesso!!!");
		
		return "redirect:/";
	}

	@GetMapping(value = "/produto/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		System.out.println("Produto: " + id);
		
		return "redirect:/";
	}
}
