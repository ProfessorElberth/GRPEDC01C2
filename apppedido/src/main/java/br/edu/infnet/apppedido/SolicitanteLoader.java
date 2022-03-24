package br.edu.infnet.apppedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.apppedido.model.domain.Solicitante;
import br.edu.infnet.apppedido.model.service.SolicitanteService;

@Component
public class SolicitanteLoader implements ApplicationRunner {
	
	@Autowired
	private SolicitanteService solicitanteService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Solicitante solicitante = new Solicitante("Elberth", "elberth@elberth", "123.456.789-12");

		solicitanteService.incluir(solicitante);
	}
}