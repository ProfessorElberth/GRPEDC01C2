package exceptions;

public class ProfissionalInexistenteException extends Exception {

	private static final long serialVersionUID = 1L;

	public ProfissionalInexistenteException(String mensagem) {
		super(mensagem);
	}
}