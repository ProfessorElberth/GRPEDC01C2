package dominio;

public class Jogador extends Profissional {

	private int anoNascimento;
	private int qtdeTituloNacional;
	private int qtdeTituloInternacional;
	
	@Override
	public float calcularSalario() {
		return qtdeTituloNacional * 1000 + qtdeTituloInternacional * 5000;
	}

	@Override
	public String toString() {
		return String.format("%s;%d;%d;%d;%.2f",
					super.toString(),
					anoNascimento, 
					qtdeTituloNacional, 
					qtdeTituloInternacional,
					calcularSalario()
				);
	}

	public int getAnoNascimento() {
		return anoNascimento;
	}
	public void setAnoNascimento(int anoNascimento) {
		this.anoNascimento = anoNascimento;
	}
	public int getQtdeTituloNacional() {
		return qtdeTituloNacional;
	}
	public void setQtdeTituloNacional(int qtdeTituloNacional) {
		this.qtdeTituloNacional = qtdeTituloNacional;
	}
	public int getQtdeTituloInternacional() {
		return qtdeTituloInternacional;
	}
	public void setQtdeTituloInternacional(int qtdeTituloInternacional) {
		this.qtdeTituloInternacional = qtdeTituloInternacional;
	}
}
