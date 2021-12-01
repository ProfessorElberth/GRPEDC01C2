package br.edu.infnet.apppedido.model.domain;

public class Comida extends Produto {
	
	private String acompanhamento;
	private boolean vegana;
	private int qtdeServido;

	public Comida(String descricao, float valor, float peso) {
		super(descricao, valor, peso);
	}

	@Override
	public float calcularValorVenda() {
	
		return this.getValor() 
				+ (this.getPeso() * 0.05f)
				+ (vegana ? this.getValor()/10 : 0)
				+ (qtdeServido * this.getValor()/20);
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(acompanhamento);
		sb.append(";");
		sb.append(vegana);
		sb.append(";");
		sb.append(qtdeServido);
		
		return sb.toString();
	}

	public String getAcompanhamento() {
		return acompanhamento;
	}

	public boolean isVegana() {
		return vegana;
	}

	public int getQtdeServido() {
		return qtdeServido;
	}

	public void setAcompanhamento(String acompanhamento) {
		this.acompanhamento = acompanhamento;
	}

	public void setVegana(boolean vegana) {
		this.vegana = vegana;
	}

	public void setQtdeServido(int qtdeServido) {
		this.qtdeServido = qtdeServido;
	}
}