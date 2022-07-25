package fr.eni.ecole.quelMedecin.bo;

import java.time.LocalTime;

public class MedecinGeneraliste extends Medecin{

	private static int tarif=25;

	public MedecinGeneraliste(String nom, String prenom, String numTel, Adresse adresse) {
		super(nom,prenom,numTel,adresse);
	}
	

public static int getTarif() {
		return tarif;
	}

public static void setTarif(int tarif) {
		MedecinGeneraliste.tarif = tarif;
	}
public void afficher() {
//	System.out.println(this.nom+" "+this.prenom);
//	System.out.println("Téléphone :"+this.numeroDeTelephone);
//	System.out.println("Tarif :"+this.tarif+"€");
//	System.out.println("Adresse :"+this.adresse);
//	if (nbCreneaux==0)
//	{
//		System.out.println("[Pas de créneau]");
//	}
//	else
//	{
//		System.out.println("Créneaux :");
//		for(int i=0;i<nbCreneaux;i++)
//		{
//			this.creneaux[i].afficher();
//		}
//	}
	//équivalent à
		StringBuilder sb = new StringBuilder();
	sb.append(super.toString());
	sb.append(String.format("%n"));
	sb.append("Tarif:");
	sb.append(MedecinGeneraliste.tarif);
	sb.append("€");
	sb.append(String.format("%n"));
	sb.append("Adresse:");
	sb.append(String.format("%n"));
	sb.append(this.adresse);
	sb.append(String.format("%n"));
	sb.append(this.afficheCreneaux());
	System.out.println(sb.toString());
}



}
