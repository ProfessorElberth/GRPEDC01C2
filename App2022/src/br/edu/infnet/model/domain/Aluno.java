package br.edu.infnet.model.domain;

public class Aluno {

	private String nome;
	private String email;
	private int idade;
	private float mensalidade;
	private String[] disciplinas;
	private String curso;
	private String regiao;

	public Aluno(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}	
	
	@Override
	public String toString() {
		return String.format("[%s] O aluno %s (%s) tem %d anos, mora na regi�o %s, paga R$%.2f de mensalidade e est� inscrito em %d disciplinas!",
				curso,
				nome,
				email,
				idade,
				regiao,
				mensalidade,
				disciplinas.length
			);
	}
	
	public void impressao() {
		System.out.println(this);
	
		System.out.println("Disciplinas:");
		for(String disciplina : disciplinas) {
			System.out.println("- " + disciplina);
		}
	}
	
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}	
	public int getIdade() {
		return idade;
	}
	public float getMensalidade() {
		return mensalidade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public void setMensalidade(float mensalidade) {
		this.mensalidade = mensalidade;
	}
	public String[] getDisciplinas() {
		return disciplinas;
	}
	public String getCurso() {
		return curso;
	}
	public String getRegiao() {
		return regiao;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setDisciplinas(String[] disciplinas) {
		this.disciplinas = disciplinas;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}	
}