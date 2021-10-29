package br.edu.infnet.testes;

import br.edu.infnet.dominio.Programador;

public class ProgramadorTeste {

	public static void main(String[] args) {

		Programador prog1 = new Programador();
		prog1.fullStack = true;
		prog1.idade = 10;
		prog1.linguagem = "Java";
		prog1.salario = 5000;
		System.out.println(prog1);
		
		Programador prog2 = new Programador("Manoel", 10);
		prog2.fullStack = true;
		prog2.linguagem = "jAvA";
		prog2.salario = 5000;
		System.out.println(prog2);
		
		Programador prog3 = new Programador("Manoel", 10, 5000, true, "java");
		System.out.println(prog3);
	}
}