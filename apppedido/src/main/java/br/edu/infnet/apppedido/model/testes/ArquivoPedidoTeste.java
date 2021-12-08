package br.edu.infnet.apppedido.model.testes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.apppedido.exceptions.CpfInvalidoException;
import br.edu.infnet.apppedido.exceptions.EmailInvalidoException;
import br.edu.infnet.apppedido.exceptions.NomeInvalidoException;
import br.edu.infnet.apppedido.exceptions.PedidoSemProdutosException;
import br.edu.infnet.apppedido.exceptions.PesoInvalidoException;
import br.edu.infnet.apppedido.exceptions.QuantidadeServidoNegativaException;
import br.edu.infnet.apppedido.exceptions.SolicitanteInexistenteException;
import br.edu.infnet.apppedido.exceptions.ValorInvalidoException;
import br.edu.infnet.apppedido.model.domain.Bebida;
import br.edu.infnet.apppedido.model.domain.Comida;
import br.edu.infnet.apppedido.model.domain.Pedido;
import br.edu.infnet.apppedido.model.domain.Produto;
import br.edu.infnet.apppedido.model.domain.Sobremesa;
import br.edu.infnet.apppedido.model.domain.Solicitante;

public class ArquivoPedidoTeste {

	public static void main(String[] args) {
		try {
			
			List<String> inconsistencias = new ArrayList<String>();
			
			System.out.println("Início do processamento de pedidos!!!");
			try {
				
				String arquivo = "pedido.txt";
				
				FileReader fileR = new FileReader(arquivo);
				BufferedReader leitura = new BufferedReader(fileR);
				
				FileWriter fileW = new FileWriter("out_"+arquivo);
				BufferedWriter escrita = new BufferedWriter(fileW);
				
				String linha = leitura.readLine();
				
				String[] campos = null;
				
				List<Produto> produtos = new ArrayList<Produto>();
	
				Pedido pedido = null;
				
				while(linha != null) {
					campos = linha.split(";");
					
					String tipo = campos[0];
					
					switch (tipo.toUpperCase()) {
					case "P":
	
						Solicitante solicitante = null;
						try {
							solicitante = new Solicitante(campos[2], campos[3], campos[4]);
						} catch (NomeInvalidoException | EmailInvalidoException | CpfInvalidoException e) {
							System.out.println(e.getMessage());
						}		
	
						try {
							pedido = new Pedido(solicitante);
							pedido.setDescricao(campos[1]);
							pedido.setProdutos(produtos);
							
						} catch (SolicitanteInexistenteException e) {
							System.out.println(e.getMessage());
						}
						
						break;
					case "B":				
						try {
							Bebida vinho = new Bebida(campos[1], Float.valueOf(campos[2]), Float.valueOf(campos[3]));
							vinho.setGelada(Boolean.valueOf(campos[4]));
							vinho.setImportada(Boolean.valueOf(campos[5]));
							vinho.setMarca(campos[6]);
							
							produtos.add(vinho);
						} catch (ValorInvalidoException | PesoInvalidoException e) {
							System.out.println(e.getMessage());
						}
	
						break;
					case "C":				
						try {
							Comida pizza = new Comida(campos[1], Float.valueOf(campos[2]), Float.valueOf(campos[3]));
							pizza.setAcompanhamento(campos[4]);
							pizza.setQtdeServido(Integer.valueOf(campos[5]));
							pizza.setVegana(Boolean.valueOf(campos[6]));
							
							produtos.add(pizza);
						} catch (QuantidadeServidoNegativaException | ValorInvalidoException | PesoInvalidoException e) {
							System.out.println(e.getMessage());
						}
	
						break;
					case "S":				
						try {
							Sobremesa chocolate = new Sobremesa(campos[1], Float.valueOf(campos[2]), Float.valueOf(campos[3]));
							chocolate.setCalda(Boolean.valueOf(campos[4]));
							chocolate.setDiet(Boolean.valueOf(campos[5]));
							chocolate.setIngrediente(campos[6]);
	
							produtos.add(chocolate);
						} catch (ValorInvalidoException | PesoInvalidoException e) {
							System.out.println(e.getMessage());
						}
	
						break;
	
					default:
						inconsistencias.add(linha);
						break;
					}
					
					linha = leitura.readLine();
				}
				
				try {
					pedido.impressao();
	
					escrita.write(pedido.obterLinhaGravacaoArquivo());		
					
					System.out.println("#Quantidade de erros no processamento: " + inconsistencias.size());
					for(String erro : inconsistencias) {
						System.out.println("- " + erro);
					}
				} catch (PedidoSemProdutosException e) {
					System.out.println(e.getMessage());
				}
				
				leitura.close();
				escrita.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} finally {
			System.out.println("Processamento finalizado!!!");
		}
	}
}