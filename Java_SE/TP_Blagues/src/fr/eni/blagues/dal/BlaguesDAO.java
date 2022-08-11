package fr.eni.blagues.dal;

import java.util.List;

import fr.eni.blagues.bo.Blague;

public interface BlaguesDAO {

	void insert(Blague Blague) throws DALException;

	List<Blague> selectAll() throws DALException;
	
	Blague selectTopUn() throws DALException;

	void update(Blague Blague) throws DALException;

}