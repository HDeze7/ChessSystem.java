package boardgame;

public class BoardException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public BoardException(String msg) {//Construtor que recebe a mensagem,
		super(msg);// Na verdade, ele vai repassar essa mensagem para construtor da superclasse que é o RuntimeException
	}
}
