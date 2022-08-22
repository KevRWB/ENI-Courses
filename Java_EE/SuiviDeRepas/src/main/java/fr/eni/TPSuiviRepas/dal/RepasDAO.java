package fr.eni.TPSuiviRepas.dal;

import java.sql.SQLException;
import java.util.List;

import fr.eni.TPSuiviRepas.Exceptions.BusinessException;
import fr.eni.TPSuiviRepas.bo.Repas;

public interface RepasDAO {
	public void insert(Repas repas) throws BusinessException, SQLException;
	public List<Repas> selectAll () throws BusinessException;
}
