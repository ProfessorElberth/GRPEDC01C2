package br.edu.infnet.apppedido.model.domain;

import br.edu.infnet.apppedido.exceptions.PesoInvalidoException;
import br.edu.infnet.apppedido.exceptions.ValorInvalidoException;

public class Bebida extends Produto {

	private String marca;
	private boolean importada;
	private boolean gelada;

	public Bebida(String descricao, float valor, float peso) throws ValorInvalidoException, PesoInvalidoException {
		super(descricao, valor, peso);
	}

	@Override
	public float calcularValorVenda() {

		return this.getValor() 
				+ (this.getPeso() * 0.05f)
				+ (importada ? this.getValor()/10 : 0)
				+ (gelada ? this.getValor()/20 : 0);
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(marca);
		sb.append(";");
		sb.append(importada ? "importada" : "nacional");
		sb.append(";");
		sb.append(gelada ? "gelada" : "quente");		

		return sb.toString();
	}

	public String getMarca() {
		return marca;
	}
	public boolean isImportada() {
		return importada;
	}
	public boolean isGelada() {
		return gelada;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public void setImportada(boolean importada) {
		this.importada = importada;
	}
	public void setGelada(boolean gelada) {
		this.gelada = gelada;
	}
}
