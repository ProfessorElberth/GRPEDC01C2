package br.edu.infnet.model.repository;

import br.edu.infnet.model.domain.Usuario;

public class AcessoRepository {

	public static Usuario validar(String email, String senha){
		
		if(email.equalsIgnoreCase(senha)) {
			Usuario usuario = new Usuario();
			usuario.setEmail(email);
			usuario.setSenha(senha);
			
			return usuario;
		}
		
		return null;
	}
}