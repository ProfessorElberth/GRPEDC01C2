package br.edu.infnet.exceptions;

public class AusenciaFuncionarioException extends Exception {

	private static final long serialVersionUID = 1L;

	public AusenciaFuncionarioException(String mensagem) {
		super(mensagem);
	}
}
