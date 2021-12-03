package br.edu.infnet.apppedido.model.testes;

import br.edu.infnet.apppedido.exceptions.PesoInvalidoException;
import br.edu.infnet.apppedido.exceptions.ValorInvalidoException;
import br.edu.infnet.apppedido.model.domain.Bebida;

public class BebidaTeste {

	public static void main(String[] args) {

		try {
			Bebida vinho = new Bebida("Vinho", 100, 350);
			vinho.setMarca("Genericão");
			System.out.println("Valor de venda: " + vinho.calcularValorVenda());
		} catch (ValorInvalidoException | PesoInvalidoException e) {
			System.out.println(e.getMessage());
		}

		try {
			Bebida vinho = new Bebida("Vinho", 100, 350);
			vinho.setGelada(false);
			vinho.setImportada(true);
			vinho.setMarca("Genericão");
			System.out.println("Valor de venda: " + vinho.calcularValorVenda());
		} catch (ValorInvalidoException | PesoInvalidoException e) {
			System.out.println(e.getMessage());
		}

		try {
			Bebida vinho = new Bebida("Vinho", 0, 350);
			vinho.setGelada(false);
			vinho.setImportada(true);
			vinho.setMarca("Genericão");
			System.out.println("Valor de venda: " + vinho.calcularValorVenda());
		} catch (ValorInvalidoException | PesoInvalidoException e) {
			System.out.println(e.getMessage());
		}

		try {
			Bebida vinho = new Bebida("Vinho", 100, 350);
			vinho.setGelada(false);
			vinho.setImportada(true);
			vinho.setMarca("Genericão");
			System.out.println("Valor de venda: " + vinho.calcularValorVenda());
		} catch (ValorInvalidoException | PesoInvalidoException e) {
			System.out.println(e.getMessage());
		}

		try {
			Bebida vinho = new Bebida("Vinho", 100, 0);
			vinho.setGelada(false);
			vinho.setImportada(true);
			vinho.setMarca("Genericão");
			System.out.println("Valor de venda: " + vinho.calcularValorVenda());
		} catch (ValorInvalidoException | PesoInvalidoException e) {
			System.out.println(e.getMessage());
		}

		try {
			Bebida vinho = new Bebida("Vinho", 100, 350);
			vinho.setGelada(false);
			vinho.setImportada(true);
			vinho.setMarca("Genericão");
			System.out.println("Valor de venda: " + vinho.calcularValorVenda());
		} catch (ValorInvalidoException | PesoInvalidoException e) {
			System.out.println(e.getMessage());
		}

		try {
			Bebida vinho = new Bebida("Vinho", -100, 350);
			vinho.setGelada(false);
			vinho.setImportada(true);
			vinho.setMarca("Genericão");
			System.out.println("Valor de venda: " + vinho.calcularValorVenda());
		} catch (ValorInvalidoException | PesoInvalidoException e) {
			System.out.println(e.getMessage());
		}

		try {
			Bebida vinho = new Bebida("Vinho", 100, 350);
			vinho.setGelada(false);
			vinho.setImportada(true);
			vinho.setMarca("Genericão");
			System.out.println("Valor de venda: " + vinho.calcularValorVenda());
		} catch (ValorInvalidoException | PesoInvalidoException e) {
			System.out.println(e.getMessage());
		}

		try {
			Bebida vinho = new Bebida("Vinho", 100, -100);
			vinho.setGelada(false);
			vinho.setImportada(true);
			vinho.setMarca("Genericão");
			System.out.println("Valor de venda: " + vinho.calcularValorVenda());
		} catch (ValorInvalidoException | PesoInvalidoException e) {
			System.out.println(e.getMessage());
		}
	}
}
