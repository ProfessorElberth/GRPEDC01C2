package br.edu.infnet.testes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.exceptions.ArquivoCorrompidoException;

public class ArquivoFuncionarioTeste {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		try {			
			String dir = "c:/dev/";
			String arq = "out_nomes.txt";
	
			try {
				FileReader file = new FileReader(dir+arq);
				BufferedReader leitura = new BufferedReader(file);
				
				String[] campos = null;
				
				List<String> mensagens = new ArrayList<String>();
				
				int qtdeTotal = 0;
				float salarioTotal = 0;
				
				float somatorioSalario = 0;
				
				String linha = leitura.readLine();
				
				while(linha != null) {
					campos = linha.split(";");
					
					try {
						qtdeTotal = Integer.valueOf(campos[0]);
						salarioTotal = Float.valueOf(campos[1]);
					} catch (NumberFormatException e) {
						float salario = Float.valueOf(campos[1]);
						somatorioSalario = somatorioSalario + salario;
						String msg = String.format("O funcionário %s recebe R$%.2f", campos[0], salario);					
						mensagens.add(msg);
					}
					
					linha = leitura.readLine();									
				}
				
				if(mensagens.size() != qtdeTotal || salarioTotal != somatorioSalario) {
					throw new ArquivoCorrompidoException("Arquivo corrompido!!!");
				}
				
				for(String mensagem : mensagens) {
					System.out.println(mensagem);
				}

				leitura.close();
				file.close();				
			} catch (ArquivoCorrompidoException e) {
				System.out.println(e.getMessage());
			} catch (FileNotFoundException e) {
				System.out.println("Arquivo não encontrado!!!");
			} catch (IOException e) {
				System.out.println("Problema na leitura do arquivo!!!");
			}
		} finally {
			System.out.println("Processamento realizado com sucesso!!!");
		}
	}
}