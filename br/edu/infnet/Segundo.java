package br.edu.infnet;

import java.util.Scanner;

public class Segundo {
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		int qtde = Integer.valueOf(args[0]);
		
		for(int i = 0;i < qtde;i++){
			System.out.print("Informe o seu nome: ");
			String nome = in.next();
			
			System.out.print("Informe a sua idade: ");
			int idade = in.nextInt();
			
			System.out.print("Informe o seu salario: ");
			float salario = in.nextFloat();
			
			System.out.println(i + " - " + nome + " - " + idade + " - " + salario);
		}		
		
		in.close();
	}
}

//		int a = 0;
//		while(a < qtde){
//			System.out.println(a + " Instituto Infnet - while");
//			a++;
//		}
		
//		int b = 0;
//		do{
//			System.out.println(b + " Instituto Infnet - dowhile");
//			b++;
//		}while(b < qtde);