package br.edu.infnet.testes;

import java.util.Scanner;

import br.edu.infnet.auxiliar.Constante;
import br.edu.infnet.dominio.Administrativo;
import br.edu.infnet.dominio.Estagiario;
import br.edu.infnet.dominio.Funcionario;
import br.edu.infnet.dominio.Programador;

public class Terceiro {
	
	private static Funcionario[] funcionarios;
	
	private static int qtde = 0;

	private static void impressao(){
		System.out.println("---- Relatório de Funcionários ----");
		for (int j = 0; j < qtde; j++) {
			funcionarios[j].impressao();
		}
		System.out.println("-----------------------------------");
	}
	
	public static void main(String[] args){
		
		funcionarios = new Funcionario[Constante.QTDE_MAX];

		int opcao = 0;
		
		Scanner in = new Scanner(System.in);

		do {
			System.out.println("[1] Cadastrar um Administrativo");
			System.out.println("[2] Cadastrar um Programador");
			System.out.println("[3] Cadastrar um Estagiário");
			System.out.println("[4] Consultar um");
			System.out.println("[5] Consultar todos");
			System.out.println("[9] Sair");
			System.out.print("Informe a opção desejada: ");
			opcao = in.nextInt();

			switch (opcao) {
			case 1:
				if(qtde < Constante.QTDE_MAX) {
					
					Administrativo adm = new Administrativo();
					
					System.out.print("Informe o seu nome: ");
					adm.setNome(in.next());
					
					System.out.print("Informe a sua idade: ");
					adm.setIdade(in.nextInt());
					
					System.out.print("Informe o seu salario: ");
					adm.setSalario(in.nextFloat());
					
					System.out.print("Informe o seu bônus: ");
					adm.setBonus(in.nextFloat());

					System.out.print("Informe o seu desconto: ");
					adm.setDesconto(in.nextFloat());
					
					funcionarios[qtde] = adm;

					funcionarios[qtde].impressao();
					
					qtde++;
				} else {
					System.out.println("Impossível realizar o cadastramento!!!");
				}
				break;

			case 2:
				if(qtde < Constante.QTDE_MAX) {
					
					Programador prog = new Programador();
					
					System.out.print("Informe o seu nome: ");
					prog.setNome(in.next());
					
					System.out.print("Informe a sua idade: ");
					prog.setIdade(in.nextInt());
					
					System.out.print("Informe o seu salario: ");
					prog.setSalario(in.nextFloat());
					
					System.out.print("Informe se eh fullstack: ");
					prog.setFullStack(in.nextBoolean());

					System.out.print("Informe a sua linguagem: ");
					prog.setLinguagem(in.next());
					
					funcionarios[qtde] = prog;

					funcionarios[qtde].impressao();

					qtde++;
				} else {
					System.out.println("Impossível realizar o cadastramento!!!");
				}
				break;

			case 3:
				if(qtde < Constante.QTDE_MAX) {
					
					Estagiario estag = new Estagiario();

					System.out.print("Informe o seu nome: ");
					estag.setNome(in.next());
					
					System.out.print("Informe a sua idade: ");
					estag.setIdade(in.nextInt());
					
					System.out.print("Informe o seu salario: ");
					estag.setSalario(in.nextFloat());
					
					System.out.print("Informe a sua faculdade: ");
					estag.setFaculdade(in.next());

					System.out.print("Informe o seu período: ");
					estag.setPeriodo(in.nextInt());
					
					funcionarios[qtde] = estag;

					funcionarios[qtde].impressao();
					
					qtde++;
				} else {
					System.out.println("Impossível realizar o cadastramento!!!");
				}
				break;

			case 4:
				System.out.println("Informe o código do funcionário: ");
				int codigo = in.nextInt();

				if(codigo >= 0 && codigo < qtde) {
					funcionarios[codigo].impressao();
				} else {
					System.out.println("O código " + codigo + " é inválido!!");
				}				
				break;

			case 5:
				impressao();			
				break;

			case 9:
				System.out.println("sair");
				break;

			default:
				System.out.println("Opção inválida!!!");
				break;
			}			
		} while (opcao != 9);
		
		in.close();
		
		System.out.println("Processamento realizado!!!");
	}
}