package testes;

import dominio.ComissaoTecnica;
import exceptions.QtdeTituloNegativaException;

public class ComissaoTecnicaTeste {

	public static void main(String[] args) {
		try {
			ComissaoTecnica ct1 = new ComissaoTecnica(5);
			ct1.setNome("Professor Elberth");
			ct1.setTreinador(true);	
			ct1.impressao();
		} catch (QtdeTituloNegativaException e) {
			System.out.println(e.getMessage());
		}		

		try {
			ComissaoTecnica ct2 = new ComissaoTecnica(4);
			ct2.setNome("Professor Elberth");
			ct2.setTreinador(false);
			ct2.impressao();
		} catch (QtdeTituloNegativaException e) {
			System.out.println(e.getMessage());
		}
	}
}