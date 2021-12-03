package br.edu.infnet.apppedido.model.testes;

import br.edu.infnet.apppedido.exceptions.PesoInvalidoException;
import br.edu.infnet.apppedido.exceptions.QuantidadeServidoNegativaException;
import br.edu.infnet.apppedido.exceptions.ValorInvalidoException;
import br.edu.infnet.apppedido.model.domain.Comida;

public class ComidaTeste {

	public static void main(String[] args) {
				
		try {
			Comida pizza = new Comida("Pizza", 50, 700);
			pizza.setAcompanhamento("Docinho do vovó");
			pizza.setQtdeServido(4);
			pizza.setVegana(false);
			System.out.println("Valor de venda: " + pizza.calcularValorVenda());
		} catch (QuantidadeServidoNegativaException | ValorInvalidoException | PesoInvalidoException e) {
			System.out.println(e.getMessage());
		}

		try {
			Comida pizza = new Comida("Pizza", 0, 700);
			pizza.setAcompanhamento("Docinho do vovó");
			pizza.setQtdeServido(4);
			pizza.setVegana(false);
			System.out.println("Valor de venda: " + pizza.calcularValorVenda());
		} catch (ValorInvalidoException | PesoInvalidoException e) {
			System.out.println(e.getMessage());
		} catch (QuantidadeServidoNegativaException e) {
			System.out.println(e.getMessage());
		}

		try {
			Comida pizza = new Comida("Pizza", 50, 0);
			pizza.setAcompanhamento("Docinho do vovó");
			pizza.setQtdeServido(4);
			pizza.setVegana(false);
			System.out.println("Valor de venda: " + pizza.calcularValorVenda());
		} catch (ValorInvalidoException e) {
			System.out.println(e.getMessage());
		} catch (PesoInvalidoException e) {
			System.out.println(e.getMessage());
		} catch (QuantidadeServidoNegativaException e) {
			System.out.println(e.getMessage());
		}

		try {
			Comida pizza = new Comida("Pizza", 50, 700);
			pizza.setAcompanhamento("Docinho do vovó");
			pizza.setQtdeServido(4);
			pizza.setVegana(false);
			System.out.println("Valor de venda: " + pizza.calcularValorVenda());
		} catch (QuantidadeServidoNegativaException | ValorInvalidoException | PesoInvalidoException e) {
			System.out.println(e.getMessage());
		}

		try {
			Comida pizza = new Comida("Pizza", -50, 700);
			pizza.setAcompanhamento("Docinho do vovó");
			pizza.setQtdeServido(4);
			pizza.setVegana(false);
			System.out.println("Valor de venda: " + pizza.calcularValorVenda());
		} catch (QuantidadeServidoNegativaException | ValorInvalidoException | PesoInvalidoException e) {
			System.out.println(e.getMessage());
		}

		try {
			Comida pizza = new Comida("Pizza", 50, -700);
			pizza.setAcompanhamento("Docinho do vovó");
			pizza.setQtdeServido(4);
			pizza.setVegana(false);
			System.out.println("Valor de venda: " + pizza.calcularValorVenda());
		} catch (QuantidadeServidoNegativaException | ValorInvalidoException | PesoInvalidoException e) {
			System.out.println(e.getMessage());
		}

		try {
			Comida pizza = new Comida("Pizza", 50, 700);
			pizza.setAcompanhamento("Docinho do vovó");
			pizza.setQtdeServido(4);
			pizza.setVegana(false);
			System.out.println("Valor de venda: " + pizza.calcularValorVenda());
		} catch (QuantidadeServidoNegativaException | ValorInvalidoException | PesoInvalidoException e) {
			System.out.println(e.getMessage());
		}
	}
}
