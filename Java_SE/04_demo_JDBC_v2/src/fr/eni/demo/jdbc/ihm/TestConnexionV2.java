package fr.eni.demo.jdbc.ihm;

import java.util.List;

import fr.eni.demo.jdbc.bo.Stagiaire;
import fr.eni.demo.jdbc.dal.DAOFactory;
import fr.eni.demo.jdbc.dal.StagiaireDAO;

public class TestConnexionV2 {

	public static void main(String[] args) {
		
		StagiaireDAO dao = DAOFactory.getStagiaireDAO();
		
		List<Stagiaire> stagiaires = dao.selectAll();
		System.out.println(stagiaires);
		
		String nomNouveauStagiaire = "Titgoutte";
		String prenomNouveauStagiaire = "Justine";
		String emailNouveauStagiaire = "justine@gmail.com";
		String pwdNouveauStagiaire = "ABCD";
		
		dao.insertStagiaire(new Stagiaire(nomNouveauStagiaire, 
										prenomNouveauStagiaire, 
										emailNouveauStagiaire, 
										pwdNouveauStagiaire));
		
	}

}
