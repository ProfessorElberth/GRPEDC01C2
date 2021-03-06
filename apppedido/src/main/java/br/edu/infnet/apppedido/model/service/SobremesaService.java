package br.edu.infnet.apppedido.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.apppedido.model.domain.Sobremesa;
import br.edu.infnet.apppedido.model.domain.Usuario;
import br.edu.infnet.apppedido.model.repository.SobremesaRepository;

@Service
public class SobremesaService {
	
	@Autowired
	private SobremesaRepository sobremesaRepository;

	public Collection<Sobremesa> obterLista(Usuario usuario) {
		return (Collection<Sobremesa>) sobremesaRepository.findAll(usuario.getId(), Sort.by(Sort.Direction.ASC, "ingrediente")); 
	}		
	public Collection<Sobremesa> obterLista() {
		return (Collection<Sobremesa>) sobremesaRepository.findAll(Sort.by(Sort.Direction.ASC, "ingrediente")); 
	}		
}