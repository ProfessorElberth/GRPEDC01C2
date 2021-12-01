package br.edu.infnet.apppedido.model.testes;

import br.edu.infnet.apppedido.model.domain.Sobremesa;

public class SobremesaTeste {

	public static void main(String[] args) {

		Sobremesa chocolate = new Sobremesa("Chocolate", 10, 50);
		chocolate.setCalda(true);
		chocolate.setDiet(false);
		chocolate.setIngrediente("muito chocolate");
		System.out.println("Valor de venda: " + chocolate.calcularValorVenda());		
	}
}