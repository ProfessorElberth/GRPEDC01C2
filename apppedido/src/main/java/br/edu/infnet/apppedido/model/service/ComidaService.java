package br.edu.infnet.apppedido.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.apppedido.model.domain.Comida;
import br.edu.infnet.apppedido.model.domain.Usuario;
import br.edu.infnet.apppedido.model.repository.ComidaRepository;

@Service
public class ComidaService {
	
	@Autowired
	private ComidaRepository comidaRepository;

	public Collection<Comida> obterLista(Usuario usuario) {
		return (Collection<Comida>) comidaRepository.findAll(usuario.getId(), Sort.by(Sort.Direction.ASC, "acompanhamento")); 
	}		
	public Collection<Comida> obterLista() {
		return (Collection<Comida>) comidaRepository.findAll(Sort.by(Sort.Direction.ASC, "acompanhamento")); 
	}		
}