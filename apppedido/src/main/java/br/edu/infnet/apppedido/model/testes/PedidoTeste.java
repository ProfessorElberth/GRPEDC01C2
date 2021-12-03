package br.edu.infnet.apppedido.model.testes;

import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.apppedido.exceptions.CpfInvalidoException;
import br.edu.infnet.apppedido.exceptions.EmailInvalidoException;
import br.edu.infnet.apppedido.exceptions.NomeInvalidoException;
import br.edu.infnet.apppedido.exceptions.PedidoSemProdutosException;
import br.edu.infnet.apppedido.exceptions.PesoInvalidoException;
import br.edu.infnet.apppedido.exceptions.QuantidadeServidoNegativaException;
import br.edu.infnet.apppedido.exceptions.SolicitanteInexistenteException;
import br.edu.infnet.apppedido.exceptions.ValorInvalidoException;
import br.edu.infnet.apppedido.model.domain.Bebida;
import br.edu.infnet.apppedido.model.domain.Comida;
import br.edu.infnet.apppedido.model.domain.Pedido;
import br.edu.infnet.apppedido.model.domain.Produto;
import br.edu.infnet.apppedido.model.domain.Sobremesa;
import br.edu.infnet.apppedido.model.domain.Solicitante;

public class PedidoTeste {

	public static void main(String[] args) {
		
		List<Produto> listagemProduto = new ArrayList<Produto>();

		try {
			Bebida vinho = new Bebida("Vinho", 100, 350);
			vinho.setGelada(false);
			vinho.setImportada(true);
			vinho.setMarca("Genericão");
			
			listagemProduto.add(vinho);
		} catch (ValorInvalidoException | PesoInvalidoException e) {
			System.out.println(e.getMessage());
		}

		try {
			Comida pizza = new Comida("Pizza", 50, 700);
			pizza.setAcompanhamento("Docinho do vovó");
			pizza.setQtdeServido(4);
			pizza.setVegana(false);
			
			listagemProduto.add(pizza);
		} catch (QuantidadeServidoNegativaException | ValorInvalidoException | PesoInvalidoException e) {
			System.out.println(e.getMessage());
		}

		try {
			Sobremesa chocolate = new Sobremesa("Chocolate", 10, 50);
			chocolate.setCalda(true);
			chocolate.setDiet(false);
			chocolate.setIngrediente("muito chocolate");

			listagemProduto.add(chocolate);
		} catch (ValorInvalidoException | PesoInvalidoException e) {
			System.out.println(e.getMessage());
		}

		Solicitante solicitante = null;
		try {
			solicitante = new Solicitante("Elberth", "elberth@elberth.com", "123.345.456-56");
		} catch (NomeInvalidoException | EmailInvalidoException | CpfInvalidoException e) {
			System.out.println(e.getMessage());
		}		

		try {
			Pedido pedido = new Pedido(solicitante);
			pedido.setDescricao("Pedido do professor elberth");
			pedido.setProdutos(listagemProduto);
			
			pedido.impressao();
		} catch (PedidoSemProdutosException | SolicitanteInexistenteException e) {
			System.out.println(e.getMessage());
		}

	}
}