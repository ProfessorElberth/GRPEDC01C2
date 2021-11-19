package dominio;

import java.util.List;

public class Equipe {

	private String nome;
	private int anoFundacao;
	private Contato contato;
	private List<Profissional> profissionais;
	
	@Override
	public String toString() {
		return String.format("%s;%d;%s;%d", 
					nome,
					anoFundacao,
					contato,
					profissionais.size()
				);
	}
	
	public void impressao() {
		System.out.println("Relatório de Equipe");
		
		float gastoTotal = 0;
		float salario = 0;
		
		for(Profissional prof : profissionais) {
			
			salario = prof.calcularSalario();
			
			gastoTotal = gastoTotal + salario;
			
			System.out.println(prof.getNome() + " :: " + salario);
		}
		
		System.out.println(this);
		System.out.println("Gasto total com profissionais: R$"+gastoTotal);
		System.out.println("-------------------");
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getAnoFundacao() {
		return anoFundacao;
	}
	public void setAnoFundacao(int anoFundacao) {
		this.anoFundacao = anoFundacao;
	}
	public Contato getContato() {
		return contato;
	}
	public void setContato(Contato contato) {
		this.contato = contato;
	}
	public List<Profissional> getProfissionais() {
		return profissionais;
	}
	public void setProfissionais(List<Profissional> profissionais) {
		this.profissionais = profissionais;
	}
}