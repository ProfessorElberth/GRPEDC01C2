package br.edu.infnet.apppedido.model.testes;

import br.edu.infnet.apppedido.model.domain.Bebida;

public class BebidaTeste {

	public static void main(String[] args) {

		Bebida vinho = new Bebida("Vinho", 100, 350);
		vinho.setGelada(false);
		vinho.setImportada(true);
		vinho.setMarca("Genericão");
		System.out.println("Valor de venda: " + vinho.calcularValorVenda());
	}
}
