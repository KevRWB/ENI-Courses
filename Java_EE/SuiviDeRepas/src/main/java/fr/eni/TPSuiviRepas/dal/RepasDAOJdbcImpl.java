package fr.eni.TPSuiviRepas.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Date;
import java.util.List;


import fr.eni.TPSuiviRepas.Exceptions.BusinessException;
import fr.eni.TPSuiviRepas.bo.Aliment;
import fr.eni.TPSuiviRepas.bo.Repas;

public class RepasDAOJdbcImpl implements RepasDAO{
	
	private static final String INSERT_REPAS = "INSERT INTO REPAS (DATE_REPAS, HEURE_REPAS) VALUES(?,?)";
	private static final String INSERT_ALIMENTS = "INSERT INTO ALIMENTS(NOM, ID_REPAS) VALUES (?,?)";
	
	@Override
	public void insert(Repas repas) throws BusinessException, SQLException{
		int repasId = 0;
		
		try(Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement pstmp = cnx.prepareStatement(INSERT_REPAS, PreparedStatement.RETURN_GENERATED_KEYS);
	
			pstmp.setDate(1, Date.valueOf(repas.getDate()));
			pstmp.setTime(2, Time.valueOf(repas.getHeure()));
			pstmp.executeUpdate();
			ResultSet rs = pstmp.getGeneratedKeys();
			if (rs.next()) {
				repasId = rs.getInt(1);
				repas.setId(repasId);
				System.out.println("repas id : " + repasId);
			}
			
			for(Aliment aliment : repas.getListeAliments()) {
				PreparedStatement pstmpAliment = cnx.prepareStatement(INSERT_ALIMENTS);
				System.out.println("nom aliment : " + aliment.getNom());
				pstmpAliment.setString(1, aliment.getNom());
				pstmpAliment.setInt(2, repasId);
				pstmpAliment.executeUpdate();
			}
			
		}
	}

	@Override
	public List<Repas> selectAll() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
