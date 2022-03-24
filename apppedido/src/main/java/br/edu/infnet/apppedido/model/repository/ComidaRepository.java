package br.edu.infnet.apppedido.model.repository;

import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.apppedido.model.domain.Comida;

@Repository
public interface ComidaRepository extends CrudRepository<Comida, Integer> {

	@Query("from Comida c where c.usuario.id = :idUsuario")
	Collection<Comida> findAll(Integer idUsuario, Sort by);
}