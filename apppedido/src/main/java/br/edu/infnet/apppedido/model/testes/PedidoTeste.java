package br.edu.infnet.apppedido.model.testes;

import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.apppedido.model.domain.Bebida;
import br.edu.infnet.apppedido.model.domain.Comida;
import br.edu.infnet.apppedido.model.domain.Pedido;
import br.edu.infnet.apppedido.model.domain.Produto;
import br.edu.infnet.apppedido.model.domain.Sobremesa;
import br.edu.infnet.apppedido.model.domain.Solicitante;

public class PedidoTeste {

	public static void main(String[] args) {
		
		Bebida vinho = new Bebida("Vinho", 100, 350);
		vinho.setGelada(false);
		vinho.setImportada(true);
		vinho.setMarca("Genericão");

		Comida pizza = new Comida("Pizza", 50, 700);
		pizza.setAcompanhamento("Docinho do vovó");
		pizza.setQtdeServido(4);
		pizza.setVegana(false);

		Sobremesa chocolate = new Sobremesa("Chocolate", 10, 50);
		chocolate.setCalda(true);
		chocolate.setDiet(false);
		chocolate.setIngrediente("muito chocolate");

		List<Produto> listagemProduto = new ArrayList<Produto>();
		listagemProduto.add(vinho);
		listagemProduto.add(pizza);
		listagemProduto.add(chocolate);

		Solicitante solicitante = new Solicitante("Elberth", "elberth@elberth", "123.456.789-12");
		
		Pedido pedido = new Pedido();
		pedido.setDescricao("Pedido do professor elberth");
		pedido.setSolicitante(solicitante);
		pedido.setProdutos(listagemProduto);
		
		System.out.println(pedido);
	}
}
