package testes;

import dominio.Contato;

public class ContatoTeste {

	public static void main(String[] args) {		
		Contato contato = new Contato();
		contato.setEmail("elberth@elberth.com");
		contato.setTelefone("12 34567890");
		System.out.println(contato);
	}
}
