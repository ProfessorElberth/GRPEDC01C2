package br.edu.infnet.model.test;

import java.util.List;

import br.edu.infnet.model.domain.Aluno;
import br.edu.infnet.model.repository.AlunoRepository;

public class AlunoTeste {

	public static void main(String[] args) {
		
		String[] disciplinas = {"java", "uml", "jdbc"};

		Aluno aluno = new Aluno("joao", "joao@joao.com");
		aluno.setIdade(43);
		aluno.setMensalidade(1000);
		aluno.setCurso("computação");
		aluno.setDisciplinas(disciplinas);
		aluno.setRegiao("S");		
		
		AlunoRepository.incluir(aluno);
		
		System.out.println("Inclusão realizada com sucesso!!!");
		
		List<Aluno> colecaoAluno = AlunoRepository.obterLista();
		
		for(Aluno a: colecaoAluno) {
			System.out.println("- " + a);
		}
		
		System.out.println("Processamento finalizado com sucesso!!!");
	}
}
