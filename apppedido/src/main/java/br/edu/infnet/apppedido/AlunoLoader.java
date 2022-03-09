package br.edu.infnet.apppedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.apppedido.model.domain.Aluno;
import br.edu.infnet.apppedido.model.service.AlunoService;

@Component
public class AlunoLoader implements ApplicationRunner {
	
	@Autowired
	private AlunoService alunoService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		String[] disciplinas = {"java", "web", "poo"};
		
		Aluno aluno = new Aluno("Elberth L C Moraes", "elberth@elberth.com");
		aluno.setIdade(43);
		aluno.setMensalidade(999);
		aluno.setCurso("Computacao");
		aluno.setDisciplinas(disciplinas);
		aluno.setRegiao("Su");
//		aluno.setUsuario(usuario);
		
		alunoService.incluir(aluno);
	}
}