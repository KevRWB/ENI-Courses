package fr.eni.demo.jdbc.bll;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.eni.demo.jdbc.bo.Stagiaire;
import fr.eni.demo.jdbc.dal.DALException;
import fr.eni.demo.jdbc.dal.DAOFactory;

public class StagiaireManager {

	/*
	 * PATTERN SINGLETON
	 */
	
	private static StagiaireManager instance;
	
	private StagiaireManager() { }
	
	public static StagiaireManager getInstance() {
		if(instance == null) {
			instance = new StagiaireManager();
		}
		return instance;
	}
	
	/*
	 * FIN PATTERN SINGLETON
	 */
	
	
	public List<Stagiaire> selectAll() throws BLLException {
		try {
			return DAOFactory.getStagiaireDAO().selectAll();
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException("Erreur lors du selectAll : " + e.getMessage());
		}
	}

	public Stagiaire insertStagiaire(String nom, String prenom, 
								String email, String password) throws BLLException {

		//1. vérification des données
		verificationNom(nom);
		verificationPrenom(prenom);
		verificationEmail(email);
		verificationPassword(password);
		
		//2. si on arrive ici, c'est que les données sont vérifiées
		
		//3. création de l'objet
		Stagiaire nouveauStagiaire = new Stagiaire(nom, prenom, email, password);
		//4. envoie à la DAL
		try {
			DAOFactory.getStagiaireDAO().insertStagiaire(nouveauStagiaire);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException(e.getMessage());
		}
		
		return nouveauStagiaire;
	}

	private void verificationNom(String nom) throws BLLException {
		//avant Java 11 : nom.trim().isEmpty()
		if(nom == null || nom.isBlank() || nom.length() > 30) {
			throw new BLLException("Le nom est obligatoire et sa taille < 30");
		}
	}
	
	private void verificationPrenom(String prenom) throws BLLException {
		//avant Java 11 : nom.trim().isEmpty()
		if(prenom == null || prenom.isBlank() || prenom.length() > 30) {
			throw new BLLException("Le prénom est obligatoire et sa taille < 30");
		}
	}
	
	private void verificationEmail(String email) throws BLLException {
		String regex = "^(.+)@(.+)$"; 
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		
		//avant Java 11 : nom.trim().isEmpty()
		if(email == null || email.isBlank() || email.length() > 250) {
			throw new BLLException("L'email est obligatoire et sa taille < 250");
		} else {
			if(!matcher.matches()) {
				throw new BLLException("Format de l'email incorrect");
			}
		}
	}
	
	private void verificationPassword(String password) throws BLLException {
		//avant Java 11 : nom.trim().isEmpty()
		if(password == null || password.isBlank() || password.length() > 250) {
			throw new BLLException("Le mot de passe est obligatoire et sa taille < 250");
		}
	}	
	
}
