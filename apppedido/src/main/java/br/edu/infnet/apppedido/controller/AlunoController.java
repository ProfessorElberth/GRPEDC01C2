package br.edu.infnet.apppedido.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.apppedido.model.domain.Aluno;

@Controller
public class AlunoController {

	@GetMapping(value = "/aluno")
	public String telaCadastro() {
		return "aluno/cadastro";
	}
	
	@GetMapping(value = "/alunos")
	public String telaLista() {

		return "aluno/lista";
	}

	@PostMapping(value = "/aluno/incluir")
	public String incluir(Aluno aluno, Model model){
		
		model.addAttribute("mensagem", "O aluno " + aluno.getNome() + " foi incluído com sucesso!!!");

		return telaLista();
	}
}