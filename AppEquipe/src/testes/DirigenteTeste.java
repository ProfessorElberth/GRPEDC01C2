package testes;

import dominio.Contato;
import dominio.Dirigente;

public class DirigenteTeste {

	public static void main(String[] args) {
		
		Contato contato = new Contato();
		contato.setEmail("elberth@elberth.com");
		contato.setTelefone("12 34567890");
		
		Dirigente dirigente = new Dirigente();
		dirigente.setAnoInicio(2000);
		dirigente.setContato(contato);
		dirigente.setNome("Presidente Elberth");
		dirigente.setPresidente(false);

		System.out.println(dirigente);
	}
}
