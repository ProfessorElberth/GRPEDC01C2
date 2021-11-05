package br.edu.infnet.dominio;

public class Programador extends Funcionario {

	private boolean fullStack;
	private String linguagem;
	
	public Programador() {
		this.setNome("Javeiro");
	}
	
	public Programador(String nome, int idade) {
		super(nome, idade);
	}

	public Programador(String nome, int idade, float salario, boolean fullStack, String linguagem) {
		super(nome, idade, salario);
		this.fullStack = fullStack;
		this.linguagem = linguagem;
	}

	private float calcularSalarioLiquidoFullStack() {
		return this.fullStack ? 1500 : 500;
	}
	
	private float calcularSalarioLiquidoLinguagem() {
		return "java".equalsIgnoreCase(this.linguagem) ? 2000 : 750;
	}

	@Override
	protected float calcularSalarioLiquido() {
		return super.calcularSalarioLiquido() + 
				calcularSalarioLiquidoFullStack() + 
				calcularSalarioLiquidoLinguagem();
	}
	
	@Override
	public void impressao() {
		super.impressao();
		System.out.println("Fullstack: " + fullStack);
		System.out.println("Linguagem: " + linguagem);
	}

	public boolean isFullStack() {
		return fullStack;
	}

	public void setFullStack(boolean fullStack) {
		this.fullStack = fullStack;
	}

	public String getLinguagem() {
		return linguagem;
	}

	public void setLinguagem(String linguagem) {
		this.linguagem = linguagem;
	}
}