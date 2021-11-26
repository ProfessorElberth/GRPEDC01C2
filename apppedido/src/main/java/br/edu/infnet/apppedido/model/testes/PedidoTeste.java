package br.edu.infnet.apppedido.model.testes;

import br.edu.infnet.apppedido.model.domain.Pedido;
import br.edu.infnet.apppedido.model.domain.Solicitante;

public class PedidoTeste {

	public static void main(String[] args) {
		
		Solicitante solicitante = new Solicitante("Elberth", "elberth@elberth", "123.456.789-12");
		
		Pedido pedido = new Pedido();
		pedido.setDescricao("Pedido do professor elberth");
		pedido.setSolicitante(solicitante);
		
		System.out.println(pedido);
	}
}
