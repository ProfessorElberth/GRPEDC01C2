package br.edu.infnet.apppedido.model.domain;

public class Sobremesa extends Produto {

	private String ingrediente;
	private boolean calda;
	private boolean diet;
	
	public Sobremesa(String descricao, float valor, float peso) {
		super(descricao, valor, peso);
	}

	@Override
	public float calcularValorVenda() {

		return this.getValor() 
				+ (this.getPeso() * 0.05f)
				+ (calda ? this.getValor()/10 : 0)
				+ (diet ? this.getValor()/20 : 0);
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(ingrediente);
		sb.append(";");
		sb.append(calda);
		sb.append(";");
		sb.append(diet);
		
		return sb.toString();
	}

	public String getIngrediente() {
		return ingrediente;
	}

	public boolean isCalda() {
		return calda;
	}

	public boolean isDiet() {
		return diet;
	}

	public void setIngrediente(String ingrediente) {
		this.ingrediente = ingrediente;
	}

	public void setCalda(boolean calda) {
		this.calda = calda;
	}

	public void setDiet(boolean diet) {
		this.diet = diet;
	}
}
