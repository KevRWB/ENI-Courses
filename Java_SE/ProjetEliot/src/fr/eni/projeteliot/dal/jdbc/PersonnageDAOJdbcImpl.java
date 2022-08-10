package fr.eni.projeteliot.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.sun.net.httpserver.Authenticator.Result;

import fr.eni.projeteliot.bo.Personnage;
import fr.eni.projeteliot.bo.Race;
import fr.eni.projeteliot.dal.PersonnageDAO;

public class PersonnageDAOJdbcImpl implements PersonnageDAO {

	private final static String SELECT_ALL = "SELECT * " +
											 "FROM Personnages " +
											 "INNER JOIN Races ON idRace=race";
	
	@Override
	public List<Personnage> selectAll() {
		List<Personnage> personnages = new ArrayList<Personnage>();
		
		try(Connection cnx = JdbcTools.getConnection()) {
			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL);
			while(rs.next()) {
				int idPersonnage = rs.getInt("idPersonnage");
				String nomPersonnage = rs.getString("nomPersonnage");
				LocalDate dateNaissance = rs.getDate("dateNaissance").toLocalDate();
				int idRace = rs.getInt("idRace");
				String nomRace = rs.getString("nom");
				
				Personnage p = new Personnage(idPersonnage, nomPersonnage, dateNaissance, new Race(idRace, nomRace));
				personnages.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return personnages;
	}

	@Override
	public void insert(Personnage personnage) {
		final String INSERT = "INSERT INTO Personnages(nomPersonnage,dateNaissance,race) VALUES(?,?,?)";
		try(Connection cnx = JdbcTools.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, personnage.getNom());
			pStmt.setDate(2, Date.valueOf(personnage.getDateNaissance()));
			pStmt.setInt(3, personnage.getRace().getId());
			
			pStmt.executeUpdate();
			
			ResultSet rs = pStmt.getGeneratedKeys();
			if(rs.next()) {
				personnage.setId(rs.getInt(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

}
