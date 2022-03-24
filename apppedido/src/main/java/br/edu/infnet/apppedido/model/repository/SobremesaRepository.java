package br.edu.infnet.apppedido.model.repository;

import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.apppedido.model.domain.Sobremesa;

@Repository
public interface SobremesaRepository extends CrudRepository<Sobremesa, Integer> {

	@Query("from Sobremesa s where s.usuario.id = :idUsuario")
	Collection<Sobremesa> findAll(Integer idUsuario, Sort by);
}