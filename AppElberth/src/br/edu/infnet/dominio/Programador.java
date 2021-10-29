package br.edu.infnet.dominio;

import br.edu.infnet.auxiliar.Constante;

public class Programador {

	public String nome;
	public int idade;
	public float salario;
	public boolean fullStack;
	public String linguagem;
	
	public Programador() {
		this.nome = "Javeiro";
	}
	
	public Programador(String nome, int idade) {
		this();
		this.nome = nome;
		this.idade = idade;
	}

	public Programador(String nome, int idade, float salario, boolean fullStack, String linguagem) {
		this(nome, idade);
		this.salario = salario;
		this.fullStack = fullStack;
		this.linguagem = linguagem;
	}

	private float calcularSalarioLiquidoFullStack() {
		return this.fullStack ? 1500 : 500;
	}
	
	private float calcularSalarioLiquidoLinguagem() {
		return "java".equalsIgnoreCase(this.linguagem) ? 2000 : 750;
	}
	
	private float calcularSalarioLiquido(){
		return salario + calcularSalarioLiquidoFullStack() + calcularSalarioLiquidoLinguagem();
	}

	private String obterSituacao(float sl){

		if(sl < Constante.SALARIO_MAX_POBRE) {
			return "pobre";
		} else if (sl >= Constante.SALARIO_MAX_RICO) {
			return "rico";
		} else {
			return "classe média";
		}		
	}

	@Override
	public String toString() {
		
		float salarioLiquido = calcularSalarioLiquido();
		
		return String.format(
				"O programador %s %s %s tem %d anos e ganha R$%.2f :: SL = R$%.2f (%s)!", 
				this.linguagem,
				this.fullStack,
				this.nome,
				this.idade,
				this.salario,
				salarioLiquido,
				obterSituacao(salarioLiquido)
			); 
	}
}