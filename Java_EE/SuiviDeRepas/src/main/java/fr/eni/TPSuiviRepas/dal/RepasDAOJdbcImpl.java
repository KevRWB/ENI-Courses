package fr.eni.TPSuiviRepas.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


import fr.eni.TPSuiviRepas.Exceptions.BusinessException;
import fr.eni.TPSuiviRepas.bo.Aliment;
import fr.eni.TPSuiviRepas.bo.Repas;

public class RepasDAOJdbcImpl implements RepasDAO{
	
	private static final String INSERT_REPAS = "INSERT INTO REPAS (DATE_REPAS, HEURE_REPAS) VALUES(?,?)";
	private static final String INSERT_ALIMENTS = "INSERT INTO ALIMENTS(NOM, ID_REPAS) VALUES (?,?)";
	private static final String SELECT_ALL = "SELECT * FROM REPAS JOIN ALIMENTS";
	
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
	
	private Repas mapRepas(ResultSet rs, List<Aliment> list) throws SQLException {
		Repas repas = null;
		
		int idArticle = rs.getInt("idArticle");
		LocalDate date =  (LocalDate) rs.getString("DATE_REPAS").toLocalDate();
		LocalTime marque = (LocalTime)rs.getString("HEURE_REPAS").toLocalTime();
			
		return repas;
	}
	
	private Aliment mapAliments(ResultSet rs)throws SQLException {
		Aliment aliment = null;
		
		String nom = rs.getString("NOM");
		int idRepas = rs.getInt("ID_REPAS");
		
		return aliment;
	}

	@Override
	public List<Repas> selectAll() throws BusinessException, SQLException {
		List<Repas> list = new ArrayList<>();
		try(Connection cnx = ConnectionProvider.getConnection()){
			Statement stmt = cnx.createStatement();
			
			ResultSet rs = stmt.executeQuery(SELECT_ALL);
			while(rs.next()) {
				Repas r = map(rs); //transforme une ligne d'enregistrement en objet
				list.add(r); //ajoute l'objet � la liste
			}
					 			
		}
				
		return list;
	}

}
