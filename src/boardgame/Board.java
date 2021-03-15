package boardgame;

public class Board {
	
	private int rows;
	private int columns;
	private Piece[][] pieces; //Matriz
	
	public Board(int rows, int columns) {
		if(rows < 0 || columns < 0) {//Programa��o defensiva, pois o tabuleiro que que ter pelo menos uma linha e uma coluna, n�o pode ser menor ou igual � zero!	
			throw new BoardException("Erro ao criar tabuleiro, � necess�rio que tenha pelo menos uma linha e uma coluna");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns]; //A minha Matriz ser� criada com base na [rows]= Quantidade de linhas informadas [columns]= Quantidade de colunas informadas
	}

	public int getRows() {
		return rows;
	}

// O m�todo "setRows" e o "setColumns", foi retirado daqui, pois eu n�o posso permitir que a quantidade de linhas e colunas sejam alteradas.

	public int getColumns() {
		return columns;
	}
	
	//O que esse m�todo faz ?
	public Piece piece(int row, int column) {//Na hora de acessar uma pe�a que est� em uma dada linha e uma dada coluna, eu vou fazer a programa��o defensiva aqui tamb�m.
		if(!positionExists(row, column)) {//Se essa posi��o n�o existir, e vou lan�ar uma nova boarException
			throw new BoardException("Position not on the board");
		}
		return pieces[row][column];//Ele vai me retornar a minha matriz pieces na linha row e na coluna column, e agora eu vou fazer uma sobrecarga desse m�todo
	}
	
	public Piece piece(Position position) {//Ele vai retornar a pe�a pela posi��o
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[position.getRow()][position.getColumn()];//E agora ent�o o meu m�todo vai ter que retornar o meu row e o meu column em cada linha e coluna selecionada
	}
	
	public void placePiece(Piece piece, Position position) {//O que esse m�todo vai fazer ?
		if(thereIsAPiece(position)) {
			throw new BoardException ("There is already a piece on position " + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;//Ele vai ter que ir na matriz de pe�as do meu tabuleiro, na linha([position.getRow()]), e na coluna ([position.getColumn()]), e vai ter que atribuir a essa posi��o da minha matriz de pe�as, a minha pe�a que veio aqui como argumento, que vai ser o piece. Lembrando que essa matriz aqui de pe�as, � a matriz de pe�as que est� guardada aqui nesse tabuleiro. 
		piece.position = position;//No caso aqui tamb�m agora, eu vou ter que falar qe essa pe�a n�o est� mais na posi��o nula, ela est� nessa posi��o aqui(Position position), ent�o agora eu falo assim, piece.position =(recebe) position(que vai corresponder � Posi��o que declarei no m�todo "public void placePiece(Piece piece, Position position)"	
	}
	
	public Piece removePiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board"); 
		}
		if(piece(position) == null) {
			return null;
		}
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getRow()][position.getColumn()] = null;
		return aux;
	}
	
	private boolean positionExists(int row, int column) {//Metodo auxiliar para o m�todo abaixo, ele vai receber uma linha e uma coluna. Mas por que isso est� sendo feito ? Porqu� dentro da classe, vai ter um momento em que vai ser mais f�cil testar pela linha e pela coluna do que pela posi��o. Quando que uma posi��o numa dada linha de uma coluna existe? � quando essa posi��o, ela est� dentro do tabuleiro, ou seja, essa linha tem que ser: 
		return row >= 0 && row < rows && column >=0 && column < columns; //Essa linha(row), ela tem que ser, maior ou igual � zero(>=), ela n�o pode ser menor que 0, e tamb�m(&&), essa linha, tem que ser menor(<), do que a altura do tabuleiro que � o atributo rows aqui do meu tabuleiro, da mesma forma(&&), a coluna(column), ela tem que ser maior ou igual � zero(>=), e tamb�m, ela tem que ser menor(<), do que a quantidade de colunas(columns), do meu tabuleiro, que � o columns
	//Isso aqui � uma condi��o completa para ver se uma posi��o existe.
	}
	//Agora, com essa implementa��o aqui de cima, eu vou dizer que o m�todo aqui abaixo, vai retornar:
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());//o positionExists, da minha position.getRow(),e do meu position.getColumn()  
	// � assim que eu testo se uma posi��o existe
	}
	
	public boolean thereIsAPiece(Position position) {//Como eu fa�o para testar se tem uma pe�a nessa posi��o aqui? Basta eu testar...
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return piece(position) != null; //Se a pe�a , que estiver nessa posi��o piece(position), � diferente != de null
	}
}
