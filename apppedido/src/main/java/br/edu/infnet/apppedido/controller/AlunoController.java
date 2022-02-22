package br.edu.infnet.apppedido.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.apppedido.model.domain.Aluno;
import br.edu.infnet.apppedido.model.service.AlunoService;

@Controller
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;

	@GetMapping(value = "/aluno")
	public String telaCadastro() {
		return "aluno/cadastro";
	}
	
	@GetMapping(value = "/alunos")
	public String telaLista(Model model) {

		model.addAttribute("alunoLista", alunoService.obterLista());

		return "aluno/lista";
	}

	@PostMapping(value = "/aluno/incluir")
	public String incluir(Aluno aluno, Model model){

		alunoService.incluir(aluno);
		
		model.addAttribute("mensagem", "O aluno " + aluno.getNome() + " foi incluído com sucesso!!!");
		
		return telaLista(model);
	}
}