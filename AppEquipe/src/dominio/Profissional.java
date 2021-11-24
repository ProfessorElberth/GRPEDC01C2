package dominio;

public abstract class Profissional {

	private String nome;
	
	public abstract float calcularSalario();
	
	public void impressao() {		
		
		StringBuilder sb = new StringBuilder();
		sb.append("Relatório: ");
		sb.append(this);
		sb.append(this.calcularSalario());

		System.out.println(sb.toString());
	}
	
	@Override
	public String toString() {
		return String.format("%s", nome);
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}