package br.edu.infnet.apppedido.exceptions;

public class PedidoSemProdutosException extends Exception {

	private static final long serialVersionUID = 1L;

	public PedidoSemProdutosException(String mensagem) {
		super(mensagem);
	}
}
