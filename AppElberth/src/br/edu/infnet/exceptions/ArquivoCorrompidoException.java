package br.edu.infnet.exceptions;

public class ArquivoCorrompidoException extends Exception {

	private static final long serialVersionUID = 1L;

	public ArquivoCorrompidoException(String mensagem) {
		super(mensagem);
	}
}