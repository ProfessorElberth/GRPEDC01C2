package br.edu.infnet.apppedido.model.testes;

import br.edu.infnet.apppedido.exceptions.CpfInvalidoException;
import br.edu.infnet.apppedido.exceptions.EmailInvalidoException;
import br.edu.infnet.apppedido.exceptions.NomeInvalidoException;
import br.edu.infnet.apppedido.model.domain.Solicitante;

public class SolicitanteTeste {

	public static void main(String[] args) {
		
		try {
			Solicitante solicitante = new Solicitante("Elberth", "elberth@elberth", "123.456.789-12");
			System.out.println(solicitante);
		} catch (NomeInvalidoException | EmailInvalidoException | CpfInvalidoException e) {
			System.out.println(e.getMessage());
		}

		try {
			Solicitante solicitante = new Solicitante(null, "elberth@elberth", "123.456.789-12");
			System.out.println(solicitante);
		} catch (NomeInvalidoException | EmailInvalidoException | CpfInvalidoException e) {
			System.out.println(e.getMessage());
		}

		try {
			Solicitante solicitante = new Solicitante("Elberth", "elberth@elberth", "123.456.789-12");
			System.out.println(solicitante);
		} catch (NomeInvalidoException | EmailInvalidoException | CpfInvalidoException e) {
			System.out.println(e.getMessage());
		}

		try {
			Solicitante solicitante = new Solicitante("Elberth", null, "123.456.789-12");
			System.out.println(solicitante);
		} catch (NomeInvalidoException | EmailInvalidoException | CpfInvalidoException e) {
			System.out.println(e.getMessage());
		}

		try {
			Solicitante solicitante = new Solicitante("Elberth", "elberth@elberth", "123.456.789-12");
			System.out.println(solicitante);
		} catch (NomeInvalidoException | EmailInvalidoException | CpfInvalidoException e) {
			System.out.println(e.getMessage());
		}
		try {
			Solicitante solicitante = new Solicitante("Elberth", "elberth@elberth", null);
			System.out.println(solicitante);
		} catch (NomeInvalidoException | EmailInvalidoException | CpfInvalidoException e) {
			System.out.println(e.getMessage());
		}
	}
}
