package fr.eni.TPSuiviRepas.dal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.TPSuiviRepas.Exceptions.BusinessException;
import fr.eni.TPSuiviRepas.bo.Repas;

public class TestDal {
	private static RepasDAO repasDao = new DAOFactory().getRepasDAO();
	
	public static void main(String[] args) throws BusinessException, SQLException {
		
		
		List<Repas> listeRepas = new ArrayList<>();
		
		listeRepas = repasDao.selectAll();
		
		for(Repas repas : listeRepas) {
			System.out.println("Repas : " + repas + " Aliments: " + repas.getListeAliments());
		}
	}

}
