package application;

import chess.ChessPiece;

public class UI {
	
	public static void printBoard(ChessPiece[][] pieces) {//Como fa�o para imprimir o tabuleiro da forma quadrada?
		for(int i=0; i < pieces.length; i++) {//Como eu vou ter que imprimir o n�mero da linha primeiro, e a linha da matriz na verdade come�a com 0 e n�o com 8, eu vou fazer assim:
			System.out.print((8 - i) + " ");// 8 - i +(concatenado) com " "(espa�o em branco). Isso vai fazer com que ele imprima os n�meros em sequ�ncia de cima para baixo
			for(int j=0; j < pieces.length; j++) {//E agora dentro desse "for", eu vou mandar imprimir a pe�a
				printPiece(pieces[i][j]);
			}
			System.out.println();//Colocado para ter uma quebra de linhas
		}
		System.out.println("  A B C D E F G H");
	}
	
	private static void printPiece(ChessPiece piece) {//M�todo auxiliar para imprimir uma pe�a. O que � imprimir uma unica pe�a?
		if(piece == null) {//Se essa pe�a for igual a null, significa que n�o tinha pe�a nessa posi��o do tabuleiro
			System.out.print("-");//Ent�o eu simplesmente imprimo na tela, esse tracinho " - ".
		}
		else {
			System.out.print(piece);//Caso contr�rio, eu vou imprimir a pe�a.
		}
		System.out.print(" ");//De toda forma, eu vou mandar imprimir um espa�o em branco para que as pe�as n�o fiquem grudadas uma nas outras 
	}
}
