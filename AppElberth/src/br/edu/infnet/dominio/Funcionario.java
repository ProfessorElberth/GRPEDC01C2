package br.edu.infnet.dominio;

import br.edu.infnet.auxiliar.Constante;

public class Funcionario {

	public String nome;
	public int idade;
	public float salario;
	public float bonus;
	public float desconto;

	public Funcionario(){
		this.nome = "Fantasma";
	}
	
	public Funcionario(String nome, int idade){
		this();
		this.nome = nome;
		this.idade = idade;
	}

	public Funcionario(String nome, int idade, float salario, float bonus, float desconto) {
		this(nome, idade);
		this.salario = salario;
		this.bonus = bonus;
		this.desconto = desconto;
	}

	private float calcularSalarioLiquido(){
		return salario + bonus - desconto;
	}
	
	private String obterSituacao(float sl){
		
		return sl > Constante.SALARIO_MAX_RICO ? "rico" : "pobre";
	}
	
	public void impressao() {
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