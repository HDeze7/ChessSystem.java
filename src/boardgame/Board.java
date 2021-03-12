package boardgame;

public class Board {
	
	private int rows;
	private int columns;
	private Piece[][] pieces; //Matriz
	
	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns]; //A minha Matriz será criada com base na [rows]= Quantidade de linhas informadas [columns]= Quantidade de colunas informadas
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
	
	//O que esse método faz ?
	public Piece piece(int row, int column) {
		return pieces[row][column];//Ele vai me retornar a minha matriz pieces na linha row e na coluna column, e agora eu vou fazer uma sobrecarga desse método
	}
	
	public Piece piece(Position position) {//Ele vai retornar a peça pela posição
		return pieces[position.getRow()][position.getColumn()];//E agora então o meu método vai ter que retornar o meu row e o meu column em cada linha e coluna selecionada
	}
	
	
}
