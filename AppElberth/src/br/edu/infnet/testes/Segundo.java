package br.edu.infnet.testes;

import java.util.Scanner;

import br.edu.infnet.auxiliar.Constante;

public class Segundo {
	
	private static String[] nomes;
	private static int[] idades;
	private static float[] salarios;
	private static float[] bonus;
	private static float[] descontos;
	
	private static int qtde = 0;

	private static void impressao(){
		System.out.println("---- Relat?rio de Funcion?rios ----");
		for (int j = 0; j < qtde; j++) {
			impressao(j);
		}
		System.out.println("-----------------------------------");
	}
	
	private static float calcularSalarioLiquido(int idx){
		return salarios[idx] + bonus[idx] - descontos[idx];
	}
	
	private static String obterSituacao(float sl){
		
		return sl > Constante.SALARIO_MAX_RICO ? "rico" : "pobre";
	}
	
	private static void impressao(int index){
		float salarioLiquido = calcularSalarioLiquido(index);
		
		String situacao = obterSituacao(salarioLiquido);		

		System.out.println(
				index + " - " + 
				nomes[index] + " - " + 
				idades[index] + " - " + 
				salarios[index] + " :: " +
				salarioLiquido + " - " +
				situacao
				);
	}
	
	public static void main(String[] args){
		
		nomes = new String[Constante.QTDE_MAX];
		idades = new int[Constante.QTDE_MAX];
		salarios = new float[Constante.QTDE_MAX];
		bonus = new float[Constante.QTDE_MAX];
		descontos = new float[Constante.QTDE_MAX];

		int opcao = 0;
		
		Scanner in = new Scanner(System.in);

		do {
			System.out.println("[1] Cadastrar");
			System.out.println("[2] Consultar um");
			System.out.println("[3] Consultar todos");
			System.out.println("[4] Sair");
			System.out.print("Informe a op??o desejada: ");
			opcao = in.nextInt();

			switch (opcao) {
			case 1:
				if(qtde < Constante.QTDE_MAX) {
					System.out.print("Informe o seu nome: ");
					nomes[qtde] = in.next();
					
					System.out.print("Informe a sua idade: ");
					idades[qtde] = in.nextInt();
					
					System.out.print("Informe o seu salario: ");
					salarios[qtde] = in.nextFloat();
					
					System.out.print("Informe o seu b?nus: ");
					bonus[qtde] = in.nextFloat();

					System.out.print("Informe o seu desconto: ");
					descontos[qtde] = in.nextFloat();

					impressao(qtde);
					
					qtde++;
				} else {
					System.out.println("Imposs?vel realizar o cadastramento!!!");
				}
				break;

			case 2:
				System.out.println("Informe o c?digo do funcion?rio: ");
				int codigo = in.nextInt();

				if(codigo >= 0 && codigo < qtde) {
					impressao(codigo);
				} else {
					System.out.println("O c?digo " + codigo + " ? inv?lido!!");
				}				
				break;

			case 3:
				impressao();			
				break;

			case 4:
				System.out.println("sair");
				break;

			default:
				System.out.println("Op??o inv?lida!!!");
				break;
			}			
		} while (opcao != 4);
		
		in.close();
		
		System.out.println("Processamento realizado!!!");
	}
}