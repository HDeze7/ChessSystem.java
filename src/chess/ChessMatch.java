package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Torre;

/*Essa classe "ChessMatch, vai ser o coração do nosso sistema de xadrez,
  é nessa classe que vão ter as regras do nosso jogo de xadrez.  
																			*/
public class ChessMatch {

	private Board board;

	public ChessMatch() {// Quem tem que saber qual a dimensão do meu tabuleiro, é essa classe
							// ChessMatch, então é nssa classe que eu vou dizer que ele é (8,8)
		board = new Board(8, 8);
		initialSetup();
	}

	// O que esse método vai ter que fazer ?
	public ChessPiece[][] getPieces() {// Ele vai ter que me retornar uma matriz de peça de Xadrez, correspondente à
										// essa partida.
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];// Vou criar aqui, temporariamente uma variável auxiliar do tipo ChessPiece matriz, vou iniciar ela com um new ChessPiece[board.getRows()][board.getColumns()]																					
		/* Agora, o que eu vou fazer ? Eu vou percorrer a matriz de peças do
		 * tabuleiro(board) e pra cada peça do meu tabuleiro, eu vou fazer um
		 * downcasting para ChessPiece
		 */
		for (int i = 0; i < board.getRows(); i++) {// Eu faço um "for" normal para percorrer as linhas("i") da matriz
			for (int j = 0; j < board.getColumns(); j++) {// e dentro desse "for", vai ter um outro "for" para percorrer as colunas da matriz que vai ser correspondente à "j"														
				mat[i][j] = (ChessPiece) board.piece(i, j);// Então pra cada posição "i" "j" do meu tabuleiro, eu vou fazer que a minha matriz mat, na linha i, coluna j , receba um "board.piece(i,j)", porém antes desse argumento eu faço um downcasting((ChessPiece)) para ChessPiece, porque aí sim ele vai interpretar essa peça como uma peça de xadrez, e não como uma peça comum														
			}
		}
		return mat;// Terminado de fazer o "for", eu peço para ele me retornar a minha matriz mat.
					// Ou seja isso retorna a matriz de peças da minha partida de xadrez
	}
	
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validadeSourcePosition(source);
		Piece capturedPiece = makeMov(source, target);
		return (ChessPiece)capturedPiece;
	}
	
	private Piece makeMov(Position source, Position target ) {
		Piece p = board.removePiece(source);
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(p, target);
		return capturedPiece;

	}
	
	private void validadeSourcePosition(Position position) {
		if (!board.thereIsAPiece(position)) {
			throw new ChessException("There is no piece on source position");
		}
		if(!board.piece(position).isThereAnyPossibleMove()) {
			throw new ChessException("There is no possible moves for chosen piece");
		}
	}

	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}

	private void initialSetup() {// Esse método vai ser responsável por iniciar a partida de xadrez, colocando as
									// peças no tabuleiro.

		placeNewPiece('C', 1, new Torre(board, Color.WHITE));
		placeNewPiece('C', 2, new Torre(board, Color.WHITE));
		placeNewPiece('D', 2, new Torre(board, Color.WHITE));
		placeNewPiece('E', 2, new Torre(board, Color.WHITE));
		placeNewPiece('E', 1, new Torre(board, Color.WHITE));
		placeNewPiece('D', 1, new King(board, Color.WHITE));

		placeNewPiece('C', 7, new Torre(board, Color.BLACK));
		placeNewPiece('C', 8, new Torre(board, Color.BLACK));
		placeNewPiece('D', 7, new Torre(board, Color.BLACK));
		placeNewPiece('E', 7, new Torre(board, Color.BLACK));
		placeNewPiece('E', 8, new Torre(board, Color.BLACK));
		placeNewPiece('D', 8, new King(board, Color.BLACK)); 
	}

	/*
	 * //Colocando peças no tabuleiro para teste: placeNewPiece('B', 6, new
	 * Torre(board, Color.WHITE)); placeNewPiece('E', 8, new King (board,
	 * Color.BLACK)); placeNewPiece('E', 1, new King (board, Color.WHITE)); }
	 */
}
