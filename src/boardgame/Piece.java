package boardgame;

public class Piece {
	
	protected Position position;
	private Board board;

/*No caso aqui, eu vou passar apenas o tabuleiro na hora de criar a peça. Por que ?
  Porquê a posição de uma peça recém criada, ela vai ser inicialmente como nula, 
  dizendo que essa peça não foi colocada no tabuleiro ainda.
*/
	public Piece(Board board) { //Só que aí, quem vai ser a posição de uma peça recém criada? Vai ser "null"
		this.board = board;
		position = null;//Essa difinição aqui é opcional, pois por padrão, o Java ja a define como nula.
	}
	
	protected Board getBoard() {
		return board;
/*O set não será utilizado pois eu não vou permitir que o meu tabuleiro seja alterado,
  e no caso terá apenas o "getBoard", só que esse getBoard, eu também não vou deixar
  ele "public", eu vou passar ele para "protected", ou seja, somente classes dentro do 
  mesmo pacote e subclasses é que vão poder acessar o tabuleiro de uma peça.		
 */
	}
}
