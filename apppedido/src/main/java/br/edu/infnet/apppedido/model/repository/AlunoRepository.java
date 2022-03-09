package br.edu.infnet.apppedido.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.apppedido.model.domain.Aluno;

@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Integer> {

	@Query("from Aluno a where a.usuario.id = :idUsuario")
	public List<Aluno> obterLista(Integer idUsuario);
}