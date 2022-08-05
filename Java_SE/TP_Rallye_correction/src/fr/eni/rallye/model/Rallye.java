package fr.eni.rallye.model;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.Stream;

public class Rallye {
	
	private Date date;
	
	private String pays;
	
	private Speciale[] speciales = new Speciale[20];
	
	private int specialeIndex = 0;

	public Rallye(String pays, Date date) {
		this.pays = pays;
		this.date = date;
	}
	
	public void ajouterSpeciale(Speciale speciale) {
		speciales[specialeIndex] = speciale;
		specialeIndex++;
	}
	
	public String infosRallye(boolean inclureSpeciales) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		StringBuilder sb = new StringBuilder("Rallye [date=");
		sb.append(sdf.format(date))
			.append(", pays=")
			.append(pays)
			.append("]")
			.append(System.lineSeparator());
		if(inclureSpeciales) {
			for(int i = 0 ; i < specialeIndex ; i++) {
				sb.append("\t")
				  .append(speciales[i].infosSpeciale())
				  .append(System.lineSeparator());
			}
		}
		return sb.toString();
	}
	
	public Speciale getSpeciale(String nom) {
		
		return Stream.of(speciales) //on transforme le tableau en stream
					 .filter(s -> s.getNom().equals(nom)) //on ne garde que ceux qui ont pour nom le nom envoyé en paramètre
					 .findFirst() //on garde le premier
					 .orElse(null); //s'il n'existe pas, renvoie null
//		for(int i = 0 ; i < specialeIndex ; i++) {
//			if(speciales[i].getNom().equals(nom)) {
//				return speciales[i];
//			}
//		}
//		return null;
	}

	public Classement[] getClassementGeneral() {

		//1. on concatène tous les résultats ensemble
		//Au total, on peut avoir 20 (spéciales) x 50 (résultats) = 1000 résultats possibles
		Resultat[] tousLesResultats = new Resultat[1000];
		int nbDeResultats = 0;
		//on prend toutes les spéciales 1 par 1
		for(int s = 0 ; s < specialeIndex ; s++) {
			//récupère le classement de la spéciale
			Resultat[] tmp = speciales[s].getClassement();
			//on prend chaque résultat dans ce classement
			for(int r = 0 ; r < tmp.length ; r++) {
				//on ajoute chaque résultat dans le grand tableau des résultats
				tousLesResultats[nbDeResultats++] = tmp[r];
			}
		}
		
		//on ne garde que le sous-tableau où il y a ds résultats (on supprime les null)
		tousLesResultats = Arrays.copyOf(tousLesResultats, nbDeResultats);
		
		//on trie l'ensemble des résultats par équipage
		tousLesResultats = ClassementUtil.classerParEquipage(tousLesResultats);
		
		//calcule les temps cumulés pour chaque équipage
		Classement[] classementGeneral = new Classement[tousLesResultats.length];
		int indexClassement = 0;
		Equipage equipagePrecedent = tousLesResultats[0].getEquipage();
		long tpsCumule = tousLesResultats[0].getTemps().getTime();
		//parcours tous les résultats
		for(int i = 1 ; i < tousLesResultats.length ; i++) {
			//cumule les temps s''il s'agit du même équipage
			if(tousLesResultats[i].getEquipage().getDossard() == equipagePrecedent.getDossard()) {
				tpsCumule += tousLesResultats[i].getTemps().getTime();
			} else {
				//sinon, ajoute un nouveau classement au classement général
				classementGeneral[indexClassement++] = new Classement(equipagePrecedent, new Date(tpsCumule));
				
				equipagePrecedent = tousLesResultats[i].getEquipage();
				tpsCumule = tousLesResultats[i].getTemps().getTime();
			}
		}
		// ! Ne pas oublier la dernière équipe
		classementGeneral[indexClassement++] = new Classement(equipagePrecedent, new Date(tpsCumule));
		//on enlève les cases null
		classementGeneral = Arrays.copyOf(classementGeneral, indexClassement);
		
		classementGeneral = ClassementUtil.classerParTemps(classementGeneral);
		
		return classementGeneral;
		
	}
}


