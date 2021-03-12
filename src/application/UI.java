package application;

import chess.ChessPiece;

public class UI {
	
	public static void printBoard(ChessPiece[][] pieces) {//Como faço para imprimir o tabuleiro da forma quadrada?
		for(int i=0; i < pieces.length; i++) {//Como eu vou ter que imprimir o número da linha primeiro, e a linha da matriz na verdade começa com 0 e não com 8, eu vou fazer assim:
			System.out.print((8 - i) + " ");// 8 - i +(concatenado) com " "(espaço em branco). Isso vai fazer com que ele imprima os números em sequência de cima para baixo
			for(int j=0; j < pieces.length; j++) {//E agora dentro desse "for", eu vou mandar imprimir a peça
				printPiece(pieces[i][j]);
			}
			System.out.println();//Colocado para ter uma quebra de linhas
		}
		System.out.println("  A B C D E F G H");
	}
	
	private static void printPiece(ChessPiece piece) {//Método auxiliar para imprimir uma peça. O que é imprimir uma unica peça?
		if(piece == null) {//Se essa peça for igual a null, significa que não tinha peça nessa posição do tabuleiro
			System.out.print("-");//Então eu simplesmente imprimo na tela, esse tracinho " - ".
		}
		else {
			System.out.print(piece);//Caso contrário, eu vou imprimir a peça.
		}
		System.out.print(" ");//De toda forma, eu vou mandar imprimir um espaço em branco para que as peças não fiquem grudadas uma nas outras 
	}
}
