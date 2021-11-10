package br.edu.infnet.testes;

public class StringTeste {

	public static void main(String[] args) {

		String nome = new String("Elberth Lins Costa de Moraes");
		
		System.out.println("Nome: " + nome);
		
		System.out.println("Primeira letra do sobrenome: " + nome.charAt(8));

		String nomeUp = nome.toUpperCase();

		System.out.println("Nome UP: " + nomeUp);

		String nomeLow = nome.toLowerCase();

		System.out.println("Nome LOW: " + nomeLow);
		
		if(nome.equalsIgnoreCase(nomeUp)) {
			System.out.println("IGUAL");
		} else {
			System.out.println("DIFERENTE");
		}
		
		System.out.println("Posição da primeira letra 'e': " + nome.indexOf("e"));
		
		System.out.println("Posição da última letra 'e': " + nome.lastIndexOf("e"));
		
		int posicaoM = nome.lastIndexOf("M");
		
		System.out.println("Posição da primeira letra 'M': " + posicaoM);

		System.out.println("Exibição do Moraes: " + nome.substring(posicaoM, posicaoM+3));
		
		int posPriEspaco = nome.indexOf(" ");
		int posUltEspaco = nome.lastIndexOf(" ");
		System.out.println("Posições: " + posPriEspaco + " :: " + posUltEspaco);
		
		String nomeMeio = nome.substring(posPriEspaco, posUltEspaco).trim();
		
		System.out.println("Exibição do nome do meio: [" + nomeMeio +"]");
	}
}