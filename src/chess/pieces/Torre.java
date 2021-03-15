package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

public class Torre extends ChessPiece {

	public Torre(Board board, Color color) {//Aqui eu estou informando quem é o tabuleiro, e quem é a cor da peça
		super(board, color);// E aí eu repasso esses dados para o construtor da superclasse
	}
	
	@Override
	public String toString() {//toString dessa classe
		return "T";
	}
}
