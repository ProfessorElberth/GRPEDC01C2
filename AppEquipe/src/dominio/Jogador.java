package dominio;

import exceptions.QtdeTituloNegativaException;

public class Jogador extends Profissional {

	private int anoNascimento;
	private int qtdeTituloNacional;
	private int qtdeTituloInternacional;
	
	public Jogador(int qtdeTituloNacional, int qtdeTituloInternacional) throws QtdeTituloNegativaException {
		
		if(qtdeTituloNacional <= 0 || qtdeTituloInternacional <= 0) {
			throw new QtdeTituloNegativaException(
					"Impossível calcular o salário: qtde de títulos ("+qtdeTituloNacional +" | "+qtdeTituloInternacional+") menor ou igual a zero!!!"
					);
		}
		
		this.qtdeTituloNacional = qtdeTituloNacional;
		this.qtdeTituloInternacional = qtdeTituloInternacional;
	}

	@Override
	public float calcularSalario() {
		return qtdeTituloNacional * 1000 + qtdeTituloInternacional * 5000;
	}

	@Override
	public String toString() {
		return String.format("%s;%d;%d;%d",
					super.toString(),
					anoNascimento, 
					qtdeTituloNacional, 
					qtdeTituloInternacional
				);
	}

	public int getAnoNascimento() {
		return anoNascimento;
	}
	public void setAnoNascimento(int anoNascimento) {
		this.anoNascimento = anoNascimento;
	}
}