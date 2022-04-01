package br.edu.infnet.apppedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.apppedido.model.domain.Bebida;
import br.edu.infnet.apppedido.model.domain.Comida;
import br.edu.infnet.apppedido.model.domain.Sobremesa;
import br.edu.infnet.apppedido.model.domain.Usuario;
import br.edu.infnet.apppedido.model.service.ProdutoService;

@Order(3)
@Component
public class ProdutoLoader implements ApplicationRunner {

	@Autowired
	private ProdutoService produtoService;

	@Override
	public void run(ApplicationArguments args) {
		try {		
			Usuario usuario = new Usuario();
			usuario.setId(1);
	
			Bebida vinho = new Bebida("Vinho", 100, 350);
			vinho.setGelada(false);
			vinho.setImportada(true);
			vinho.setMarca("Genericão");
			vinho.setUsuario(usuario);
			produtoService.incluir(vinho);
			
			Comida pizza = new Comida("Pizza", 50, 700);
			pizza.setAcompanhamento("Docinho do vovó");
			pizza.setQtdeServido(4);
			pizza.setVegana(false);
			pizza.setUsuario(usuario);
			produtoService.incluir(pizza);
			
			Sobremesa chocolate = new Sobremesa("Chocolate", 10, 50);
			chocolate.setCalda(true);
			chocolate.setDiet(false);
			chocolate.setIngrediente("muito chocolate");
			chocolate.setUsuario(usuario);
			produtoService.incluir(chocolate);
		} catch (Exception e) {
			System.out.println("Impossível realizar a inclusão: " + e.getMessage());
		}
	}
}