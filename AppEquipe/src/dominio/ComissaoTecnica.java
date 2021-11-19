package dominio;

public class ComissaoTecnica extends Profissional {

	private boolean treinador;
	private int qtdeTitulo;
	

	@Override
	public float calcularSalario() {
		return qtdeTitulo * 2000 + (treinador ? 10000 : 0);
	}	
	
	@Override
	public String toString() {
		return String.format("%s;%s;%d;%.2f", 
					super.toString(),
					treinador,
					qtdeTitulo,
					calcularSalario()
				);
	}

	public boolean isTreinador() {
		return treinador;
	}
	public void setTreinador(boolean treinador) {
		this.treinador = treinador;
	}
	public int getQtdeTitulo() {
		return qtdeTitulo;
	}
	public void setQtdeTitulo(int qtdeTitulo) {
		this.qtdeTitulo = qtdeTitulo;
	}
}