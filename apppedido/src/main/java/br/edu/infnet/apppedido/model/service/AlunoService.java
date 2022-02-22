package br.edu.infnet.apppedido.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.apppedido.model.domain.Aluno;

@Service
public class AlunoService {
	
	private static Map<Integer, Aluno> mapaAlunos = new HashMap<Integer, Aluno>();
	
	private static Integer id = 0;

	public Collection<Aluno> obterLista(){
		
		return mapaAlunos.values();
	}
	
	public void incluir(Aluno aluno){
		aluno.setId(++id);
		mapaAlunos.put(aluno.getId(), aluno);
	}
}