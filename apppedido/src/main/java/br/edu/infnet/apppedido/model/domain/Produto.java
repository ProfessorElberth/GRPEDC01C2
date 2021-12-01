package br.edu.infnet.apppedido.model.domain;

public abstract class Produto {

	private String descricao;
	private float valor;
	private float peso;
	
	public Produto(String descricao, float valor, float peso) {
		this.descricao = descricao;
		this.valor = valor;
		this.peso = peso;
	}
	
	public abstract float calcularValorVenda();
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(descricao);
		sb.append(";");
		sb.append(valor);
		sb.append(";");
		sb.append(peso);
		sb.append(";");
		sb.append(this.calcularValorVenda());
		
		return sb.toString();
	}

	public String getDescricao() {
		return descricao;
	}
	public float getValor() {
		return valor;
	}
	public float getPeso() {
		return peso;
	}
}
