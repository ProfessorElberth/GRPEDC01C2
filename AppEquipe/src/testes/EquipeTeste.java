package testes;

import java.util.ArrayList;
import java.util.List;

import dominio.ComissaoTecnica;
import dominio.Contato;
import dominio.Dirigente;
import dominio.Equipe;
import dominio.Jogador;
import dominio.Profissional;

public class EquipeTeste {

	public static void main(String[] args) {
		
		//comissão
		ComissaoTecnica ct1 = new ComissaoTecnica();
		ct1.setNome("Professor Elberth");
		ct1.setQtdeTitulo(5);
		ct1.setTreinador(true);

		ComissaoTecnica ct2 = new ComissaoTecnica();
		ct2.setNome("Preparador Elberth");
		ct2.setQtdeTitulo(2);
		ct2.setTreinador(false);
		
		//dirigente
		Contato contatoPresi = new Contato();
		contatoPresi.setEmail("elberth@elberth.com");
		contatoPresi.setTelefone("12 34567890");
		
		Dirigente presi = new Dirigente();
		presi.setAnoInicio(1998);
		presi.setContato(contatoPresi);
		presi.setNome("Presidente Elberth");
		presi.setPresidente(true);
		
		//jogador
		Jogador j1 = new Jogador();
		j1.setAnoNascimento(2000);
		j1.setNome("Gabi Moraes");
		j1.setQtdeTituloInternacional(10);
		j1.setQtdeTituloNacional(8);
		
		Jogador j2 = new Jogador();
		j2.setAnoNascimento(2000);
		j2.setNome("Moraes BH");
		j2.setQtdeTituloInternacional(12);
		j2.setQtdeTituloNacional(10);
		
		Jogador j3 = new Jogador();
		j3.setAnoNascimento(2000);
		j3.setNome("Arrraassca Elberth");
		j3.setQtdeTituloInternacional(15);
		j3.setQtdeTituloNacional(4);
		
		List<Profissional> profissionais = new ArrayList<Profissional>();
		profissionais.add(ct1);
		profissionais.add(ct2);
		profissionais.add(presi);
		profissionais.add(j1);
		profissionais.add(j2);
		profissionais.add(j3);
		
		Contato contatoEquipe = new Contato();
		contatoEquipe.setEmail("elberth@fc.com");
		contatoEquipe.setTelefone("21 987654321");
		
		Equipe equipe = new Equipe();
		equipe.setAnoFundacao(2000);
		equipe.setContato(contatoEquipe);
		equipe.setNome("Elberth FC");
		equipe.setProfissionais(profissionais);
		equipe.impressao();
	}
}
