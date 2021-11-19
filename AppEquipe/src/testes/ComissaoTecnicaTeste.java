package testes;

import dominio.ComissaoTecnica;

public class ComissaoTecnicaTeste {

	public static void main(String[] args) {
		ComissaoTecnica ct1 = new ComissaoTecnica();
		ct1.setNome("Professor Elberth");
		ct1.setQtdeTitulo(5);
		ct1.setTreinador(true);		
		System.out.println(ct1);

		ComissaoTecnica ct2 = new ComissaoTecnica();
		ct2.setNome("Professor Elberth");
		ct2.setQtdeTitulo(5);
		ct2.setTreinador(false);
		System.out.println(ct2);
	}
}
