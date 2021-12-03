package br.edu.infnet.apppedido.model.domain;

import br.edu.infnet.apppedido.exceptions.CpfInvalidoException;
import br.edu.infnet.apppedido.exceptions.EmailInvalidoException;
import br.edu.infnet.apppedido.exceptions.NomeInvalidoException;

public class Solicitante {

	private String nome;
	private String email;
	private String cpf;

	public Solicitante(String nome, String email, String cpf) throws NomeInvalidoException, EmailInvalidoException, CpfInvalidoException {
		
		if(nome == null) {
			throw new NomeInvalidoException("O nome do solicitante está nulo!!!");
		}
		
		if(email == null) {
			throw new EmailInvalidoException("O e-mail do solicitante " + nome + " está nulo!!!");
		}

		if(cpf == null) {
			throw new CpfInvalidoException("O CPF do solicitante " + nome + " está nulo!!!");
		}

		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(nome);
		sb.append(";");
		sb.append(email);
		sb.append(";");
		sb.append(cpf);
		
		return sb.toString();
	}

	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	public String getCpf() {
		return cpf;
	}	
}