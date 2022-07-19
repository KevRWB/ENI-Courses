package fr.eni.ecole.baseDuLangage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class JeuDeLettres {

	public static void main(String[] args) {
		try {
			char[] motAlea=tirerMotAleatoirement();
			
			afficher(motAlea);
			char[] motMelanger=melanger(motAlea);
			afficher(motMelanger);
			System.out.println("Quelle est votre proposition ?");
			Scanner sc =new Scanner(System.in);
			char[] tabMotPropose=sc.nextLine().toUpperCase().toCharArray();
			boolean ok=bonnesLettres(motMelanger,tabMotPropose) ;
			System.out.println(ok);
			

			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static char[] tirerMotAleatoirement() throws FileNotFoundException, IOException {
		char[] tableau=null;
		try (
				//charge le flux d'entrée
				FileInputStream fichier = new FileInputStream("./dictionnaire.txt");
				FileInputStream fichier2 = new FileInputStream("./dictionnaire.txt");
				//je met le fux dans un scanner pour pouvoir le lire
				Scanner s= new Scanner(fichier);
				Scanner s2=new Scanner(fichier2);
				){
			// j'initialise mon nombre de mot à zéro
			int nbMots=0;
			//tant que j'ai une ligne qui suit
			while(s.hasNextLine()) {
				//j'incrémente mon nombre de ligne
				nbMots++;
				//je passe à la ligne suivante
				s.nextLine();
			}
			// je recupere l'objet random rnd et je l'initialise
			Random rnd = new Random();
			// je crée un nombre entier aleatoire par rapport au nombre de mot du dictionnaire
			int nbAlea = rnd.nextInt(nbMots)+1;

			// je parcours le fichier jusqu'au nombre tiré au sort
			for(int i=1;i<=nbAlea;i++)
			{
				// je passe à la ligne suivante
				s2.nextLine();
			}
			// j'indique que mon tableau de chaîne est la ligne actuelle
			//à mettre en majuscule et à convertir en tableau
			tableau=s2.nextLine().toUpperCase().toCharArray();
		}
		// je retourne le tableau
		return tableau;
	}
private static char[] melanger(char[] tabAmelanger) {
	char[] tabMelange= new char[tabAmelanger.length];
	// clonage du tableau
	for(int i=0;i<tabAmelanger.length;i++)
	{
		tabMelange[i]=tabAmelanger[i];
	}
//	char[] tabMelange= Arrays.copyOf(tabAmelanger, tabAmelanger.length);
	Random rnd = new Random();
	for(int i=0;i<tabMelange.length;i++)
	{
		int positionLettre1=rnd.nextInt(tabMelange.length);
		int positionLettre2=rnd.nextInt(tabMelange.length);
		char tmp=tabMelange[positionLettre1];
		tabMelange[positionLettre1]=tabMelange[positionLettre2];
		tabMelange[positionLettre2]=tmp;
	}
	return tabMelange;
}
private static void afficher(char[] motAafficher)
{
//	for(int i=0;i<motAafficher.length;i++)
//	{
//		System.out.print(motAafficher[i]);
//	}
	System.out.println(motAafficher);

}

private static boolean bonnesLettres(char[]lettresDuTirage,char[] motJoueur) {
	
	char[] copie=Arrays.copyOf(lettresDuTirage, lettresDuTirage.length);
	int j=0;
	boolean ok=true;
	while(ok && j<motJoueur.length)
	{
		int k=0;
		while( k<copie.length && motJoueur[j]!=copie[k])
		{
			k++;
		}
		if (k==copie.length) {
			ok=false;
		}
		else {
			copie[k]=' ';
			j++;
		}
	}
	return ok;
}


}
