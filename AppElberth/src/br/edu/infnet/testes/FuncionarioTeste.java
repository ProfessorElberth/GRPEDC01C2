package br.edu.infnet.testes;

public class FuncionarioTeste {

	public static void main(String[] args) {
				
		Funcionario f1 = new Funcionario("joao", 22);
		f1.bonus = 200;
		f1.desconto = 30;
		f1.salario = 1000;
		f1.impressao();
		
		Funcionario f2 = new Funcionario();
		f2.bonus = 300;
		f2.desconto = 40;
		f2.idade = 33;
		f2.nome = "maria";
		f2.salario = 2000;
		f2.impressao();

		Funcionario f3 = new Funcionario("pedrinho", 44, 3000, 400, 50);
		f3.impressao();
	}
}