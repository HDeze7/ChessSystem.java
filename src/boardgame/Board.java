package boardgame;

public class Board {
	
	private int rows;
	private int columns;
	private Piece[][] pieces; //Matriz
	
	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns]; //A minha Matriz ser� criada com base na [rows]= Quantidade de linhas informadas [columns]= Quantidade de colunas informadas
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}
	
	//O que esse m�todo faz ?
	public Piece piece(int row, int column) {
		return pieces[row][column];//Ele vai me retornar a minha matriz pieces na linha row e na coluna column, e agora eu vou fazer uma sobrecarga desse m�todo
	}
	
	public Piece piece(Position position) {//Ele vai retornar a pe�a pela posi��o
		return pieces[position.getRow()][position.getColumn()];//E agora ent�o o meu m�todo vai ter que retornar o meu row e o meu column em cada linha e coluna selecionada
	}
	
	public void placePiece(Piece piece, Position position) {//O que esse m�todo vai fazer ?
		pieces[position.getRow()][position.getColumn()] = piece;//Ele vai ter que ir na matriz de pe�as do meu tabuleiro, na linha([position.getRow()]), e na coluna ([position.getColumn()]), e vai ter que atribuir a essa posi��o da minha matriz de pe�as, a minha pe�a que veio aqui como argumento, que vai ser o piece. Lembrando que essa matriz aqui de pe�as, � a matriz de pe�as que est� guardada aqui nesse tabuleiro. 
		piece.position = position;//No caso aqui tamb�m agora, eu vou ter que falar qe essa pe�a n�o est� mais na posi��o nula, ela est� nessa posi��o aqui(Position position), ent�o agora eu falo assim, piece.position =(recebe) position(que vai corresponder � Posi��o que declarei no m�todo "public void placePiece(Piece piece, Position position)"
		
	}
	
	
}
