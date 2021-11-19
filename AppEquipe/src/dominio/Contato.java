package dominio;

public class Contato {

	private String email;
	private String telefone;
	
	@Override
	public String toString() {
		return String.format("%s;%s", email, telefone);
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
