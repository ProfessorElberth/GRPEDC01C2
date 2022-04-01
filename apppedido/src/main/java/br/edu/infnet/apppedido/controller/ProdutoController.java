package br.edu.infnet.apppedido.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.apppedido.model.domain.Bebida;
import br.edu.infnet.apppedido.model.domain.Comida;
import br.edu.infnet.apppedido.model.domain.Produto;
import br.edu.infnet.apppedido.model.domain.Usuario;
import br.edu.infnet.apppedido.model.service.ProdutoService;

@Controller
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping(value = "/produtos")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("produtoLista", produtoService.obterLista(usuario));
		
		return "produto/lista";
	}

	@GetMapping(value = "/produto/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

		Produto produto = produtoService.obterPorId(id);
		
		String tipoProduto = obterTipoProduto(produto);
		
		if(produto != null) {
			try {
				produtoService.excluir(id);				
				model.addAttribute("mensagem", "A "+tipoProduto+" "+produto.getDescricao()+" foi excluída com sucesso!!!");
			} catch (Exception e) {
				model.addAttribute("mensagem", "Impossível realizar a exclusão! A "+tipoProduto+" "+produto.getDescricao()+" está associada a um pedido!!!");
			}
		} else {
			model.addAttribute("mensagem", "Produto inexistente.. impossível realizar a exclusão!!!");			
		}
		
		return telaLista(model, usuario);
	}
	
	private String obterTipoProduto(Produto produto) {
		String tipoProduto = null;
		
		if(produto instanceof Bebida) {
			tipoProduto = "bebida";
		}else if (produto instanceof Comida) {
			tipoProduto = "comida";
		}else {
			tipoProduto = "sobremesa";
		}
		
		return tipoProduto;
	}
}