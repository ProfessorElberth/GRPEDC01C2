package br.edu.infnet.apppedido.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.apppedido.model.domain.Sobremesa;
import br.edu.infnet.apppedido.model.domain.Usuario;
import br.edu.infnet.apppedido.model.service.ProdutoService;
import br.edu.infnet.apppedido.model.service.SobremesaService;

@Controller
public class SobremesaController {
	
	@Autowired
	private SobremesaService sobremesaService;
	@Autowired
	private ProdutoService produtoService;

	@GetMapping(value = "/sobremesas")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("sobremesaLista", sobremesaService.obterLista(usuario));
		
		return "sobremesa/lista";
	}

	@GetMapping(value = "/sobremesa")
	public String telaCadastro() {
		return "sobremesa/cadastro";
	}

	@PostMapping(value = "/sobremesa/incluir")
	public String incluir(Model model, Sobremesa sobremesa, @SessionAttribute("user") Usuario usuario) {
		
		sobremesa.setUsuario(usuario);

		produtoService.incluir(sobremesa);
		
		model.addAttribute("mensagem", "A sobremesa " + sobremesa.getDescricao() + " foi incluída com sucesso!!!");

		return telaLista(model, usuario);
	}

	@GetMapping(value = "/sobremesa/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

		Sobremesa sobremesa = (Sobremesa) produtoService.obterPorId(id);
		
		if(sobremesa != null) {
			try {
				produtoService.excluir(id);				
				model.addAttribute("mensagem", "A sobremesa "+sobremesa.getDescricao()+" foi excluída com sucesso!!!");
			} catch (Exception e) {
				model.addAttribute("mensagem", "Impossível realizar a exclusão! A sobremesa "+sobremesa.getDescricao()+" está associada a um pedido!!!");
			}
		} else {
			model.addAttribute("mensagem", "Sobremesa inexistente.. impossível realizar a exclusão!!!");			
		}
		
		return telaLista(model, usuario);
	}
}