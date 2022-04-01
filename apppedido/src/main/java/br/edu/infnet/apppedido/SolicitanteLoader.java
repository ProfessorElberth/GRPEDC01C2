package br.edu.infnet.apppedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.apppedido.model.domain.Solicitante;
import br.edu.infnet.apppedido.model.domain.Usuario;
import br.edu.infnet.apppedido.model.service.SolicitanteService;

@Order(2)
@Component
public class SolicitanteLoader implements ApplicationRunner {
	
	@Autowired
	private SolicitanteService solicitanteService;

	@Override
	public void run(ApplicationArguments args) {
		
		try {
			Usuario usuario = new Usuario();
			usuario.setId(1);
	
			Solicitante solicitante = new Solicitante("Elberth", "elberth@elberth", "123.456.789-12");
			solicitante.setUsuario(usuario);
			
			solicitanteService.incluir(solicitante);
		} catch (Exception e) {
			System.out.println("Impossível realizar a inclusão: " + e.getMessage());
		}
	}
}