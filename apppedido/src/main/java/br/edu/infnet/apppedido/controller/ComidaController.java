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
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("comidaLista", comidaService.obterLista(usuario));
		
		return "comida/lista";
	}

	@GetMapping(value = "/comida")
	public String telaCadastro() {
		return "comida/cadastro";
	}

	@PostMapping(value = "/comida/incluir")
	public String incluir(Model model, Comida comida, @SessionAttribute("user") Usuario usuario) {
		
		comida.setUsuario(usuario);

		produtoService.incluir(comida);
		
		model.addAttribute("mensagem", "A comida " + comida.getDescricao() + " foi incluída com sucesso!!!");

		return telaLista(model, usuario);
	}

	@GetMapping(value = "/comida/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

		Comida comida = (Comida) produtoService.obterPorId(id);
		
		if(comida != null) {
			try {
				produtoService.excluir(id);				
				model.addAttribute("mensagem", "A comida "+comida.getDescricao()+" foi excluída com sucesso!!!");
			} catch (Exception e) {
				model.addAttribute("mensagem", "Impossível realizar a exclusão! A comida "+comida.getDescricao()+" está associada a um pedido!!!");
			}
		} else {
			model.addAttribute("mensagem", "Comida inexistente.. impossível realizar a exclusão!!!");			
		}
		
		return telaLista(model, usuario);
	}
}