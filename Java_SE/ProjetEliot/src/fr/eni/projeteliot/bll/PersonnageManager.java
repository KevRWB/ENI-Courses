package fr.eni.projeteliot.bll;

import java.time.LocalDate;
import java.util.List;

import fr.eni.projeteliot.bo.Personnage;
import fr.eni.projeteliot.bo.Race;
import fr.eni.projeteliot.dal.DAOFactory;

public class PersonnageManager {

	//SINGLETON
	private static PersonnageManager instance;
	
	private PersonnageManager() { }
	
	public static PersonnageManager getInstance() {
		if(instance == null) {
			instance = new PersonnageManager();
		}
		return instance;
	}
	//FIN SINGLETON
	
	public List<Personnage> selectAll() {
		return DAOFactory.getPersonnageDAO().selectAll();
	}
	
	public Personnage insert(String nom, LocalDate dateNaissance, int idRace) {
		
		validationNom(nom);
		validationDateNaissance(dateNaissance);
		validationIdRace(idRace);
		
		Race r = new Race(idRace);
		
		Personnage nouveauPersonnage = new Personnage(nom, dateNaissance, r);
		
		DAOFactory.getPersonnageDAO().insert(nouveauPersonnage);
		
		return nouveauPersonnage;
	}
	
	private void validationIdRace(int idRace) {
		// TODO Auto-generated method stub
		
	}

	private void validationDateNaissance(LocalDate dateNaissance) {
		// TODO Auto-generated method stub
		
	}

	private void validationNom(String nom) {
		// TODO Auto-generated method stub
		
	}

	public void delete(int id) {
		
	}
	
	
}
