package br.edu.infnet.testes;

public class Funcionario {

	String nome;
	int idade;
	float salario;
	float bonus;
	float desconto;

	private final float SALARIO_MAX = 100000;

	Funcionario(){
		this.nome = "Fantasma";
	}
	
	Funcionario(String nome, int idade){
		this();
		this.nome = nome;
		this.idade = idade;
	}

	Funcionario(String nome, int idade, float salario, float bonus, float desconto) {
		this(nome, idade);
		this.salario = salario;
		this.bonus = bonus;
		this.desconto = desconto;
	}

	private float calcularSalarioLiquido(){
		return salario + bonus - desconto;
	}
	
	private String obterSituacao(float sl){
		return sl > SALARIO_MAX ? "rico" : "pobre";
	}
	
	void impressao() {
		float salarioLiquido = calcularSalarioLiquido();
		
		String situacao = obterSituacao(salarioLiquido);
		
		System.out.println(this);
		System.out.println("Idade: " + idade);
		System.out.println("Salário: " + salario);
		System.out.println("Bônus: " + bonus);
		System.out.println("Desconto: " + desconto);
		System.out.println("Salário Líquido: " + salarioLiquido);
		System.out.println("Situação: " + situacao);
	}

	@Override
	public String toString() {
		return "- Nome: " + nome;
	}
}