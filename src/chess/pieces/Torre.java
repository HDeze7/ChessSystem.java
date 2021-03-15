package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

public class Torre extends ChessPiece {

	public Torre(Board board, Color color) {//Aqui eu estou informando quem � o tabuleiro, e quem � a cor da pe�a
		super(board, color);// E a� eu repasso esses dados para o construtor da superclasse
	}
	
	@Override
	public String toString() {//toString dessa classe
		return "T";
	}
}