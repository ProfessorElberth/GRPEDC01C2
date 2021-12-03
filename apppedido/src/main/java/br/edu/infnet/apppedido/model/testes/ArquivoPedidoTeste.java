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
						solicitante = new Solicitante("Elberth", "elberth@elberth.com", "123.345.456-56");
					} catch (NomeInvalidoException | EmailInvalidoException | CpfInvalidoException e) {
						System.out.println(e.getMessage());
					}		

					try {
						pedido = new Pedido(solicitante);
						pedido.setDescricao("Pedido do professor elberth");
						pedido.setProdutos(produtos);
						
						pedido.impressao();
					} catch (PedidoSemProdutosException | SolicitanteInexistenteException e) {
						System.out.println(e.getMessage());
					}
					
					break;
				case "B":				
					try {
						Bebida vinho = new Bebida("Vinho", 100, 350);
						vinho.setGelada(false);
						vinho.setImportada(true);
						vinho.setMarca("Genericão");
						
						produtos.add(vinho);
					} catch (ValorInvalidoException | PesoInvalidoException e) {
						System.out.println(e.getMessage());
					}

					break;
				case "C":				
					try {
						Comida pizza = new Comida("Pizza", 50, 700);
						pizza.setAcompanhamento("Docinho do vovó");
						pizza.setQtdeServido(4);
						pizza.setVegana(false);
						
						produtos.add(pizza);
					} catch (QuantidadeServidoNegativaException | ValorInvalidoException | PesoInvalidoException e) {
						System.out.println(e.getMessage());
					}

					break;
				case "S":				
					try {
						Sobremesa chocolate = new Sobremesa("Chocolate", 10, 50);
						chocolate.setCalda(true);
						chocolate.setDiet(false);
						chocolate.setIngrediente("muito chocolate");

						produtos.add(chocolate);
					} catch (ValorInvalidoException | PesoInvalidoException e) {
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
				pedido.impressao();

				escrita.write(pedido.obterLinhaGravacaoArquivo());				
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
	}
}