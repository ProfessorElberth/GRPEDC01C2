package br.edu.infnet.model.domain;

public class Usuario {

	private String nome;
	private String email;
	private String senha;
	
	public Usuario() {
		this.nome = "Elberth Moraes";
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
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}