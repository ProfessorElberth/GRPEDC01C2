package br.edu.infnet.apppedido.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.apppedido.model.domain.Solicitante;
import br.edu.infnet.apppedido.model.domain.Usuario;
import br.edu.infnet.apppedido.model.repository.SolicitanteRepository;

@Service
public class SolicitanteService {
	
	@Autowired
	private SolicitanteRepository solicitanteRepository;

	public Collection<Solicitante> obterLista(Usuario usuario){		
		return (Collection<Solicitante>) solicitanteRepository.obterLista(usuario.getId(), Sort.by(Sort.Direction.ASC, "nome"));
	}

	public Collection<Solicitante> obterLista(){		
		return (Collection<Solicitante>) solicitanteRepository.findAll();
	}
	
	public Solicitante incluir(Solicitante solicitante){
		return solicitanteRepository.save(solicitante);
	}
	
	public void excluir(Integer id) {
		solicitanteRepository.deleteById(id);
	}
	
	public Solicitante obterPorId(Integer id) {
		return solicitanteRepository.findById(id).orElse(null);
	}
}