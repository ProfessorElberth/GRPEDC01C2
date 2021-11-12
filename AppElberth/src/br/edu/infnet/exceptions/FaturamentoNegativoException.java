package br.edu.infnet.exceptions;

public class FaturamentoNegativoException extends Exception {

	private static final long serialVersionUID = 1L;

	public FaturamentoNegativoException(String mensagem) {
		super(mensagem);
	}
}
