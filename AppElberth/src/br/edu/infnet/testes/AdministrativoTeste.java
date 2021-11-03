package br.edu.infnet.testes;

import br.edu.infnet.dominio.Administrativo;

public class AdministrativoTeste {

	public static void main(String[] args) {
				
		Administrativo a1 = new Administrativo("joao", 22);
		a1.setBonus(200);
		a1.setDesconto(30);
		a1.setSalario(1000);
		a1.impressao();
		
		Administrativo a2 = new Administrativo();
		a2.setBonus(300);
		a2.setDesconto(40);
		a2.setIdade(33);
		a2.setNome("maria");
		a2.setSalario(2000);
		a2.impressao();

		Administrativo a3 = new Administrativo("pedrinho", 44, 3000, 400, 50);
		a3.impressao();
	}
}