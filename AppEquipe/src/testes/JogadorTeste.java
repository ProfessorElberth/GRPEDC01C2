package testes;

import dominio.Jogador;

public class JogadorTeste {

	public static void main(String[] args) {		
		Jogador jogador = new Jogador();
		jogador.setAnoNascimento(1978);
		jogador.setNome("Elberth Moraes");
		jogador.setQtdeTituloInternacional(2);
		jogador.setQtdeTituloNacional(8);
		System.out.println(jogador);
	}
}
