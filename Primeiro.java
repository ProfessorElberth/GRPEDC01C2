public class Primeiro {

	public static void main(String[] args){
				
		if(args.length == 6){

			String nome = args[0];
			String sobrenome = args[1];
			int idade = Integer.valueOf(args[2]);
			float salario = Float.valueOf(args[3]);
			boolean ehJava = Boolean.valueOf(args[4]);
			int qtdeMeses = Integer.valueOf(args[5]);

			int anoNascimento = 2021 - idade;
			float valorTotal = salario * qtdeMeses;

			System.out.println("Nome: " + nome);
			System.out.println("Sobrenome: " + sobrenome);
			System.out.println("Idade: " + idade);
			System.out.println("Ano de nascimento: " + anoNascimento);
			System.out.println("Salario: " + salario);
			System.out.println("Valor total: " + valorTotal);
			System.out.println("Java dev: " + ehJava);		
		} else {
			System.out.println("A quantidade " + args.length + " de argumentos esta incorreta!!!");
		}
	}
}