package br.edu.infnet.apppedido.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.apppedido.model.domain.Aluno;

@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Integer> {

}
