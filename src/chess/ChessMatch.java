package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Torre;

/*Essa classe "ChessMatch, vai ser o cora��o do nosso sistema de xadrez,
  � nessa classe que v�o ter as regras do nosso jogo de xadrez.  
																			*/
public class ChessMatch {

	private Board board;

	public ChessMatch() {// Quem tem que saber qual a dimens�o do meu tabuleiro, � essa classe
							// ChessMatch, ent�o � nssa classe que eu vou dizer que ele � (8,8)
		board = new Board(8, 8);
		initialSetup();
	}

	// O que esse m�todo vai ter que fazer ?
	public ChessPiece[][] getPieces() {// Ele vai ter que me retornar uma matriz de pe�a de Xadrez, correspondente �
										// essa partida.
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];// Vou criar aqui, temporariamente uma vari�vel auxiliar do tipo ChessPiece matriz, vou iniciar ela com um new ChessPiece[board.getRows()][board.getColumns()]																					
		/* Agora, o que eu vou fazer ? Eu vou percorrer a matriz de pe�as do
		 * tabuleiro(board) e pra cada pe�a do meu tabuleiro, eu vou fazer um
		 * downcasting para ChessPiece
		 */
		for (int i = 0; i < board.getRows(); i++) {// Eu fa�o um "for" normal para percorrer as linhas("i") da matriz
			for (int j = 0; j < board.getColumns(); j++) {// e dentro desse "for", vai ter um outro "for" para percorrer as colunas da matriz que vai ser correspondente � "j"														
				mat[i][j] = (ChessPiece) board.piece(i, j);// Ent�o pra cada posi��o "i" "j" do meu tabuleiro, eu vou fazer que a minha matriz mat, na linha i, coluna j , receba um "board.piece(i,j)", por�m antes desse argumento eu fa�o um downcasting((ChessPiece)) para ChessPiece, porque a� sim ele vai interpretar essa pe�a como uma pe�a de xadrez, e n�o como uma pe�a comum														
			}
		}
		return mat;// Terminado de fazer o "for", eu pe�o para ele me retornar a minha matriz mat.
					// Ou seja isso retorna a matriz de pe�as da minha partida de xadrez
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

	private void initialSetup() {// Esse m�todo vai ser respons�vel por iniciar a partida de xadrez, colocando as
									// pe�as no tabuleiro.

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
	 * //Colocando pe�as no tabuleiro para teste: placeNewPiece('B', 6, new
	 * Torre(board, Color.WHITE)); placeNewPiece('E', 8, new King (board,
	 * Color.BLACK)); placeNewPiece('E', 1, new King (board, Color.WHITE)); }
	 */
}
