package fr.eni.natation;

import java.util.Random;
import java.util.Scanner;

public class Natation {

	static Scanner input = new Scanner(System.in);
	
	static final char TETE = 'O';
	static final char CORPS = '#';
	static final char JAMBES = '=';
	static final char EAU = ' ';
	static final char BORDS_PISCINE_HORIZ = '-';
	static final char BORDS_PISCINE_VERT = '|';
	static final String swimmerUn = "Ligne 1:Bousquet";
	static final String swimmerDeux = "Ligne 2: Le Veau";
	static final String swimmerTrois = "Ligne 3: Dubosc";
	static final int SWIMMER_UN_INDEX = 0;
	static final int SWIMMER_DEUX_INDEX = 1;
	static final int SWIMMER_TROIS_INDEX = 2;
	static final int TAILLE_PISCINE = 25;
	static final int NOMBRE_LIGNES = 3;
	
	static char[][] piscine = new char[NOMBRE_LIGNES][TAILLE_PISCINE];
	
	static int swimmerSelected;
	static int power;
	static int positionSwimmerUn = 2;
	static int positionSwimmerDeux = 2;
	static int positionSwimmerTrois = 2;
	
	static boolean swimmerUnReturn = false;
	static boolean swimmerDeuxReturn = false;
	static boolean swimmerTroisReturn = false;
	
	static int swimmerUnDistance = 3;
	static int swimmerDeuxDistance = 3;
	static int swimmerTroisDistance = 3;
	
	static boolean playerOneWin = false;
	static boolean playerTwoWin = false;
	static boolean playerThreeWin = false;
	
	
	static int[][] tabClassement;
	static int classementSwimmerOne;
	static int classementSwimmerTwo;
	static int classementSwimmerThree;
	
	static int classement = 1;
	
	
	//--##########--MAIN----##############
	public static void main(String[] args) {
		
		initPiscine(piscine);
		//init tableau classement
		tabClassement = initTabClassement();
		
		//afficher screen
		afficherPiscine(piscine);
		
		//action user
		input.nextLine();
		//boucle de jeu
		while(!(playerThreeWin && playerOneWin && playerTwoWin)) {
			swimmerSelected = generateRandomSwimmer();
			power = generateRandomPower();
			switch (swimmerSelected) {
			case 1: moveSwimmerOne(piscine, power);
			break;
			case 2: moveSwimmerTwo(piscine, power);
			break;
			case 3: moveSwimmerThree(piscine, power);
			break;
			
			}
			
		}
		
		
		
	
		int i = input.nextInt();
		while(!(playerThreeWin && playerOneWin && playerTwoWin)) {
			input.nextLine();
			moveSwimmerThree(piscine, i);
			afficherPiscine(piscine);
			System.out.println(swimmerTroisDistance);
			System.out.println(positionSwimmerTrois);
			
			afficheTabClassement(tabClassement);
		
			i = input.nextInt();
		}
		System.out.println("Gagné");
	}
	
	//--########methods
	

	//avancer nageur un
	public static void moveSwimmerOne(char[][]piscine, int power) {
		
		if(swimmerUnReturn) {	
			//----RETOUR NAGEUR-----------------
			switch (power) {
			case 1: 
				piscine[SWIMMER_UN_INDEX][positionSwimmerUn - 1] = TETE; piscine[SWIMMER_UN_INDEX][positionSwimmerUn] = CORPS; piscine[SWIMMER_UN_INDEX][positionSwimmerUn + 1] = JAMBES; piscine[SWIMMER_UN_INDEX][positionSwimmerUn + 2] = EAU;
				positionSwimmerUn --; swimmerUnDistance ++;
				if(positionSwimmerUn == 0) {playerOneWin = true;}
			break;
			case 2:
				//si proche du bord de la piscine
				if(positionSwimmerUn == 1) {
					piscine[SWIMMER_UN_INDEX][0] = TETE; piscine[SWIMMER_UN_INDEX][1] = CORPS; piscine[SWIMMER_UN_INDEX][2] = JAMBES; piscine[SWIMMER_UN_INDEX][3] = EAU;
					playerOneWin = true;
				}else {
					piscine[SWIMMER_UN_INDEX][positionSwimmerUn - 2] = TETE; piscine[SWIMMER_UN_INDEX][positionSwimmerUn - 1] = CORPS; piscine[SWIMMER_UN_INDEX][positionSwimmerUn ] = JAMBES; piscine[SWIMMER_UN_INDEX][positionSwimmerUn + 1] = EAU; piscine[SWIMMER_UN_INDEX][positionSwimmerUn + 2] = EAU;
					positionSwimmerUn -= 2; swimmerUnDistance += 2;
					if(positionSwimmerUn == 0) {playerOneWin = true;}
				}
			break;
			case 3:
				//si proche du bord de la piscine
				if(positionSwimmerUn == 1 || positionSwimmerUn == 2) {
					piscine[SWIMMER_UN_INDEX][0] = TETE; piscine[SWIMMER_UN_INDEX][1] = CORPS; piscine[SWIMMER_UN_INDEX][2] = JAMBES; piscine[SWIMMER_UN_INDEX][3] = EAU;
					playerOneWin = true;
				}
				piscine[SWIMMER_UN_INDEX][positionSwimmerUn - 3] = TETE; piscine[SWIMMER_UN_INDEX][positionSwimmerUn - 2] = CORPS; piscine[SWIMMER_UN_INDEX][positionSwimmerUn - 1] = JAMBES;piscine[SWIMMER_UN_INDEX][positionSwimmerUn] = EAU; piscine[SWIMMER_UN_INDEX][positionSwimmerUn + 1] = EAU; piscine[SWIMMER_UN_INDEX][positionSwimmerUn + 2] = EAU;
				positionSwimmerUn -= 3; swimmerUnDistance += 3;
				if(positionSwimmerUn == 0) {playerOneWin = true;}
			break;
			}		
			
		}else {
			//-----ALLER NAGEUR-------------------------
			switch (power) {
			case 1: 
				piscine[SWIMMER_UN_INDEX][positionSwimmerUn + 1] = TETE; piscine[SWIMMER_UN_INDEX][positionSwimmerUn] = CORPS; piscine[SWIMMER_UN_INDEX][positionSwimmerUn - 1] = JAMBES; piscine[SWIMMER_UN_INDEX][positionSwimmerUn - 2] = EAU;
				positionSwimmerUn ++; swimmerUnDistance ++;
				if(positionSwimmerUn == TAILLE_PISCINE - 1) {swimmerUnReturn = true;}
			break;
			case 2:
				//si position presque bout de piscine
				if(positionSwimmerUn == TAILLE_PISCINE - 2) {
					piscine[SWIMMER_UN_INDEX][TAILLE_PISCINE - 4] = TETE; piscine[SWIMMER_UN_INDEX][TAILLE_PISCINE -3] = CORPS; piscine[SWIMMER_UN_INDEX][TAILLE_PISCINE -2 ] = JAMBES; 
					positionSwimmerUn = TAILLE_PISCINE - 4; swimmerUnReturn = true; swimmerUnDistance += 2; 
				}else {
					piscine[SWIMMER_UN_INDEX][positionSwimmerUn + 2] = TETE; piscine[SWIMMER_UN_INDEX][positionSwimmerUn + 1] = CORPS; piscine[SWIMMER_UN_INDEX][positionSwimmerUn ] = JAMBES; piscine[SWIMMER_UN_INDEX][positionSwimmerUn - 1] = EAU; piscine[SWIMMER_UN_INDEX][positionSwimmerUn - 2] = EAU;
					positionSwimmerUn += 2;
					swimmerUnDistance += 2;
				}
			break;
			case 3:
				//position bord piscine, se retourne
				if(positionSwimmerUn == TAILLE_PISCINE -2 ) {
					piscine[SWIMMER_UN_INDEX][TAILLE_PISCINE - 5] = TETE; piscine[SWIMMER_UN_INDEX][TAILLE_PISCINE -4] = CORPS; piscine[SWIMMER_UN_INDEX][TAILLE_PISCINE -3 ] = JAMBES; piscine[SWIMMER_UN_INDEX][TAILLE_PISCINE - 2] = EAU;
					positionSwimmerUn = TAILLE_PISCINE - 4; swimmerUnReturn = true; swimmerUnDistance += 3; 
				} else if(positionSwimmerUn == TAILLE_PISCINE -3){
					piscine[SWIMMER_UN_INDEX][TAILLE_PISCINE - 4] = TETE; piscine[SWIMMER_UN_INDEX][TAILLE_PISCINE -3] = CORPS; piscine[SWIMMER_UN_INDEX][TAILLE_PISCINE -2 ] = JAMBES;  piscine[SWIMMER_UN_INDEX][TAILLE_PISCINE - 5] = EAU;
					positionSwimmerUn = TAILLE_PISCINE - 5; swimmerUnReturn = true; swimmerUnDistance += 3; 
				//avance normalement	
				}else {
					piscine[SWIMMER_UN_INDEX][positionSwimmerUn + 3] = TETE; piscine[SWIMMER_UN_INDEX][positionSwimmerUn + 2] = CORPS; piscine[SWIMMER_UN_INDEX][positionSwimmerUn + 1] = JAMBES;piscine[SWIMMER_UN_INDEX][positionSwimmerUn] = EAU; piscine[SWIMMER_UN_INDEX][positionSwimmerUn - 1] = EAU; piscine[SWIMMER_UN_INDEX][positionSwimmerUn - 2] = EAU;
					positionSwimmerUn += 3; swimmerUnDistance += 3;
				}
			break;
			}		
		}
		//---Si nageur en bout de piscine
		if(positionSwimmerUn == TAILLE_PISCINE - 1) {
			piscine[SWIMMER_UN_INDEX][TAILLE_PISCINE - 3] = TETE; piscine[SWIMMER_UN_INDEX][TAILLE_PISCINE - 2] = CORPS; piscine[SWIMMER_UN_INDEX][TAILLE_PISCINE - 1] = JAMBES;
			positionSwimmerUn = TAILLE_PISCINE - 3;
			swimmerUnDistance += 3;
			swimmerUnReturn = true;
		}
		
		//--si victoire, ajuste classement
		if(playerOneWin) {
			classement(tabClassement, 1);
		}
		
	}
	//avancer nageur deux
	public static void moveSwimmerTwo(char[][]piscine, int power) {
		
		if(swimmerDeuxReturn) {	
			//----RETOUR NAGEUR-----------------
			switch (power) {
			case 1: 
				piscine[SWIMMER_DEUX_INDEX][positionSwimmerDeux - 1] = TETE; piscine[SWIMMER_DEUX_INDEX][positionSwimmerDeux] = CORPS; piscine[SWIMMER_DEUX_INDEX][positionSwimmerDeux + 1] = JAMBES; piscine[SWIMMER_DEUX_INDEX][positionSwimmerDeux + 2] = EAU;
				positionSwimmerDeux --; swimmerDeuxDistance ++;
				if(positionSwimmerDeux == 0) {playerTwoWin = true;}
			break;
			case 2:
				//si proche du bord de la piscine
				if(positionSwimmerDeux == 1) {
					piscine[SWIMMER_DEUX_INDEX][0] = TETE; piscine[SWIMMER_DEUX_INDEX][1] = CORPS; piscine[SWIMMER_DEUX_INDEX][2] = JAMBES; piscine[SWIMMER_DEUX_INDEX][3] = EAU;
					playerTwoWin = true;
				}else {
					piscine[SWIMMER_DEUX_INDEX][positionSwimmerDeux - 2] = TETE; piscine[SWIMMER_DEUX_INDEX][positionSwimmerDeux - 1] = CORPS; piscine[SWIMMER_DEUX_INDEX][positionSwimmerDeux ] = JAMBES; piscine[SWIMMER_DEUX_INDEX][positionSwimmerDeux + 1] = EAU; piscine[SWIMMER_DEUX_INDEX][positionSwimmerDeux + 2] = EAU;
					positionSwimmerDeux -= 2; swimmerDeuxDistance += 2;
					if(positionSwimmerDeux == 0) {playerTwoWin = true;}
				}
			break;
			case 3:
				//si proche du bord de la piscine
				if(positionSwimmerDeux == 1 || positionSwimmerDeux == 2) {
					piscine[SWIMMER_DEUX_INDEX][0] = TETE; piscine[SWIMMER_DEUX_INDEX][1] = CORPS; piscine[SWIMMER_DEUX_INDEX][2] = JAMBES; piscine[SWIMMER_DEUX_INDEX][3] = EAU;
					playerOneWin = true;
				}
				piscine[SWIMMER_DEUX_INDEX][positionSwimmerDeux - 3] = TETE; piscine[SWIMMER_DEUX_INDEX][positionSwimmerDeux - 2] = CORPS; piscine[SWIMMER_DEUX_INDEX][positionSwimmerDeux - 1] = JAMBES;piscine[SWIMMER_DEUX_INDEX][positionSwimmerDeux] = EAU; piscine[SWIMMER_DEUX_INDEX][positionSwimmerDeux + 1] = EAU; piscine[SWIMMER_DEUX_INDEX][positionSwimmerDeux + 2] = EAU;
				positionSwimmerDeux -= 3; swimmerDeuxDistance += 3;
				if(positionSwimmerDeux == 0) {playerTwoWin = true;}
			break;
			}		
			
		}else {
			//-----ALLER NAGEUR-------------------------
			switch (power) {
			case 1: 
				piscine[SWIMMER_DEUX_INDEX][positionSwimmerDeux + 1] = TETE; piscine[SWIMMER_DEUX_INDEX][positionSwimmerDeux] = CORPS; piscine[SWIMMER_DEUX_INDEX][positionSwimmerDeux - 1] = JAMBES; piscine[SWIMMER_DEUX_INDEX][positionSwimmerDeux - 2] = EAU;
				positionSwimmerDeux ++; swimmerDeuxDistance ++;
				if(positionSwimmerDeux == TAILLE_PISCINE - 1) {swimmerDeuxReturn = true;}
			break;
			case 2:
				//si position presque bout de piscine
				if(positionSwimmerDeux == TAILLE_PISCINE - 2) {
					piscine[SWIMMER_DEUX_INDEX][TAILLE_PISCINE - 4] = TETE; piscine[SWIMMER_DEUX_INDEX][TAILLE_PISCINE -3] = CORPS; piscine[SWIMMER_DEUX_INDEX][TAILLE_PISCINE -2 ] = JAMBES; 
					positionSwimmerDeux = TAILLE_PISCINE - 4; swimmerDeuxReturn = true; swimmerDeuxDistance += 2; 
				}else {
					piscine[SWIMMER_DEUX_INDEX][positionSwimmerDeux + 2] = TETE; piscine[SWIMMER_DEUX_INDEX][positionSwimmerDeux + 1] = CORPS; piscine[SWIMMER_DEUX_INDEX][positionSwimmerDeux ] = JAMBES; piscine[SWIMMER_DEUX_INDEX][positionSwimmerDeux - 1] = EAU; piscine[SWIMMER_DEUX_INDEX][positionSwimmerDeux - 2] = EAU;
					positionSwimmerDeux += 2;
					swimmerDeuxDistance += 2;
				}
			break;
			case 3:
				//position bord piscine, se retourne
				if(positionSwimmerDeux == TAILLE_PISCINE -2 ) {
					piscine[SWIMMER_DEUX_INDEX][TAILLE_PISCINE - 5] = TETE; piscine[SWIMMER_DEUX_INDEX][TAILLE_PISCINE -4] = CORPS; piscine[SWIMMER_DEUX_INDEX][TAILLE_PISCINE -3 ] = JAMBES; piscine[SWIMMER_DEUX_INDEX][TAILLE_PISCINE - 2] = EAU;
					positionSwimmerDeux = TAILLE_PISCINE - 4; swimmerDeuxReturn = true; swimmerDeuxDistance += 3; 
				} else if(positionSwimmerDeux == TAILLE_PISCINE -3){
					piscine[SWIMMER_DEUX_INDEX][TAILLE_PISCINE - 4] = TETE; piscine[SWIMMER_DEUX_INDEX][TAILLE_PISCINE -3] = CORPS; piscine[SWIMMER_DEUX_INDEX][TAILLE_PISCINE -2 ] = JAMBES;  piscine[SWIMMER_DEUX_INDEX][TAILLE_PISCINE - 5] = EAU;
					positionSwimmerDeux = TAILLE_PISCINE - 5; swimmerDeuxReturn = true; swimmerDeuxDistance += 3; 
				//avance normalement	
				}else {
					piscine[SWIMMER_DEUX_INDEX][positionSwimmerDeux + 3] = TETE; piscine[SWIMMER_DEUX_INDEX][positionSwimmerDeux + 2] = CORPS; piscine[SWIMMER_DEUX_INDEX][positionSwimmerDeux + 1] = JAMBES;piscine[SWIMMER_DEUX_INDEX][positionSwimmerDeux] = EAU; piscine[SWIMMER_DEUX_INDEX][positionSwimmerDeux - 1] = EAU; piscine[SWIMMER_DEUX_INDEX][positionSwimmerDeux - 2] = EAU;
					positionSwimmerDeux += 3; swimmerDeuxDistance += 3;
				}
			break;
			}		
		}
		//---Si nageur en bout de piscine
		if(positionSwimmerDeux == TAILLE_PISCINE - 1) {
			piscine[SWIMMER_DEUX_INDEX][TAILLE_PISCINE - 3] = TETE; piscine[SWIMMER_DEUX_INDEX][TAILLE_PISCINE - 2] = CORPS; piscine[SWIMMER_DEUX_INDEX][TAILLE_PISCINE - 1] = JAMBES;
			positionSwimmerDeux = TAILLE_PISCINE - 3;
			swimmerDeuxDistance += 3;
			swimmerDeuxReturn = true;
		}
		
		//--si victoire, ajuste classement
		if(playerTwoWin) {
			classement(tabClassement, 2);
		}
		
	}
	//avancer nageur trois
	public static void moveSwimmerThree(char[][]piscine, int power) {
		
		if(swimmerTroisReturn) {	
			//----RETOUR NAGEUR-----------------
			switch (power) {
			case 1: 
				piscine[SWIMMER_TROIS_INDEX][positionSwimmerTrois - 1] = TETE; piscine[SWIMMER_TROIS_INDEX][positionSwimmerTrois] = CORPS; piscine[SWIMMER_TROIS_INDEX][positionSwimmerTrois + 1] = JAMBES; piscine[SWIMMER_TROIS_INDEX][positionSwimmerTrois + 2] = EAU;
				positionSwimmerTrois --; swimmerTroisDistance ++;
				if(positionSwimmerTrois == 0) {playerThreeWin = true;}
			break;
			case 2:
				//si proche du bord de la piscine
				if(positionSwimmerTrois == 1) {
					piscine[SWIMMER_TROIS_INDEX][0] = TETE; piscine[SWIMMER_TROIS_INDEX][1] = CORPS; piscine[SWIMMER_TROIS_INDEX][2] = JAMBES; piscine[SWIMMER_TROIS_INDEX][3] = EAU;
					playerThreeWin = true;
				}else {
					piscine[SWIMMER_TROIS_INDEX][positionSwimmerTrois - 2] = TETE; piscine[SWIMMER_TROIS_INDEX][positionSwimmerTrois - 1] = CORPS; piscine[SWIMMER_TROIS_INDEX][positionSwimmerTrois ] = JAMBES; piscine[SWIMMER_TROIS_INDEX][positionSwimmerTrois + 1] = EAU; piscine[SWIMMER_TROIS_INDEX][positionSwimmerTrois + 2] = EAU;
					positionSwimmerTrois -= 2; swimmerTroisDistance += 2;
					if(positionSwimmerTrois == 0) {playerThreeWin = true;}
				}
			break;
			case 3:
				//si proche du bord de la piscine
				if(positionSwimmerTrois == 1 || positionSwimmerTrois == 2) {
					piscine[SWIMMER_TROIS_INDEX][0] = TETE; piscine[SWIMMER_TROIS_INDEX][1] = CORPS; piscine[SWIMMER_TROIS_INDEX][2] = JAMBES; piscine[SWIMMER_TROIS_INDEX][3] = EAU;
					playerOneWin = true;
				}
				piscine[SWIMMER_TROIS_INDEX][positionSwimmerTrois - 3] = TETE; piscine[SWIMMER_TROIS_INDEX][positionSwimmerTrois - 2] = CORPS; piscine[SWIMMER_TROIS_INDEX][positionSwimmerTrois - 1] = JAMBES;piscine[SWIMMER_TROIS_INDEX][positionSwimmerTrois] = EAU; piscine[SWIMMER_TROIS_INDEX][positionSwimmerTrois + 1] = EAU; piscine[SWIMMER_TROIS_INDEX][positionSwimmerTrois + 2] = EAU;
				positionSwimmerTrois -= 3; swimmerTroisDistance += 3;
				if(positionSwimmerTrois == 0) {playerThreeWin = true;}
			break;
			}		
			
		}else {
			//-----ALLER NAGEUR-------------------------
			switch (power) {
			case 1: 
				piscine[SWIMMER_TROIS_INDEX][positionSwimmerTrois + 1] = TETE; piscine[SWIMMER_TROIS_INDEX][positionSwimmerTrois] = CORPS; piscine[SWIMMER_TROIS_INDEX][positionSwimmerTrois - 1] = JAMBES; piscine[SWIMMER_TROIS_INDEX][positionSwimmerTrois - 2] = EAU;
				positionSwimmerTrois ++; swimmerTroisDistance ++;
				if(positionSwimmerTrois == TAILLE_PISCINE - 1) {swimmerTroisReturn = true;}
			break;
			case 2:
				//si position presque bout de piscine
				if(positionSwimmerTrois == TAILLE_PISCINE - 2) {
					piscine[SWIMMER_TROIS_INDEX][TAILLE_PISCINE - 4] = TETE; piscine[SWIMMER_TROIS_INDEX][TAILLE_PISCINE -3] = CORPS; piscine[SWIMMER_TROIS_INDEX][TAILLE_PISCINE -2 ] = JAMBES; 
					positionSwimmerTrois = TAILLE_PISCINE - 4; swimmerTroisReturn = true; swimmerTroisDistance += 2; 
				}else {
					piscine[SWIMMER_TROIS_INDEX][positionSwimmerTrois + 2] = TETE; piscine[SWIMMER_TROIS_INDEX][positionSwimmerTrois + 1] = CORPS; piscine[SWIMMER_TROIS_INDEX][positionSwimmerTrois ] = JAMBES; piscine[SWIMMER_TROIS_INDEX][positionSwimmerTrois - 1] = EAU; piscine[SWIMMER_TROIS_INDEX][positionSwimmerTrois - 2] = EAU;
					positionSwimmerTrois += 2;
					swimmerTroisDistance += 2;
				}
			break;
			case 3:
				//position bord piscine, se retourne
				if(positionSwimmerTrois == TAILLE_PISCINE -2 ) {
					piscine[SWIMMER_TROIS_INDEX][TAILLE_PISCINE - 5] = TETE; piscine[SWIMMER_TROIS_INDEX][TAILLE_PISCINE -4] = CORPS; piscine[SWIMMER_TROIS_INDEX][TAILLE_PISCINE -3 ] = JAMBES; piscine[SWIMMER_TROIS_INDEX][TAILLE_PISCINE - 2] = EAU;
					positionSwimmerTrois = TAILLE_PISCINE - 4; swimmerTroisReturn = true; swimmerTroisDistance += 3; 
				} else if(positionSwimmerTrois == TAILLE_PISCINE -3){
					piscine[SWIMMER_TROIS_INDEX][TAILLE_PISCINE - 4] = TETE; piscine[SWIMMER_TROIS_INDEX][TAILLE_PISCINE -3] = CORPS; piscine[SWIMMER_TROIS_INDEX][TAILLE_PISCINE -2 ] = JAMBES;  piscine[SWIMMER_TROIS_INDEX][TAILLE_PISCINE - 5] = EAU;
					positionSwimmerTrois = TAILLE_PISCINE - 5; swimmerTroisReturn = true; swimmerTroisDistance += 3; 
				//avance normalement	
				}else {
					piscine[SWIMMER_TROIS_INDEX][positionSwimmerTrois + 3] = TETE; piscine[SWIMMER_TROIS_INDEX][positionSwimmerTrois + 2] = CORPS; piscine[SWIMMER_TROIS_INDEX][positionSwimmerTrois + 1] = JAMBES;piscine[SWIMMER_TROIS_INDEX][positionSwimmerTrois] = EAU; piscine[SWIMMER_TROIS_INDEX][positionSwimmerTrois - 1] = EAU; piscine[SWIMMER_TROIS_INDEX][positionSwimmerTrois - 2] = EAU;
					positionSwimmerTrois += 3; swimmerTroisDistance += 3;
				}
			break;
			}		
		}
		//---Si nageur en bout de piscine
		if(positionSwimmerTrois == TAILLE_PISCINE - 1) {
			piscine[SWIMMER_TROIS_INDEX][TAILLE_PISCINE - 3] = TETE; piscine[SWIMMER_TROIS_INDEX][TAILLE_PISCINE - 2] = CORPS; piscine[SWIMMER_TROIS_INDEX][TAILLE_PISCINE - 1] = JAMBES;
			positionSwimmerTrois = TAILLE_PISCINE - 3;
			swimmerTroisDistance += 3;
			swimmerTroisReturn = true;
		}
		
		//--si victoire, ajuste classement
		if(playerThreeWin) {
			classement(tabClassement, 3);
		}
		
	}
		
	//generer random entre 0 et 3 (nombre de case dont avance le nageur)
	public static int generateRandomPower() {
		Random random = new Random();
		return random.nextInt(4);
	}
	//generer random entre 1 et 3 (quel nageur avance)
	public static int generateRandomSwimmer() {
		Random random = new Random();
		return 1 + (random.nextInt(3));
	}
	//afficher quel nageur avance et de combien il avance
	public static void printSwimmerAndPower(int swimmer, int power) {
		switch (swimmer) {
		case 1:	System.out.println(swimmerUn + " avance de " + power + " mètres !");
		break;
		case 2:	System.out.println(swimmerDeux + " avance de " + power + " mètres !");
		break;
		case 3:	System.out.println(swimmerTrois + " avance de " + power + " mètres !");
		break;
		}
	}
	
	//--init tableau piscine
	public static void initPiscine(char[][]piscine) {
		for(int i = 0; i < NOMBRE_LIGNES; i++) {
			for (int j = 0; j < TAILLE_PISCINE; j++) {
				piscine[i][j] = EAU;
			}
		}	
		piscine[0][0] = JAMBES; piscine[0][1] = CORPS; piscine[0][2] = TETE;
		piscine[1][0] = JAMBES; piscine[1][1] = CORPS;piscine[1][2] = TETE;
		piscine[2][0] = JAMBES; piscine[2][1] = CORPS;piscine[2][2] = TETE;
	}
	
	//--afficher piscine
	public static void afficherPiscine(char[][]piscine){
		//bord haut piscine
		System.out.print(" ");
		for(int j = 0; j < TAILLE_PISCINE; j++) {
			System.out.print(BORDS_PISCINE_HORIZ);
		}
		System.out.println();
		
		//piscine
		for(int i = 0; i < NOMBRE_LIGNES; i++ ) {
			//bord piscine gauche
			System.out.print(BORDS_PISCINE_VERT);
			
			for(int j=0; j < TAILLE_PISCINE; j++) {
				System.out.print(piscine[i][j]);
			}
			//bord piscine droit
			System.out.println(BORDS_PISCINE_VERT);	
		}	
		//bord bas piscine
		System.out.print(" ");
		for(int j = 0; j < TAILLE_PISCINE; j++) {
			System.out.print(BORDS_PISCINE_HORIZ);
		}
		System.out.println();
		System.out.print(swimmerUn + " " + swimmerUnDistance + "/50m");
		if(playerOneWin) {System.out.print(" : Terminé !");}
		System.out.println();
		System.out.print(swimmerDeux + " " + swimmerDeuxDistance + "/50m");
		if(playerTwoWin) {System.out.print(" : Terminé !");}
		System.out.println();
		System.out.print(swimmerTrois + " " + swimmerTroisDistance + "/50m");
		if(playerThreeWin) {System.out.print(" : Terminé !");}
		System.out.println();
	}
	
	//--inti tableau classement
	public static int[][] initTabClassement(){
		int[][]tabClassement = new int[2][3];
		for(int j = 0; j < 3; j++) {
			tabClassement[0][j] = j;
			tabClassement[1][j] = 0;
		}
		return tabClassement;
		
	}
	
	//---affiche tableau classement
	public static void afficheTabClassement(int[][]tabClassement) {
		for(int i = 0; i<2; i++) {
			for(int j = 0; j<3; j++) {
				System.out.print(tabClassement[i][j]);
			}
			System.out.println();
		}
	}
	//-- mise a jour classement
	public static void classement(int[][]tabClassement, int swimmer) {
		if(tabClassement[1][0] == 0) {
			tabClassement[1][0] = swimmer;
		}else if(tabClassement[1][1] == 0) {
			tabClassement[1][1] = swimmer;
		}else {
			tabClassement[1][2] = swimmer;
		}
	}

}
