package br.edu.infnet.testes;

import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.dominio.Administrativo;
import br.edu.infnet.dominio.Empresa;
import br.edu.infnet.dominio.Estagiario;
import br.edu.infnet.dominio.Funcionario;
import br.edu.infnet.dominio.Programador;
import br.edu.infnet.exceptions.AusenciaFuncionarioException;
import br.edu.infnet.exceptions.FaturamentoNegativoException;
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
		
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		funcionarios.add(a1);
		funcionarios.add(a2);
		funcionarios.add(est1);
		funcionarios.add(p1);
		funcionarios.add(p2);

		try {
			Empresa emp1 = new Empresa();			
			emp1.setNome("Instituto INFNET java");
			emp1.setFaturamento(-100);
			emp1.setFuncionarios(funcionarios);
			emp1.impressao();
		} catch (NomeIncompletoException | FaturamentoNegativoException | AusenciaFuncionarioException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("------------");
		
		try {
			Empresa emp3 = new Empresa();
			emp3.setNome("Professor");
			emp3.setFaturamento(-300);
			emp3.impressao();
		} catch (NomeIncompletoException | FaturamentoNegativoException | AusenciaFuncionarioException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("------------");

		try {
			Empresa emp2 = new Empresa();
			emp2.setNome("Elberth moraes");
			emp2.setFaturamento(200);
			emp2.setFuncionarios(funcionarios);
			emp2.impressao();
		} catch (NomeIncompletoException | FaturamentoNegativoException | AusenciaFuncionarioException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("------------");
	}
}