package br.edu.infnet.apppedido.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.apppedido.model.domain.Pedido;
import br.edu.infnet.apppedido.model.domain.Produto;
import br.edu.infnet.apppedido.model.domain.Usuario;
import br.edu.infnet.apppedido.model.service.PedidoService;
import br.edu.infnet.apppedido.model.service.ProdutoService;
import br.edu.infnet.apppedido.model.service.SolicitanteService;

@Controller
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	@Autowired
	private SolicitanteService solicitanteService;
	@Autowired
	private ProdutoService produtoService;

	@GetMapping(value = "/pedido")
	public String telaCadastro(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("solicitanteLista", solicitanteService.obterLista(usuario));
		
		model.addAttribute("produtoLista", produtoService.obterLista(usuario));

		return "pedido/cadastro";
	}
	
	@GetMapping(value = "/pedidos")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("pedidoLista", pedidoService.obterLista(usuario));

		return "pedido/lista";
	}

	@PostMapping(value = "/pedido/incluir")
	public String incluir(@RequestParam String[] idsProdutos, Pedido pedido, Model model, @SessionAttribute("user") Usuario usuario){
		
		List<Produto> produtos = new ArrayList<Produto>();
		
		for(String idProduto : idsProdutos) {
			
			Produto produto = produtoService.obterPorId(Integer.valueOf(idProduto));
			
			produtos.add(produto);
		}
		
		pedido.setUsuario(usuario);
		
		pedido.setProdutos(produtos);

		pedidoService.incluir(pedido);

		model.addAttribute("mensagem", "O pedido " + pedido.getDescricao() + " foi incluído com sucesso!!!");
		
		return telaLista(model, usuario);
	}

	@GetMapping(value = "/pedido/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {
		
		Pedido pedido = pedidoService.obterPorId(id);
				
		if(pedido != null) {			
			pedidoService.excluir(id);			
			model.addAttribute("mensagem", "O pedido "+pedido.getDescricao()+" foi excluído com sucesso!!!");
		} else {
			model.addAttribute("mensagem", "Pedido inexistente.. impossível realizar a exclusão!!!");			
		}
		
		return telaLista(model, usuario);
	}
}