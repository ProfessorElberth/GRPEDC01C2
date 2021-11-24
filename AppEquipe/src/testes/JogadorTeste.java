package testes;

import dominio.Jogador;
import exceptions.QtdeTituloNegativaException;

public class JogadorTeste {

	public static void main(String[] args) {
		try {			
			Jogador jogador = new Jogador(8,2);
			jogador.setAnoNascimento(1978);
			jogador.setNome("Elberth Moraes");
			jogador.impressao();
		} catch (QtdeTituloNegativaException e) {
			System.out.println(e.getMessage());
		}
	}
}
