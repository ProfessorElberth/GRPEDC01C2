package br.edu.infnet.apppedido.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.apppedido.model.domain.Produto;
import br.edu.infnet.apppedido.model.domain.Usuario;
import br.edu.infnet.apppedido.model.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public void incluir(Produto produto) {
		produtoRepository.save(produto);
	}

	public void excluir(Integer id) {
		produtoRepository.deleteById(id);
	}

	public Produto obterPorId(Integer id) {
		return produtoRepository.findById(id).orElse(null);
	}

	public Collection<Produto> obterLista(Usuario usuario) {
		return (Collection<Produto>) produtoRepository.findAll(usuario.getId(), Sort.by(Sort.Direction.ASC, "descricao")); 
	}	

	public Collection<Produto> obterLista() {
		return (Collection<Produto>) produtoRepository.findAll(Sort.by(Sort.Direction.ASC, "descricao")); 
	}	

	public Integer obterQtde(){
		return (int) produtoRepository.count();
	}
}