package br.edu.infnet.dominio;

import java.util.List;

import br.edu.infnet.exceptions.AusenciaFuncionarioException;
import br.edu.infnet.exceptions.FaturamentoNegativoException;
import br.edu.infnet.exceptions.NomeIncompletoException;

public class Empresa {

	private String nome;
	private String sobrenome;
	private String ultimoNome;
	private float faturamento;
	private List<Funcionario> funcionarios;
	
	private int qtdeFuncionarios;
	
	private float calcularValorFolhaPagamento(){
		
		float valor = 0;
		
		for(Funcionario func : funcionarios) {
			valor = valor + func.calcularSalarioLiquido();
			qtdeFuncionarios++;
		}

		return valor;
	}

	public void impressao() throws AusenciaFuncionarioException {
		
		if(funcionarios == null) {
			throw new AusenciaFuncionarioException("É obrigatório a associação de funcionários!!!");
		}
		
		float valorFolhaPagamento = calcularValorFolhaPagamento();
		
		System.out.println("Empresa "+ getNome() +" cadastrada com sucesso!!!");
		System.out.println("Faturamento: " + faturamento);
		System.out.println("Quantidade de funcionários: " + qtdeFuncionarios);
		System.out.println("Folha de pagamento dos funcionários: " + valorFolhaPagamento);

		System.out.println("Funcionários: ");
		for (Funcionario funcionario : funcionarios) {
			System.out.println(funcionario);
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
			throw new NomeIncompletoException("O preenchimento do campo 'nome' está incorreto: "+nome+"!!!");
		}
		
		this.nome = nome.substring(0, posIni);
		this.sobrenome = nome.substring(posIni, posFim).trim();
		this.ultimoNome = nome.substring(posFim).trim();
	}

	public float getFaturamento() {
		return faturamento;
	}
	public void setFaturamento(float faturamento) throws FaturamentoNegativoException {
		
		if(faturamento < 0) {
			throw new FaturamentoNegativoException("O faturamento da empresa não pode ser negativo!");
		}
		
		this.faturamento = faturamento;
	}
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
}