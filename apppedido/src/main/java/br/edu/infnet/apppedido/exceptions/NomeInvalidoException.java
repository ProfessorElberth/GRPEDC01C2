package br.edu.infnet.apppedido.exceptions;

public class NomeInvalidoException extends Exception {

	private static final long serialVersionUID = 1L;

	public NomeInvalidoException(String mensagem) {
		super(mensagem);
	}
}
