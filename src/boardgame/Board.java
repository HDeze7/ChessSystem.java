package boardgame;

public class Board {
	
	private int rows;
	private int columns;
	private Piece[][] pieces; //Matriz
	
	public Board(int rows, int columns) {
		if(rows < 0 || columns < 0) {//Programação defensiva, pois o tabuleiro que que ter pelo menos uma linha e uma coluna, não pode ser menor ou igual à zero!	
			throw new BoardException("Erro ao criar tabuleiro, é necessário que tenha pelo menos uma linha e uma coluna");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns]; //A minha Matriz será criada com base na [rows]= Quantidade de linhas informadas [columns]= Quantidade de colunas informadas
	}

	public int getRows() {
		return rows;
	}

// O método "setRows" e o "setColumns", foi retirado daqui, pois eu não posso permitir que a quantidade de linhas e colunas sejam alteradas.

	public int getColumns() {
		return columns;
	}
	
	//O que esse método faz ?
	public Piece piece(int row, int column) {//Na hora de acessar uma peça que está em uma dada linha e uma dada coluna, eu vou fazer a programação defensiva aqui também.
		if(!positionExists(row, column)) {//Se essa posição não existir, e vou lançar uma nova boarException
			throw new BoardException("Position not on the board");
		}
		return pieces[row][column];//Ele vai me retornar a minha matriz pieces na linha row e na coluna column, e agora eu vou fazer uma sobrecarga desse método
	}
	
	public Piece piece(Position position) {//Ele vai retornar a peça pela posição
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[position.getRow()][position.getColumn()];//E agora então o meu método vai ter que retornar o meu row e o meu column em cada linha e coluna selecionada
	}
	
	public void placePiece(Piece piece, Position position) {//O que esse método vai fazer ?
		if(thereIsAPiece(position)) {
			throw new BoardException ("There is already a piece on position " + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;//Ele vai ter que ir na matriz de peças do meu tabuleiro, na linha([position.getRow()]), e na coluna ([position.getColumn()]), e vai ter que atribuir a essa posição da minha matriz de peças, a minha peça que veio aqui como argumento, que vai ser o piece. Lembrando que essa matriz aqui de peças, é a matriz de peças que está guardada aqui nesse tabuleiro. 
		piece.position = position;//No caso aqui também agora, eu vou ter que falar qe essa peça não está mais na posição nula, ela está nessa posição aqui(Position position), então agora eu falo assim, piece.position =(recebe) position(que vai corresponder à Posição que declarei no método "public void placePiece(Piece piece, Position position)"	
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
	
	private boolean positionExists(int row, int column) {//Metodo auxiliar para o método abaixo, ele vai receber uma linha e uma coluna. Mas por que isso está sendo feito ? Porquê dentro da classe, vai ter um momento em que vai ser mais fácil testar pela linha e pela coluna do que pela posição. Quando que uma posição numa dada linha de uma coluna existe? É quando essa posição, ela está dentro do tabuleiro, ou seja, essa linha tem que ser: 
		return row >= 0 && row < rows && column >=0 && column < columns; //Essa linha(row), ela tem que ser, maior ou igual à zero(>=), ela não pode ser menor que 0, e também(&&), essa linha, tem que ser menor(<), do que a altura do tabuleiro que é o atributo rows aqui do meu tabuleiro, da mesma forma(&&), a coluna(column), ela tem que ser maior ou igual à zero(>=), e também, ela tem que ser menor(<), do que a quantidade de colunas(columns), do meu tabuleiro, que é o columns
	//Isso aqui é uma condição completa para ver se uma posição existe.
	}
	//Agora, com essa implementação aqui de cima, eu vou dizer que o método aqui abaixo, vai retornar:
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());//o positionExists, da minha position.getRow(),e do meu position.getColumn()  
	// É assim que eu testo se uma posição existe
	}
	
	public boolean thereIsAPiece(Position position) {//Como eu faço para testar se tem uma peça nessa posição aqui? Basta eu testar...
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return piece(position) != null; //Se a peça , que estiver nessa posição piece(position), é diferente != de null
	}
}
