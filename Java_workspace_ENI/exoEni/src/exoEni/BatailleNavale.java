package exoEni;

import java.util.Random;
import java.util.Scanner;

public class BatailleNavale {

	final static char WATER_CHAR = '?';
	final static char PLOUF = 'O';
	final static char TOUCH = 'X';
	final static int BOARD_SIZE = 5;
	
	public static void main(String[] args) {
		
		//---VARIABLES-----------
		Scanner input = new Scanner(System.in);
		
		char[][] board = new char[BOARD_SIZE][BOARD_SIZE];
		
		int coordX, coordY, userCoordX, userCoordY;
		
		boolean win = false;
		

		//#######----PROGRAM------------#############"
		
		//---initialisation of the board
		initBoard(board);
			
		
		//---selection of the boat position by the computer (coordX, coordY)
		coordX = generateCoord();
		coordY = generateCoord();
			
		//---welcome message
		introMessage();
		
		//---printing the board
		printBoard(board);
		
		while(!win) {
			
			//---play a turn
			System.out.println();
			System.out.println("Sur quelle ligne souhaitez vous jouer (de " + (BOARD_SIZE - (BOARD_SIZE - 1)) + " à " + BOARD_SIZE + ")");
			userCoordX = input.nextInt() - 1;
			while(userCoordX < 0 || userCoordX > BOARD_SIZE - 1 ) {
				System.out.println("Veuillez saisir un numero de ligne valide");
				userCoordX = input.nextInt() - 1;
			}
			
			
			System.out.println();
			System.out.println("Dans quelle colonne souhaitez vous jouer (de " + (BOARD_SIZE - (BOARD_SIZE - 1)) + " à " + BOARD_SIZE + ")");
			userCoordY = input.nextInt() - 1;
			while(userCoordY < 0 || userCoordY > BOARD_SIZE - 1 ) {
				System.out.println("Veuillez saisir un numero de colonne valide");
				userCoordY = input.nextInt() - 1;
			}
			
			//---test if win
			if(userCoordX == coordX & userCoordY == coordY) {
				win = true;
				changingBoardWin(board, userCoordX, userCoordY); // changing board with the TOUCH caracter
			} else {
				//---Changing board
				System.out.println("Loupé ! "); // miss message
				changingBoard(board, userCoordX, userCoordY); //changing board with the caractere PLOUF where the player played
				printBoard(board);	//print the board
			}
			
		}
		
		//---win printings
		printBoard(board);
		System.out.println("Bravo, vous avez gagné !!!!!");
		
		input.close();
	}//--End MAIN
	
	//####################----METHODS----####################################
	
	//------Generate random number betwenn min and max(exluded)
	public static int generateRandomInt(int min, int max) {
		Random random = new Random();
		int nb;
		nb = min+random.nextInt((max) - min);
		return nb;
	}
	
	//--------Selection of the position of the boat by the computer
	public static int generateCoord() {
		int coord = generateRandomInt(0, BOARD_SIZE);
		return coord;
	}
	
	//----------print the gaming board - char[][] as parameter
	public static void printBoard(char[][] board) {
		int i,j;
		
		for(i = 0; i < BOARD_SIZE + 1; i++) {
			System.out.print((i)  + " "); // print indices for Y
		}
		
		System.out.println();
		
		for(i = 0; i < BOARD_SIZE; i++) {
			System.out.print((i + 1) + " "); // print indices for X
			
			for(j = 0; j < BOARD_SIZE; j++) {
				System.out.print(board[i][j] + " ");
			}
		System.out.println();
		}
	}
	
	//--initialise the gaming board with default caracter - char[][] as parameter
	public static void initBoard(char[][] board) {
		int i,j;
		
		for(i = 0; i < BOARD_SIZE; i++) {
			for(j = 0; j < BOARD_SIZE; j++) {
				board[i][j] = WATER_CHAR;
			}
		}
	}
	
	//----printing introduction message
	public static void introMessage() {
		System.out.println("BATAILLE NAVALE - By KeKe");
		System.out.println();
		System.out.println("Bonjour et bienvenue dans ce magnifique jeu de bataille navale");
		System.out.println("Vous allez devoir trouver où se cache le bateau sur le plateau. Bon, c'est un tout petit bateau, qui ne prends qu'une case...");
		System.out.println("Vous allez devoir saisir des coordonnées (ligne, colonne) pour jouer vos coups");
		System.out.println();
		System.out.println("C'est parti, voici le plateau de jeu :");
		System.out.println();
	}
	
	//---Changing board after playing
	public static void changingBoard(char[][] board, int coordX, int coordY) {
		board[coordX][coordY] = PLOUF;
	}
	
	//---Changing board if player win
		public static void changingBoardWin(char[][] board, int coordX, int coordY) {
			board[coordX][coordY] = TOUCH;
		}

}
