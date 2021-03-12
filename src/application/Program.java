package application;

import chess.ChessMatch;

public class Program {

	public static void main(String[] args) {

		ChessMatch chessMatch = new ChessMatch();//Aqui eu instanciei uma partida de xadrez e iremos imprimir o tabuleiro dessa partida
		UI.printBoard(chessMatch.getPieces());//Essa é uma função para imprimir as peças da partida. Pra fazer isso eu vou criar uma classe chamada UI(UserInterface), e dentro dessa classe, eu vou criar um método chamado printBoard "UI.printBoard", esse método vai receber a matriz de peças da minha partida "(chessMatch.getPieces());" 
	}
}