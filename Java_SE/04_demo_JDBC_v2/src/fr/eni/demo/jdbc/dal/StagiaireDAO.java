package fr.eni.demo.jdbc.dal;

import java.util.List;

import fr.eni.demo.jdbc.bo.Stagiaire;

public interface StagiaireDAO {

	List<Stagiaire> selectAll();

	void insertStagiaire(Stagiaire stagiaire);

}