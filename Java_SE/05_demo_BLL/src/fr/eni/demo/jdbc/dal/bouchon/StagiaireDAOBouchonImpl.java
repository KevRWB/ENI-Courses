package fr.eni.demo.jdbc.dal.bouchon;

import java.util.ArrayList;
import java.util.List;

import fr.eni.demo.jdbc.bo.Stagiaire;
import fr.eni.demo.jdbc.dal.StagiaireDAO;

public class StagiaireDAOBouchonImpl implements StagiaireDAO {

	private List<Stagiaire> stagiaires = new ArrayList<Stagiaire>();
	
	public StagiaireDAOBouchonImpl() {
		stagiaires.add(new Stagiaire("Titi", "Toto", "email", "password"));
	}
	
	@Override
	public List<Stagiaire> selectAll() {
		return stagiaires;
	}

	@Override
	public void insertStagiaire(Stagiaire stagiaire) {
		stagiaires.add(stagiaire);
	}

}
