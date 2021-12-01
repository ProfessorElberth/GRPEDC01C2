package br.edu.infnet.apppedido.model.testes;

import br.edu.infnet.apppedido.model.domain.Comida;

public class ComidaTeste {

	public static void main(String[] args) {
		
		Comida pizza = new Comida("Pizza", 50, 700);
		pizza.setAcompanhamento("Docinho do vovó");
		pizza.setQtdeServido(4);
		pizza.setVegana(false);
		System.out.println("Valor de venda: " + pizza.calcularValorVenda());
	}
}
