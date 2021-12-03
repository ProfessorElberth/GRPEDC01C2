package br.edu.infnet.apppedido.model.domain;

import br.edu.infnet.apppedido.exceptions.PesoInvalidoException;
import br.edu.infnet.apppedido.exceptions.ValorInvalidoException;

public abstract class Produto {

	private String descricao;
	private float valor;
	private float peso;
	
	public Produto(String descricao, float valor, float peso) throws ValorInvalidoException, PesoInvalidoException {
		
		if(valor == 0) {
			throw new ValorInvalidoException("Impossível realizar o cadastramento do produto " + descricao+ " com o valor zerado!");
		}
		
		if(valor < 0) {
			throw new ValorInvalidoException("Impossível realizar o cadastramento do produto " + descricao+ " com o valor negativo!");
		}

		if(peso == 0) {
			throw new PesoInvalidoException("Impossível realizar o cadastramento do produto " + descricao+ " com o peso zerado!");
		}

		if(peso < 0) {
			throw new PesoInvalidoException("Impossível realizar o cadastramento do produto " + descricao+ " com o peso negativo!");
		}
		
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
