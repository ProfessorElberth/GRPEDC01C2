package br.edu.infnet.apppedido;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.apppedido.model.domain.Pedido;
import br.edu.infnet.apppedido.model.domain.Produto;
import br.edu.infnet.apppedido.model.domain.Solicitante;
import br.edu.infnet.apppedido.model.domain.Usuario;
import br.edu.infnet.apppedido.model.service.PedidoService;
import br.edu.infnet.apppedido.model.service.ProdutoService;

@Order(4)
@Component
public class PedidoLoader implements ApplicationRunner {
	
	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private PedidoService pedidoService;

	@Override
	public void run(ApplicationArguments args) {
		try {
			List<Produto> produtos = new ArrayList<Produto>(
						produtoService.obterLista()
					);
	
			Solicitante solicitante = new Solicitante();
			solicitante.setId(1);
			
			Usuario usuario = new Usuario();
			usuario.setId(1);
	
			Pedido pedido = new Pedido(solicitante);
			pedido.setDescricao("Pedido do professor elberth");
			pedido.setProdutos(produtos);
			pedido.setUsuario(usuario);
			
			pedidoService.incluir(pedido);
		} catch (Exception e) {
			System.out.println("Impossível realizar a inclusão: " + e.getMessage());
		}
	}
}