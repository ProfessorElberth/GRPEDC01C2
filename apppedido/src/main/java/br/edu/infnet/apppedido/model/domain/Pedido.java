package br.edu.infnet.apppedido.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.edu.infnet.apppedido.exceptions.PedidoSemProdutosException;
import br.edu.infnet.apppedido.exceptions.SolicitanteInexistenteException;

public class Pedido {

	private String descricao;
	private LocalDateTime data;
	private Solicitante solicitante;
	private List<Produto> produtos;
	
	public Pedido(Solicitante solicitante) throws SolicitanteInexistenteException {
		
		if(solicitante == null) {
			throw new SolicitanteInexistenteException("Impossível realizar o pedido sem um solicitante associado!");
		}
		
		this.descricao = "Pedido padrão da empresa";
		this.data = LocalDateTime.now();
		this.solicitante = solicitante;
	}
	
	public float calcularValorTotalPedido() {
		
		float valorTotal = 0;
		
		for(Produto prod : produtos) {
			valorTotal = valorTotal + prod.calcularValorVenda();
		}
		
		return valorTotal;
	}
	
	public String obterLinhaGravacaoArquivo() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(descricao);
		sb.append(";");
		sb.append(solicitante.getNome());
		sb.append(";");
		sb.append(produtos.size());
		sb.append(";");
		sb.append(calcularValorTotalPedido());
		sb.append("\r\n");
		
		return sb.toString();
	}

	public void impressao() throws PedidoSemProdutosException {
		
		if(produtos == null) {
			throw new PedidoSemProdutosException("Não existem produtos associados!!!");
		}
		
		if(produtos.size() == 0) {
			throw new PedidoSemProdutosException("Não existem produtos associados!!!");
		}

		System.out.println("Relatório de Pedido:");
		System.out.println(this);
		System.out.println("#Produtos");
		for(Produto p : produtos) {
			System.out.println("- " + p);
		}
	}
	
	@Override
	public String toString() {
		
		int qtdeProdutos = produtos != null ? produtos.size() : 0;

		DateTimeFormatter formatacao = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		return String.format("%s;%s;%s;%d", 
				this.descricao,
				this.data.format(formatacao),
				this.solicitante,
				qtdeProdutos
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
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

}