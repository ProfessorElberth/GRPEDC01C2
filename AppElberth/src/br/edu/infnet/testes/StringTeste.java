package br.edu.infnet.testes;

public class StringTeste {

	public static void main(String[] args) {

		String nome = new String("Elberth de Lins Costa de Moraes Teste");
		
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
		
		System.out.println("Posi��o da primeira letra 'e': " + nome.indexOf("e"));
		
		System.out.println("Posi��o da �ltima letra 'e': " + nome.lastIndexOf("e"));
		
		int posicaoM = nome.lastIndexOf("M");
		
		System.out.println("Posi��o da primeira letra 'M': " + posicaoM);

		System.out.println("Exibi��o do Mor: " + nome.substring(posicaoM, posicaoM+6));
		System.out.println("Exibi��o do Moraes: " + nome.substring(posicaoM));
		
		int posPriEspaco = nome.indexOf(" ");
		int posUltEspaco = nome.lastIndexOf(" ");
		System.out.println("Posi��es: " + posPriEspaco + " :: " + posUltEspaco);
		
		String nomeMeio = nome.substring(posPriEspaco, posUltEspaco).trim();
		
		System.out.println("Exibi��o do nome do meio: [" + nomeMeio +"]");
	}
}