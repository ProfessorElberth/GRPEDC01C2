package dominio;

import exceptions.AnoInicioInvalidoException;

public class Dirigente extends Profissional {

	private int anoInicio;
	private boolean presidente;
	private Contato contato;
	
	public Dirigente(int anoInicio) throws AnoInicioInvalidoException {
		
		if(anoInicio > 2021 || anoInicio <= 0) {
			throw new AnoInicioInvalidoException(
					"Impossível calcular o salário: ano de início ("+anoInicio+") inválido"
				);
		}
		
		this.anoInicio = anoInicio;
	}

	@Override
	public float calcularSalario() {
		return (2021 - anoInicio) * 500 + (presidente ? 7500 : 0);
	}

	@Override
	public String toString() {
		return String.format("%s;%d;%s;%s", 
					super.toString(),
					anoInicio,
					presidente,
					contato
				);
	}

	public boolean isPresidente() {
		return presidente;
	}
	public void setPresidente(boolean presidente) {
		this.presidente = presidente;
	}
	public Contato getContato() {
		return contato;
	}
	public void setContato(Contato contato) {
		this.contato = contato;
	}
}