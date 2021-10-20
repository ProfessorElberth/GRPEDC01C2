package br.edu.infnet.testes;

import java.util.Scanner;

public class Segundo {
	
	private static String[] nomes;
	private static int[] idades;
	private static float[] salarios;
	
	private static final int QTDE_MAX = 5;
	
	private static void impressao(){
		System.out.println("---- Relat�rio de Funcion�rios ----");
		for (int j = 0; j < QTDE_MAX; j++) {
			if(nomes[j] != null) {
				System.out.println("Funcion�rio "+ j + " - " + nomes[j] + " - " + idades[j] + " - " + salarios[j]);
			}
		}
		System.out.println("-----------------------------------");
	}
	
	public static void main(String[] args){
		
		nomes = new String[QTDE_MAX];
		idades = new int[QTDE_MAX];
		salarios = new float[QTDE_MAX];

		int qtde = 0;
		
		Scanner in = new Scanner(System.in);
		
		int opcao = 0;
		
		do {
			System.out.println("[1] Cadastrar");
			System.out.println("[2] Consultar um");
			System.out.println("[3] Consultar todos");
			System.out.println("[4] Sair");
			System.out.print("Informe a op��o desejada: ");
			opcao = in.nextInt();

			switch (opcao) {
			case 1:
				if(qtde < QTDE_MAX) {
					System.out.print("Informe o seu nome: ");
					nomes[qtde] = in.next();
					
					System.out.print("Informe a sua idade: ");
					idades[qtde] = in.nextInt();
					
					System.out.print("Informe o seu salario: ");
					salarios[qtde] = in.nextFloat();
					
					System.out.println("Funcion�rio "+ qtde + " - " + nomes[qtde] + " - " + idades[qtde] + " - " + salarios[qtde]);

					qtde++;
				} else {
					System.out.println("Imposs�vel realizar o cadastramento!!!");
				}
				break;

			case 2:
				System.out.println("Informe o c�digo do funcion�rio: ");
				int codigo = in.nextInt();
				
				System.out.println("Funcion�rio "+ codigo + " - " + nomes[codigo] + " - " + idades[codigo] + " - " + salarios[codigo]);
				break;

			case 3:
				impressao();			
				break;

			case 4:
				System.out.println("sair");
				break;

			default:
				System.out.println("Op��o inv�lida!!!");
				break;
			}			
		} while (opcao != 4);
		
		in.close();
		
		System.out.println("Processamento realizado!!!");
	}
}