package br.edu.infnet.testes;

import br.edu.infnet.dominio.Programador;

public class ProgramadorTeste {

	public static void main(String[] args) {

		Programador p1 = new Programador();
		p1.setFullStack(true);
		p1.setIdade(10);
		p1.setLinguagem("Java");
		p1.setSalario(5000);
		p1.impressao();
		
		Programador p2 = new Programador("Manoel", 10);
		p2.setFullStack(true);
		p2.setLinguagem("jAvA");
		p2.setSalario(5000);
		p2.impressao();
		
		Programador p3 = new Programador("Manoel", 10, 5000, true, "java");
		p3.impressao();
	}
}