package testes;

import java.util.ArrayList;
import java.util.List;

import dominio.ComissaoTecnica;
import dominio.Contato;
import dominio.Dirigente;
import dominio.Equipe;
import dominio.Jogador;
import dominio.Profissional;
import exceptions.AnoInicioInvalidoException;
import exceptions.ProfissionalInexistenteException;
import exceptions.QtdeTituloNegativaException;

public class EquipeTeste {

	public static void main(String[] args) {
		
		List<Profissional> profissionais = new ArrayList<Profissional>();

		//comissão
		try {
			ComissaoTecnica ct1 = new ComissaoTecnica(5);
			ct1.setNome("Professor Elberth");
			ct1.setTreinador(true);			
			profissionais.add(ct1);
		} catch (QtdeTituloNegativaException e) {
			System.out.println(e.getMessage());
		}

		try {
			ComissaoTecnica ct2 = new ComissaoTecnica(2);
			ct2.setNome("Preparador Elberth");
			ct2.setTreinador(false);
			profissionais.add(ct2);
		} catch (QtdeTituloNegativaException e) {
			System.out.println(e.getMessage());
		}
		
		//dirigente
		try {			
			Contato contatoPresi = new Contato();
			contatoPresi.setEmail("elberth@elberth.com");
			contatoPresi.setTelefone("12 34567890");
			
			Dirigente presi = new Dirigente(1998);
			presi.setContato(contatoPresi);
			presi.setNome("Presidente Elberth");
			presi.setPresidente(true);
			profissionais.add(presi);
		} catch (AnoInicioInvalidoException e) {
			System.out.println(e.getMessage());
		}
		
		//jogador
		try {			
			Jogador j1 = new Jogador(8,10);
			j1.setAnoNascimento(2000);
			j1.setNome("Gabi Moraes");
			profissionais.add(j1);
		} catch (QtdeTituloNegativaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Jogador j2 = new Jogador(10,12);
			j2.setAnoNascimento(2000);
			j2.setNome("Moraes BH");			
			profissionais.add(j2);
		} catch (QtdeTituloNegativaException e) {
			System.out.println(e.getMessage());
		}

		try {			
			Jogador j3 = new Jogador(4,15);
			j3.setAnoNascimento(2000);
			j3.setNome("Arrraassca Elberth");
			profissionais.add(j3);
		} catch (QtdeTituloNegativaException e) {
			System.out.println(e.getMessage());
		}
				
		try {
			Contato contatoEquipe = new Contato();
			contatoEquipe.setEmail("elberth@fc.com");
			contatoEquipe.setTelefone("21 987654321");
			
			Equipe equipe = new Equipe();
			equipe.setAnoFundacao(2000);
			equipe.setContato(contatoEquipe);
			equipe.setNome("Elberth FC");
			equipe.setProfissionais(profissionais);
			equipe.impressao();
		} catch (ProfissionalInexistenteException e) {
			System.out.println(e.getMessage());
		}
	}
}
