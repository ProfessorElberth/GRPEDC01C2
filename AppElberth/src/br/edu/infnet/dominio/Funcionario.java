package br.edu.infnet.dominio;

import br.edu.infnet.auxiliar.Constante;

public class Funcionario {

	private String nome;
	private int idade;
	private float salario;
	
	public Funcionario() {		
		this.nome = "Funcion�rio";
		this.idade = 18;
		this.salario = 1045;
	}

	public Funcionario(String nome, int idade){
		this();
		this.nome = nome;
		this.idade = idade;
	}

	public Funcionario(String nome, int idade, float salario){
		this(nome, idade);
		this.salario = salario;
	}
	
	protected float calcularSalarioLiquido(){
		return salario;
	}	

	protected String obterSituacao(float sl){

		if(sl < Constante.SALARIO_MAX_POBRE) {
			return "pobre";
		} else if (sl >= Constante.SALARIO_MAX_RICO) {
			return "rico";
		} else {
			return "classe m�dia";
		}		
	}

	public void impressao(){
		float salarioLiquido = calcularSalarioLiquido();
		
		System.out.println("Nome: " + nome);
		System.out.println("Idade: " + idade);
		System.out.println("Sal�rio: " + salario);
		System.out.println("Sal�rio L�quido: " + salarioLiquido);
		System.out.println("Situa��o: " + obterSituacao(salarioLiquido));		
	}
	
	@Override
	public String toString() {
		return this.nome + " - " + this.idade + " - " + this.salario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}
}