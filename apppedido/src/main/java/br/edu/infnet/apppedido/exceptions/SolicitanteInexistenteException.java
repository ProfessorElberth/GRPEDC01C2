package br.edu.infnet.apppedido.exceptions;

public class SolicitanteInexistenteException extends Exception {

	private static final long serialVersionUID = 1L;

	public SolicitanteInexistenteException(String mensagem) {
		super(mensagem);
	}
}
