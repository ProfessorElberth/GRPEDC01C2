package br.edu.infnet.apppedido.model.testes;

import br.edu.infnet.apppedido.exceptions.PesoInvalidoException;
import br.edu.infnet.apppedido.exceptions.ValorInvalidoException;
import br.edu.infnet.apppedido.model.domain.Sobremesa;

public class SobremesaTeste {

	public static void main(String[] args) {

		try {
			Sobremesa chocolate = new Sobremesa("Chocolate", 10, 50);
			chocolate.setCalda(true);
			chocolate.setDiet(false);
			chocolate.setIngrediente("muito chocolate");
			System.out.println("Valor de venda: " + chocolate.calcularValorVenda());		
		} catch (ValorInvalidoException | PesoInvalidoException e) {
			System.out.println(e.getMessage());
		}

		try {
			Sobremesa chocolate = new Sobremesa("Chocolate", 0, 50);
			chocolate.setCalda(true);
			chocolate.setDiet(false);
			chocolate.setIngrediente("muito chocolate");
			System.out.println("Valor de venda: " + chocolate.calcularValorVenda());		
		} catch (ValorInvalidoException | PesoInvalidoException e) {
			System.out.println(e.getMessage());
		}
		try {
			Sobremesa chocolate = new Sobremesa("Chocolate", 10, 0);
			chocolate.setCalda(true);
			chocolate.setDiet(false);
			chocolate.setIngrediente("muito chocolate");
			System.out.println("Valor de venda: " + chocolate.calcularValorVenda());		
		} catch (ValorInvalidoException | PesoInvalidoException e) {
			System.out.println(e.getMessage());
		}
		try {
			Sobremesa chocolate = new Sobremesa("Chocolate", 10, 50);
			chocolate.setCalda(true);
			chocolate.setDiet(false);
			chocolate.setIngrediente("muito chocolate");
			System.out.println("Valor de venda: " + chocolate.calcularValorVenda());		
		} catch (ValorInvalidoException | PesoInvalidoException e) {
			System.out.println(e.getMessage());
		}
		try {
			Sobremesa chocolate = new Sobremesa("Chocolate", -10, 50);
			chocolate.setCalda(true);
			chocolate.setDiet(false);
			chocolate.setIngrediente("muito chocolate");
			System.out.println("Valor de venda: " + chocolate.calcularValorVenda());		
		} catch (ValorInvalidoException | PesoInvalidoException e) {
			System.out.println(e.getMessage());
		}
		try {
			Sobremesa chocolate = new Sobremesa("Chocolate", 10, -50);
			chocolate.setCalda(true);
			chocolate.setDiet(false);
			chocolate.setIngrediente("muito chocolate");
			System.out.println("Valor de venda: " + chocolate.calcularValorVenda());		
		} catch (ValorInvalidoException | PesoInvalidoException e) {
			System.out.println(e.getMessage());
		}
		try {
			Sobremesa chocolate = new Sobremesa("Chocolate", 10, 50);
			chocolate.setCalda(true);
			chocolate.setDiet(false);
			chocolate.setIngrediente("muito chocolate");
			System.out.println("Valor de venda: " + chocolate.calcularValorVenda());		
		} catch (ValorInvalidoException | PesoInvalidoException e) {
			System.out.println(e.getMessage());
		}
	}
}