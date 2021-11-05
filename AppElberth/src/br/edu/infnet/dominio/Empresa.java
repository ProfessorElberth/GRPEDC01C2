package br.edu.infnet.dominio;

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
		
		System.out.println("Empresa "+ nome +" cadastrada com sucesso!!!");
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
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Funcionario[] getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Funcionario[] funcionarios) {
		this.funcionarios = funcionarios;
	}
}