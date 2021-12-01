package br.edu.infnet.apppedido.model.testes;

import br.edu.infnet.apppedido.model.domain.Bebida;
import br.edu.infnet.apppedido.model.domain.Comida;
import br.edu.infnet.apppedido.model.domain.Sobremesa;

public class ProdutoTeste {

	public static void main(String[] args) {

		Bebida vinho = new Bebida("Vinho", 100, 350);
		vinho.setGelada(false);
		vinho.setImportada(true);
		vinho.setMarca("Genericão");
		System.out.println(vinho);

		Comida pizza = new Comida("Pizza", 50, 700);
		pizza.setAcompanhamento("Docinho do vovó");
		pizza.setQtdeServido(4);
		pizza.setVegana(false);
		System.out.println(pizza);

		Sobremesa chocolate = new Sobremesa("Chocolate", 10, 50);
		chocolate.setCalda(true);
		chocolate.setDiet(false);
		chocolate.setIngrediente("muito chocolate");
		System.out.println(chocolate);
	}
}
