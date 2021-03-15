package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Torre;

/*Essa classe "ChessMatch, vai ser o coração do nosso sistema de xadrez,
  é nessa classe que vão ter as regras do nosso jogo de xadrez.  
																			*/
public class ChessMatch {

	private Board board;
	
	public ChessMatch() {//Quem tem que saber qual a dimensão do meu tabuleiro, é essa classe ChessMatch, então é nssa classe que eu vou dizer que ele é (8,8)
		board = new Board (8,8);
		initialSetup();
	}
	
	//O que esse método vai ter que fazer ?
	public ChessPiece[][] getPieces(){//Ele vai ter que me retornar uma matriz de peça de Xadrez, correspondente à essa partida.
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];//Vou criar aqui, temporariamente uma variável auxiliar do tipo ChessPiece matriz, vou iniciar ela com um  new ChessPiece[board.getRows()][board.getColumns()] 
/* 	Agora, o que eu vou fazer ? Eu vou percorrer a matriz de peças do tabuleiro(board)
 	e pra cada peça do meu tabuleiro, eu vou fazer um downcasting para ChessPiece */
		for(int i=0; i < board.getRows(); i++) {//Eu faço um "for" normal para percorrer as linhas("i") da matriz 
			for(int j=0; j < board.getColumns(); j++) {//e dentro desse "for", vai ter um outro "for" para percorrer as colunas da matriz que vai ser correspondente à "j"
				mat[i][j] = (ChessPiece) board.piece(i,j);//Então pra cada posição "i" "j" do meu tabuleiro, eu vou fazer que a minha matriz mat, na linha i, coluna j , receba um "board.piece(i,j)", porém antes desse argumento eu faço um downcasting((ChessPiece)) para ChessPiece, porque aí sim ele vai interpretar essa peça como uma peça de xadrez, e não como uma peça comum
			}
		}
		return mat;//Terminado de fazer o "for", eu peço para ele me retornar a minha matriz mat. Ou seja isso retorna a matriz de peças da minha partida de xadrez
	}
	
	private void initialSetup() {//Esse método vai ser responsável por iniciar a partida de xadrez, colocando as peças no tabuleiro.
		//Colocando peças no tabuleiro para teste:
		board.placePiece(new Torre(board, Color.WHITE), new Position(2, 1));
		board.placePiece(new King (board, Color.BLACK), new Position(0, 4));
		board.placePiece(new King (board, Color.WHITE), new Position(7, 4));
	}
}
