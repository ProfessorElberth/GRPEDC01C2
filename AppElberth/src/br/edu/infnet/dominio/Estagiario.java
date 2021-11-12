package br.edu.infnet.dominio;

import br.edu.infnet.auxiliar.Constante;

public class Estagiario extends Funcionario {

	private String faculdade;
	private int periodo;
	
	public Estagiario() {
		this.setNome("Estag");
		this.periodo = 1;
	}

	public Estagiario(String nome, int idade) {
		super(nome, idade);
	}

	public Estagiario(String nome, int idade, float salario, String faculdade, int periodo) {
		super(nome, idade, salario);
		this.faculdade = faculdade;
		this.periodo = periodo;
	}

	@Override
	public float calcularSalarioLiquido() {
		return super.calcularSalarioLiquido() + periodo * Constante.VALOR_PERIODO;
	}
	
	public String getFaculdade() {
		return faculdade;
	}
	public void setFaculdade(String faculdade) {
		this.faculdade = faculdade;
	}
	public int getPeriodo() {
		return periodo;
	}
	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}
}