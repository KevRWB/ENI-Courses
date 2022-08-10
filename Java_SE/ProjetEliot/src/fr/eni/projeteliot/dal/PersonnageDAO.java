package fr.eni.projeteliot.dal;

import java.util.List;

import fr.eni.projeteliot.bo.Personnage;

public interface PersonnageDAO {

	List<Personnage> selectAll();
	
	void insert(Personnage personnage);
	
	void delete(int id);
	
}
