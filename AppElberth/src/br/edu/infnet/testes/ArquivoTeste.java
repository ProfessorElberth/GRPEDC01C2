package br.edu.infnet.testes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import br.edu.infnet.dominio.Administrativo;
import br.edu.infnet.dominio.Estagiario;
import br.edu.infnet.dominio.Programador;

public class ArquivoTeste {

	public static void main(String[] args) {
		
		String dir = "C:/dev/";
		String arq = "nomes.txt";
		
		try {
			try {
				FileReader fileR = new FileReader(dir+arq);
				FileWriter fileW = new FileWriter(dir+"out_"+arq);
				
				BufferedReader leitura = new BufferedReader(fileR);
				BufferedWriter escrita = new BufferedWriter(fileW);
				
				String[] campos = null;
				
				int qtde = 0;
				float somaSalarial = 0;
				
				String linha = leitura.readLine();
				while(linha != null) {
					
					campos = linha.split(";");
										
					switch (campos[0].toUpperCase()) {
					case "A":
						Administrativo adm = new Administrativo();
						adm.setNome(campos[1]);
						adm.setIdade(Integer.valueOf(campos[2]));
						adm.setSalario(Float.valueOf(campos[3]));
						adm.setBonus(Float.valueOf(campos[4]));
						adm.setDesconto(Float.valueOf(campos[5]));
						adm.impressao();
						
						escrita.write(adm.obterStringSalarioPorFuncionario());
						
						somaSalarial = somaSalarial + adm.calcularSalarioLiquido();						
						qtde++;

						break;

					case "E":
						Estagiario est = new Estagiario();			
						est.setNome(campos[1]);
						est.setIdade(Integer.valueOf(campos[2]));						
						est.setSalario(Float.valueOf(campos[3]));						
						est.setFaculdade(campos[4]);
						est.setPeriodo(Integer.valueOf(campos[5]));
						est.impressao();
						
						escrita.write(est.obterStringSalarioPorFuncionario());

						somaSalarial = somaSalarial + est.calcularSalarioLiquido();						
						qtde++;
						
						break;

					case "P":
						Programador prog = new Programador();		
						prog.setNome(campos[1]);
						prog.setIdade(Integer.valueOf(campos[2]));
						prog.setSalario(Float.valueOf(campos[3]));
						prog.setFullStack(Boolean.valueOf(campos[4]));
						prog.setLinguagem(campos[5]);
						prog.impressao();
						
						escrita.write(prog.obterStringSalarioPorFuncionario());
						
						somaSalarial = somaSalarial + prog.calcularSalarioLiquido();						
						qtde++;
						
						break;

					default:
						System.out.println("#Funcionário inválido: "+Arrays.toString(campos)+"!!!");
						break;
					}

					linha = leitura.readLine();
				}
				
				escrita.write(qtde+";"+somaSalarial+"\r\n");
				
				//TODO Implementar este método
				//escrita.write(Funcionario.obterRodape());
				
				leitura.close();
				escrita.close();

			} catch (IOException e) {
				System.out.println(e.getMessage());
			}						
			
		} finally {
			System.out.println("O processamento foi realizado!!!");
		}		
	}
}