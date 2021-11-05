package br.edu.infnet.testes;

import br.edu.infnet.dominio.Administrativo;
import br.edu.infnet.dominio.Empresa;
import br.edu.infnet.dominio.Estagiario;
import br.edu.infnet.dominio.Funcionario;
import br.edu.infnet.dominio.Programador;

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

		Empresa emp1 = new Empresa();
		emp1.setNome("Instituto Infnet Java");
		emp1.setFuncionarios(listaFuncionario);
		emp1.impressao();
		
		System.out.println("------------");
		
		Empresa emp2 = new Empresa();
		emp2.setNome("Elberth Java Moraes");
		emp2.impressao();
	}
}