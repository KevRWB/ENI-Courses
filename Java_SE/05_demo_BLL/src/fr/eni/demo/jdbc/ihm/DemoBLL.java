package fr.eni.demo.jdbc.ihm;

import java.util.List;

import fr.eni.demo.jdbc.bll.BLLException;
import fr.eni.demo.jdbc.bll.StagiaireManager;
import fr.eni.demo.jdbc.bo.Stagiaire;

public class DemoBLL {

	public static void main(String[] args) {
		
		
		StagiaireManager manager = StagiaireManager.getInstance();
		
		try {
			List<Stagiaire> stagiaires = manager.selectAll();
			System.out.println(stagiaires);
		} catch (BLLException e) {
			e.printStackTrace();
		}
		
		String nomNouveauStagiaire = "gdfgdfg";
		String prenomNouveauStagiaire = "Justine";
		String emailNouveauStagiaire = "justine@gmail.com";
		String pwdNouveauStagiaire = "ABCD";
		
		Stagiaire stagiaire;
		try {
			stagiaire = manager.insertStagiaire(nomNouveauStagiaire, 
												prenomNouveauStagiaire, 
												emailNouveauStagiaire, 
												pwdNouveauStagiaire);
			System.out.println(stagiaire);
		} catch (BLLException e) {
			e.printStackTrace();
		}	
		
		System.out.println("FIN DE L'APPLI");
	}

}
