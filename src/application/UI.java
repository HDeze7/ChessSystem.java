package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

public class UI {
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
	
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
	
	public static ChessPosition readChessPosition(Scanner sc ) {
		try {
				String s = sc.nextLine();
				char column = s.charAt(0);
				int row = Integer.parseInt(s.substring(1));
				return new ChessPosition(column, row);
		}
		catch(RuntimeException e) {
			throw new InputMismatchException("Error, reading ChessPosition. Valid values are from A1 to H8.");
		}
	}
	
	public static void printBoard(ChessPiece[][] pieces) {
		for (int i = 0; i < pieces.length; i++) {
			System.out.print((8 - i) + " ");
			for (int j = 0; j < pieces.length; j++) {
				printPiece(pieces[i][j], false);
			}
			System.out.println();
		}
		System.out.println("  A B C D E F G H");
	}
	
	public static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves) {
		for (int i = 0; i < pieces.length; i++) {
			System.out.print((8 - i) + " ");
			for (int j = 0; j < pieces.length; j++) {
				printPiece(pieces[i][j], possibleMoves[i][j]);
			}
			System.out.println();
		}
		System.out.println("  A B C D E F G H");
	}
	
	private static void printPiece(ChessPiece piece, boolean background) {
		if(background){
			System.out.print(ANSI_BLUE_BACKGROUND);
		}
    	if (piece == null) {
            System.out.print("-" + ANSI_RESET);
        }
        else {
            if (piece.getColor() == Color.WHITE) {
                System.out.print(ANSI_WHITE + piece + ANSI_RESET);
            }
            else {
                System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
            }
        }
        System.out.print(" ");
	}

/*	public static void printBoard(ChessPiece[][] pieces) {//Como fa�o para imprimir o tabuleiro da forma quadrada?
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
	} */
}
