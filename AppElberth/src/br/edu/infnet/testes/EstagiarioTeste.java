package br.edu.infnet.testes;

import br.edu.infnet.dominio.Estagiario;

public class EstagiarioTeste {

	public static void main(String[] args) {

		Estagiario est1 = new Estagiario();
		est1.setFaculdade("Infnet");
		est1.setIdade(20);
		est1.setSalario(2000);
		est1.impressao();	
		
		Estagiario est2 = new Estagiario("Huguinho", 22);
		est2.setFaculdade("Instituto");
		est2.setPeriodo(2);
		//TODO E se este objeto não possuir um período preenchido?
		est2.setSalario(3000);
		est2.impressao();
		
		Estagiario est3 = new Estagiario("Luizinho", 24, 1000, "Instituto Infnet", 10);
		est3.impressao();
	}
}
