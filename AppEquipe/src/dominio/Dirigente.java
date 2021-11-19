package dominio;

public class Dirigente extends Profissional {

	private int anoInicio;
	private boolean presidente;
	private Contato contato;
	
	@Override
	public float calcularSalario() {
		return (2021 - anoInicio) * 500 + (presidente ? 7500 : 0);
	}

	@Override
	public String toString() {
		return String.format("%s;%d;%s;%s;%.2f", 
					super.toString(),
					anoInicio,
					presidente,
					contato,
					calcularSalario()
				);
	}

	public int getAnoInicio() {
		return anoInicio;
	}
	public void setAnoInicio(int anoInicio) {
		this.anoInicio = anoInicio;
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