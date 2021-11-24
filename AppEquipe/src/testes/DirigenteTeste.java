package testes;

import dominio.Contato;
import dominio.Dirigente;
import exceptions.AnoInicioInvalidoException;

public class DirigenteTeste {

	public static void main(String[] args) {
		
		try {
			Contato contato = new Contato();
			contato.setEmail("elberth@elberth.com");
			contato.setTelefone("12 34567890");

			Dirigente dirigente = new Dirigente(2022);
			dirigente.setContato(contato);
			dirigente.setNome("Presidente Elberth");
			dirigente.setPresidente(false);
			dirigente.impressao();
		} catch (AnoInicioInvalidoException e) {
			System.out.println(e.getMessage());
		}
	}
}
