package application;

import chess.ChessMatch;

public class Program {

	public static void main(String[] args) {

		ChessMatch chessMatch = new ChessMatch();//Aqui eu instanciei uma partida de xadrez e iremos imprimir o tabuleiro dessa partida
		UI.printBoard(chessMatch.getPieces());//Essa � uma fun��o para imprimir as pe�as da partida. Pra fazer isso eu vou criar uma classe chamada UI(UserInterface), e dentro dessa classe, eu vou criar um m�todo chamado printBoard "UI.printBoard", esse m�todo vai receber a matriz de pe�as da minha partida "(chessMatch.getPieces());" 
	}
}