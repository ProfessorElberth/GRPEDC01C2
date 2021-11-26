package br.edu.infnet.apppedido.model.testes;

import br.edu.infnet.apppedido.model.domain.Solicitante;

public class SolicitanteTeste {

	public static void main(String[] args) {
		
		Solicitante solicitante = new Solicitante("Elberth", "elberth@elberth", "123.456.789-12");
		System.out.println(solicitante);
	}
}
