package br.edu.infnet.testes;

import br.edu.infnet.dominio.Administrativo;
import br.edu.infnet.dominio.Empresa;
import br.edu.infnet.dominio.Estagiario;
import br.edu.infnet.dominio.Funcionario;
import br.edu.infnet.dominio.Programador;
import br.edu.infnet.exceptions.NomeIncompletoException;

public class EmpresaTeste {

	public static void main(String[] args) {
		
		Administrativo a1 = new Administrativo("joao", 22);
		a1.setBonus(200);
		a1.setDesconto(30);
		a1.setSalario(1000);
		
		Administrativo a2 = new Administrativo();
		a2.setBonus(300);
		a2.setDesconto(40);
		a2.setIdade(33);
		a2.setNome("maria");
		a2.setSalario(2000);

		Estagiario est1 = new Estagiario();
		est1.setFaculdade("Infnet");
		est1.setIdade(20);
		est1.setSalario(2000);

		Programador p1 = new Programador();
		p1.setFullStack(true);
		p1.setIdade(10);
		p1.setLinguagem("Java");
		p1.setSalario(5000);
		
		Programador p2 = new Programador("Manoel", 10);
		p2.setFullStack(true);
		p2.setLinguagem("jAvA");
		p2.setSalario(5000);
		
		Funcionario[] listaFuncionario = new Funcionario[10];
		listaFuncionario[0] = a1;
		listaFuncionario[1] = a2;
		listaFuncionario[2] = est1;
		listaFuncionario[3] = p1;
		listaFuncionario[4] = p2;

		try {
			Empresa emp1 = new Empresa();
			emp1.setNome("Instituto INFNET java");
			emp1.setFuncionarios(listaFuncionario);
			emp1.impressao();
		} catch (NomeIncompletoException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("------------");
		
		try {
			Empresa emp3 = new Empresa();
			emp3.setNome("Professor");
			emp3.impressao();
		} catch (NomeIncompletoException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("------------");

		try {
			Empresa emp2 = new Empresa();
			emp2.setNome("Elberth moraes");
			emp2.impressao();
		} catch (NomeIncompletoException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("------------");
	}
}