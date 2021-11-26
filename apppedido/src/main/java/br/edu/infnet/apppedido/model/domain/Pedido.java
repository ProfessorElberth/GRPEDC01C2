package br.edu.infnet.apppedido.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pedido {

	private String descricao;
	private LocalDateTime data;
	private Solicitante solicitante;
	
	public Pedido() {
		this.descricao = "Pedido padrão da empresa";
		this.data = LocalDateTime.now();
	}
	
	@Override
	public String toString() {
		
		DateTimeFormatter formatacao = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		return String.format("%s;%s;%s", 
				this.descricao,
				this.data.format(formatacao),
				this.solicitante
			);
	}

	public String getDescricao() {
		return descricao;
	}
	public LocalDateTime getData() {
		return data;
	}
	public Solicitante getSolicitante() {
		return solicitante;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setSolicitante(Solicitante solicitante) {
		this.solicitante = solicitante;
	}
}