package br.edu.infnet.apppedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.apppedido.model.domain.Bebida;
import br.edu.infnet.apppedido.model.domain.Comida;
import br.edu.infnet.apppedido.model.domain.Sobremesa;
import br.edu.infnet.apppedido.model.service.ProdutoService;

@Component
public class ProdutoLoader implements ApplicationRunner {

	@Autowired
	private ProdutoService produtoService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Bebida vinho = new Bebida("Vinho", 100, 350);
		vinho.setGelada(false);
		vinho.setImportada(true);
		vinho.setMarca("Genericão");
		produtoService.incluir(vinho);
		
		Comida pizza = new Comida("Pizza", 50, 700);
		pizza.setAcompanhamento("Docinho do vovó");
		pizza.setQtdeServido(4);
		pizza.setVegana(false);
		produtoService.incluir(pizza);
		
		Sobremesa chocolate = new Sobremesa("Chocolate", 10, 50);
		chocolate.setCalda(true);
		chocolate.setDiet(false);
		chocolate.setIngrediente("muito chocolate");
		produtoService.incluir(chocolate);
	}
}