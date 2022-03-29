package br.edu.infnet.apppedido.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.edu.infnet.apppedido.exceptions.PedidoSemProdutosException;
import br.edu.infnet.apppedido.exceptions.SolicitanteInexistenteException;

@Entity
@Table(name = "TPedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	private LocalDateTime data;
	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "idSolicitante")	
	private Solicitante solicitante;
	@ManyToMany(cascade = CascadeType.DETACH)
	private List<Produto> produtos;
	@ManyToOne
	@JoinColumn(name = "idusuario")
	private Usuario usuario;
	
	public Pedido() {
		this.descricao = "Pedido padrão da empresa";
		this.data = LocalDateTime.now();
	}
	
	public Pedido(Solicitante solicitante) throws SolicitanteInexistenteException {
		this();
		
		if(solicitante == null) {
			throw new SolicitanteInexistenteException("Impossível realizar o pedido sem um solicitante associado!");
		}
		
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

	public Integer getId() {
		return id;
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

	public void setId(Integer id) {
		this.id = id;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public void setSolicitante(Solicitante solicitante) {
		this.solicitante = solicitante;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}