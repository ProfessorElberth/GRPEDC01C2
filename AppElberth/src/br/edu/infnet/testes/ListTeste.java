package br.edu.infnet.testes;

import java.util.ArrayList;
import java.util.List;

public class ListTeste {

	public static void main(String[] args) {

		//definição e criação
		String[] nomes = new String[3];
		List<String> listaNome = new ArrayList<String>();
		
		int[] idades = new int[3];
		List<Integer> listaIdade = new ArrayList<Integer>(); 

		//atribuição
		nomes[0] = "Elberth";
		nomes[1] = "Lins";
		nomes[2] = "Moraes";

		listaNome.add("Elberth");
		listaNome.add("Lins");
		listaNome.add("Moraes");

		idades[0] = 10;
		idades[1] = 20;
		idades[2] = 30;
		
		listaIdade.add(10);
		listaIdade.add(20);
		listaIdade.add(30);
		
		//leitura individual
		System.out.println(nomes[2]);
		System.out.println(listaNome.get(2));
		
		System.out.println(idades[2]);
		System.out.println(listaIdade.get(2));
		
		//leitura em lote - for
		for (int i = 0; i < nomes.length; i++) {
			System.out.println(nomes[i]);
			System.out.println(idades[i]);
		}
		for (int i = 0; i < listaNome.size(); i++) {
			System.out.println(listaNome.get(i));
			System.out.println(listaIdade.get(i));
		}

		//leitura em lote - foreach
		for (String nome : nomes) {
			System.out.println(nome);
		}
		for (String nome : listaNome) {
			System.out.println(nome);
		}
		for (int idade : idades) {
			System.out.println(idade);
		}
		for (int idade : listaIdade) {
			System.out.println(idade);
		}

	}
}