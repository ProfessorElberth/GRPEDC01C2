public class Primeiro {
	
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
	
	public static void main(String[] args){
				
		if(validar(args.length)){

			String nome = args[0];
			String sobrenome = args[1];
			int idade = Integer.valueOf(args[2]);
			float salario = Float.valueOf(args[3]);
			boolean ehJava = Boolean.valueOf(args[4]);
			int qtdeMeses = Integer.valueOf(args[5]);

			int anoNascimento = definirAnoNascimento(idade);
			
			float valorTotal = calcularValorTotal(salario, qtdeMeses);
			
			String status = definirStatus(idade);
			
			String situacao = definirSituacao(salario);

			System.out.println("Nome: " + nome);
			System.out.println("Sobrenome: " + sobrenome);
			System.out.println("Idade: " + idade);
			System.out.println("Ano de nascimento: " + anoNascimento);
			System.out.println("Salario: " + salario);
			System.out.println("Valor total: " + valorTotal);
			System.out.println("Java dev: " + ehJava);		
			System.out.println("Status: " + status);
			System.out.println("Situacao: " + situacao);
		} else {
			System.out.println("A quantidade " + args.length + " de argumentos esta incorreta!!!");
		}
	}
}