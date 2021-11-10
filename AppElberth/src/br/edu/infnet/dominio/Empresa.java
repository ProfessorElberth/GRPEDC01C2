package br.edu.infnet.dominio;

import br.edu.infnet.exceptions.NomeIncompletoException;

public class Empresa {

	private String nome;
	private String sobrenome;
	private String ultimoNome;
	private Funcionario[] funcionarios;
	
	private int qtdeFuncionarios;
	
	private float calcularValorFolhaPagamento(){
		
		float valor = 0;
		
		if(funcionarios != null) {
			for (int i = 0; i < funcionarios.length; i++) {
				if(funcionarios[i] != null) {
					valor = valor + funcionarios[i].calcularSalarioLiquido();
					qtdeFuncionarios++;
				}
			}
		}

		return valor;
	}

	public void impressao(){

		float valorFolhaPagamento = calcularValorFolhaPagamento();
		
		System.out.println("Empresa "+ getNome() +" cadastrada com sucesso!!!");
		System.out.println("Quantidade de funcionários: " + qtdeFuncionarios);
		System.out.println("Folha de pagamento dos funcionários: " + valorFolhaPagamento);
		if(funcionarios != null) {
			System.out.println("Funcionários: ");
			for (Funcionario funcionario : funcionarios) {
				if(funcionario != null) {
					System.out.println(funcionario);
				}
			}			
		}
	}
	
	public String getNome() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(this.ultimoNome.toUpperCase().charAt(0));
		sb.append("., ");
		sb.append(this.nome.toUpperCase());
		sb.append(" ");
		sb.append(this.sobrenome.toLowerCase());

		return sb.toString();
	}
	
	public void setNome(String nome) throws NomeIncompletoException {
		
		int posIni = nome.indexOf(" ");
		int posFim = nome.lastIndexOf(" ");
		
		if(posIni <= 0 && posFim <= 0) {
			throw new NomeIncompletoException("O preenchimento do campo 'nome' está incorreto!!!");
		}
		
		this.nome = nome.substring(0, posIni);
		this.sobrenome = nome.substring(posIni, posFim).trim();
		this.ultimoNome = nome.substring(posFim).trim();
	}

	public Funcionario[] getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Funcionario[] funcionarios) {
		this.funcionarios = funcionarios;
	}
}