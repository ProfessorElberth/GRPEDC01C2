package br.edu.infnet.apppedido.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.apppedido.clients.IEnderecoClient;
import br.edu.infnet.apppedido.model.domain.Endereco;

@Service
public class EnderecoService {
	
	@Autowired
	private IEnderecoClient enderecoClient;

	public Endereco buscarCep(String cep) {
		
		return enderecoClient.buscarCep(cep);
	}
}