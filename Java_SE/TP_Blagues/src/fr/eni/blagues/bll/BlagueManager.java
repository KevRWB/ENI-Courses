package fr.eni.blagues.bll;

import java.util.List;

import fr.eni.blagues.bo.Blague;
import fr.eni.blagues.dal.BlaguesDAO;
import fr.eni.blagues.dal.DALException;
import fr.eni.blagues.dal.DAOFactory;

public class BlagueManager {
	private static BlagueManager instance;
	
	//SINGLETON
	private BlaguesDAO dao;
	
	private BlagueManager() {
		dao = DAOFactory.getBlagueDAO();
	}

	public static BlagueManager getInstance() {
		if (instance == null) {
			instance = new BlagueManager();
		}
		return instance;
	}
	//FIN SINGLETON
	
	//METHODS
	public void insert(Blague Blague) throws BLLException{
	// 1. validation des donn�es de l'article
		ValiderBlague(Blague);

		// 2. si la blague est valide, on envoie à la DAL
		try {
			dao.insert(Blague);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException(e.getMessage());
		}
	};

	public List<Blague> selectAll()  throws BLLException{
		try {
			return dao.selectAll();
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException(e.getMessage());
		}
	};
	
	public Blague selectTopUn()  throws BLLException{
		try {
			return dao.selectTopUn();
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException(e.getMessage());
		}
	};

	public void update(Blague Blague)  throws BLLException{
	// 1. validation des donn�es de l'article
		ValiderBlague(Blague);

		//2. si la blague est valide, on envoie à la DAL
		try {
			dao.update(Blague);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException(e.getMessage());
		}
	};
	
	//VALIDATION
	private void ValiderBlague(Blague a) throws BLLException {
		validationTxtBlague(a.getTxtBlague());
		
		
	}
	private void validationTxtBlague(String txtBlague) throws BLLException {
		if (txtBlague == null || txtBlague.isBlank() || txtBlague.length() > 250) {
			throw new BLLException("Le texte est obligatoire et doit �tre <= 250 caract�res");
		}
	}
	
}
