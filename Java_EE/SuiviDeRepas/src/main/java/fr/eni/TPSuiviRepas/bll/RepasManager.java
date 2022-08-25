package fr.eni.TPSuiviRepas.bll;

import java.sql.SQLException;
import java.util.List;

import fr.eni.TPSuiviRepas.Exceptions.BusinessException;
import fr.eni.TPSuiviRepas.bo.Repas;
import fr.eni.TPSuiviRepas.dal.DAOFactory;
import fr.eni.TPSuiviRepas.dal.RepasDAO;

public class RepasManager {
	
	private RepasDAO repasDAO;
	
	public RepasManager() {
		this.repasDAO = DAOFactory.getRepasDAO();
	}
	
	public Repas ajouter(Repas repas) throws BusinessException, SQLException {
		this.repasDAO.insert(repas);
		return repas;
	}
	
	public List<Repas> selectAll ()  throws BusinessException, SQLException{
		return repasDAO.selectAll();
	}
}
