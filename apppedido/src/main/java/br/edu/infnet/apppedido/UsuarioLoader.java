package br.edu.infnet.apppedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.apppedido.model.domain.Usuario;
import br.edu.infnet.apppedido.model.service.UsuarioService;

@Component
public class UsuarioLoader implements ApplicationRunner {

	@Autowired
	private UsuarioService usuarioService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Usuario usuario = new Usuario();
		usuario.setNome("Elberth Moraes");
		usuario.setEmail("elberth@elberth.com");
		usuario.setSenha("123");
		usuario.setAdmin(true);

		usuarioService.incluir(usuario);
	}
}