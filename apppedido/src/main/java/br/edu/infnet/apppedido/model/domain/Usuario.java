package br.edu.infnet.apppedido.model.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TUsuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String email;
	private String senha;
	private boolean admin;
	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name = "idusuario")
	private List<Solicitante> solicitantes;
	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name = "idusuario")
	private List<Produto> produtos;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idendereco")	
	private Endereco endereco;
	
	public Usuario() {
		this.nome = "Elberth Moraes";
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public boolean isAdmin() {
		return admin;
	}

	public List<Solicitante> getSolicitantes() {
		return solicitantes;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public void setSolicitantes(List<Solicitante> solicitantes) {
		this.solicitantes = solicitantes;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}