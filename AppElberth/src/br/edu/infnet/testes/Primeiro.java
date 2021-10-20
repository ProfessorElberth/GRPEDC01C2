package br.edu.infnet.testes;

public class Primeiro {
	
	private static String nome;
	private static String sobrenome;
	private static int idade;
	private static float salario;
	private static boolean ehJava;
	private static int qtdeMeses;	
	
	private static boolean validar(int qtde){		
		if(qtde == 6){
			return true;
		}	
		return false;
	}
	
	private static int definirAnoNascimento(int aIdade){
		return 2021 - aIdade;
	}
	
	private static float calcularValorTotal(float salarioMensal, int meses){
		return salarioMensal * meses;
	}

	private static String definirStatus(int aIdade){
		if(aIdade <= 50){
			return "iniciante";
		}		
		return "veterano";
	}
	
	private static String definirSituacao(float oSalario){
		if(oSalario > 1000){
			return "estavel";
		}		
		return "instavel";			
	}
	
	private static void tratarParametros(String[] parametros){
		nome = parametros[0];
		sobrenome = parametros[1];
		idade = Integer.valueOf(parametros[2]);
		salario = Float.valueOf(parametros[3]);
		ehJava = Boolean.valueOf(parametros[4]);
		qtdeMeses = Integer.valueOf(parametros[5]);
	}
	
	private static void impressao(){
		System.out.println("Nome: " + nome);
		System.out.println("Sobrenome: " + sobrenome);
		System.out.println("Idade: " + idade);
		System.out.println("Ano de nascimento: " + definirAnoNascimento(idade));
		System.out.println("Salario: " + salario);
		System.out.println("Valor total: " + calcularValorTotal(salario, qtdeMeses));
		System.out.println("Java dev: " + ehJava);		
		System.out.println("Status: " + definirStatus(idade));
		System.out.println("Situacao: " + definirSituacao(salario));
	}
	
	public static void main(String[] args){

		if(validar(args.length)){

			tratarParametros(args);

			impressao();
		} else {
			System.out.println("A quantidade " + args.length + " de argumentos esta incorreta!!!");
		}
	}
}