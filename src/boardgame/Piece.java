package boardgame;

public class Piece {
	
	protected Position position;
	private Board board;

/*No caso aqui, eu vou passar apenas o tabuleiro na hora de criar a pe�a. Por que ?
  Porqu� a posi��o de uma pe�a rec�m criada, ela vai ser inicialmente como nula, 
  dizendo que essa pe�a n�o foi colocada no tabuleiro ainda.
*/
	public Piece(Board board) { //S� que a�, quem vai ser a posi��o de uma pe�a rec�m criada? Vai ser "null"
		this.board = board;
		position = null;//Essa difini��o aqui � opcional, pois por padr�o, o Java ja a define como nula.
	}
	
	protected Board getBoard() {
		return board;
/*O set n�o ser� utilizado pois eu n�o vou permitir que o meu tabuleiro seja alterado,
  e no caso ter� apenas o "getBoard", s� que esse getBoard, eu tamb�m n�o vou deixar
  ele "public", eu vou passar ele para "protected", ou seja, somente classes dentro do 
  mesmo pacote e subclasses � que v�o poder acessar o tabuleiro de uma pe�a.		
 */
	}
}
