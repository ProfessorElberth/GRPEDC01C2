package dominio;

import exceptions.QtdeTituloNegativaException;

public class ComissaoTecnica extends Profissional {

	private boolean treinador;
	private int qtdeTitulo;
	
	public ComissaoTecnica(int qtdeTitulo) throws QtdeTituloNegativaException {
		
		if(qtdeTitulo <= 0) {
			throw new QtdeTituloNegativaException(
					"Impossível calcular o salário: qtde de títulos ("+qtdeTitulo+") menor ou igual a zero!!!"
				);
		}
				
		this.qtdeTitulo = qtdeTitulo;
	}

	@Override
	public float calcularSalario() {
		
		return qtdeTitulo * 2000 + (treinador ? 10000 : 0);
	}	
	
	@Override
	public String toString() {
		return String.format("%s;%s;%d", 
					super.toString(),
					treinador,
					qtdeTitulo
				);
	}

	public boolean isTreinador() {
		return treinador;
	}
	public void setTreinador(boolean treinador) {
		this.treinador = treinador;
	}
}