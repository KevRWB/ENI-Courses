package fr.eni.demo.jdbc.dal;

import java.sql.SQLException;
import java.util.List;

import fr.eni.demo.jdbc.bo.Stagiaire;

public interface StagiaireDAO {

	List<Stagiaire> selectAll() throws DALException ;

	void insertStagiaire(Stagiaire stagiaire) throws DALException;

}