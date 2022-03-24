package br.edu.infnet.apppedido.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.edu.infnet.apppedido.exceptions.PesoInvalidoException;
import br.edu.infnet.apppedido.exceptions.ValorInvalidoException;

@Entity
@Table(name = "TProduto")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	private float valor;
	private float peso;
	@ManyToOne
	@JoinColumn(name = "idusuario")
	private Usuario usuario;
	
	public Produto() {
		
	}
	
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
		sb.append(id);
		sb.append(";");
		sb.append(descricao);
		sb.append(";");
		sb.append(valor);
		sb.append(";");
		sb.append(peso);
		sb.append(";");
		sb.append(this.calcularValorVenda());
		
		return sb.toString();
	}

	public Integer getId() {
		return id;
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

	public void setId(Integer id) {
		this.id = id;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
