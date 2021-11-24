package testes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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

public class ArquivoEquipeTeste {

	public static void main(String[] args) {
		
		try {
			
			String arquivo = "equipe.txt";
			
			FileReader fileR = new FileReader(arquivo);
			BufferedReader leitura = new BufferedReader(fileR);
			
			FileWriter fileW = new FileWriter("out_"+arquivo);
			BufferedWriter escrita = new BufferedWriter(fileW);
			
			String linha = leitura.readLine();
			
			String[] campos = null;
			
			List<Profissional> profissionais = new ArrayList<Profissional>();

			Equipe equipe = null;
			
			while(linha != null) {
				campos = linha.split(";");
				
				String tipo = campos[0];
				
				switch (tipo) {
				case "E":				
					Contato contatoEquipe = new Contato();
					contatoEquipe.setEmail(campos[3]);
					contatoEquipe.setTelefone(campos[4]);
					
					equipe = new Equipe();						
					equipe.setAnoFundacao(Integer.valueOf(campos[2]));
					equipe.setContato(contatoEquipe);
					equipe.setNome(campos[1]);
					equipe.setProfissionais(profissionais);
					
					break;
				case "J":				
					try {			
						Jogador j = new Jogador(Integer.valueOf(campos[3]), Integer.valueOf(campos[4]));
						j.setAnoNascimento(Integer.valueOf(campos[2]));
						j.setNome(campos[1]);
						profissionais.add(j);
					} catch (QtdeTituloNegativaException e) {
						System.out.println(e.getMessage());
					}

					break;
				case "D":				
					try {			
						Contato contato = new Contato();
						contato.setEmail(campos[3]);
						contato.setTelefone(campos[4]);
						
						Dirigente d = new Dirigente(Integer.valueOf(campos[2]));
						d.setContato(contato);
						d.setNome(campos[1]);
						d.setPresidente(Boolean.valueOf(campos[5]));
						profissionais.add(d);
					} catch (AnoInicioInvalidoException e) {
						System.out.println(e.getMessage());
					}

					break;
				case "T":				
					try {
						ComissaoTecnica ct = new ComissaoTecnica(Integer.valueOf(campos[3]));
						ct.setNome(campos[1]);
						ct.setTreinador(Boolean.valueOf(campos[2]));			
						profissionais.add(ct);
					} catch (QtdeTituloNegativaException e) {
						System.out.println(e.getMessage());
					}
					break;

				default:
					System.out.println("Tipo inválido: " + tipo);
					break;
				}
				
				linha = leitura.readLine();
			}
			
			try {
				equipe.impressao();
			} catch (ProfissionalInexistenteException e) {
				System.out.println(e.getMessage());
			}
			
			escrita.write(equipe.obterLinhaGravacaoArquivo());
			
			leitura.close();
			escrita.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}