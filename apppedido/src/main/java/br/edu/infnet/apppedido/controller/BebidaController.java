package br.edu.infnet.apppedido.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.apppedido.model.domain.Bebida;
import br.edu.infnet.apppedido.model.domain.Usuario;
import br.edu.infnet.apppedido.model.service.BebidaService;
import br.edu.infnet.apppedido.model.service.ProdutoService;

@Controller
public class BebidaController {
	
	@Autowired
	private BebidaService bebidaService;
	@Autowired
	private ProdutoService produtoService;

	@GetMapping(value = "/bebidas")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("bebidaLista", bebidaService.obterLista(usuario));
		
		return "bebida/lista";
	}

	@GetMapping(value = "/bebida")
	public String telaCadastro() {
		return "bebida/cadastro";
	}

	@PostMapping(value = "/bebida/incluir")
	public String incluir(Model model, Bebida bebida, @SessionAttribute("user") Usuario usuario) {
		
		bebida.setUsuario(usuario);

		produtoService.incluir(bebida);
		
		model.addAttribute("mensagem", "A bebida " + bebida.getDescricao() + " foi incluída com sucesso!!!");

		return telaLista(model, usuario);
	}

	@GetMapping(value = "/bebida/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

		Bebida bebida = (Bebida) produtoService.obterPorId(id);
		
		if(bebida != null) {
			try {
				produtoService.excluir(id);				
				model.addAttribute("mensagem", "A bebida "+bebida.getDescricao()+" foi excluída com sucesso!!!");
			} catch (Exception e) {
				model.addAttribute("mensagem", "Impossível realizar a exclusão! A bebida "+bebida.getDescricao()+" está associada a um pedido!!!");
			}
		} else {
			model.addAttribute("mensagem", "Bebida inexistente.. impossível realizar a exclusão!!!");			
		}
		
		return telaLista(model, usuario);
	}
}