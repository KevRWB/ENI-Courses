/**
 * 
 */
package fr.eni.blagues.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.eni.blagues.bo.Blague;
import fr.eni.blagues.dal.BlaguesDAO;

public class BlaguesDAOJdbcImpl implements BlaguesDAO {
	
	private final static String INSERT = "INSERT INTO Blagues(libelle) VALUES(?)";
	
	private final static String SELECT_ALL = "SELECT * FROM Blagues";
	
	private final static String SELECT_TOP_1 = "SELECT TOP 1 * FROM Blagues ORDER BY NEWID()";
	
	private final static String UPDATE = "UPDATE Blagues\r\n"
			+ "SET note = (SELECT ((note * nombreNote) + ?) / (nombreNote + 1)\r\n"
			+ "			FROM Blagues\r\n"
			+ "			WHERE id = ?),\r\n"
			+ "	nombreNote = nombreNote + 1\r\n"
			+ "WHERE id = ?;";

	
	//MAP METHOD
	private Blague map(ResultSet rs) throws SQLException {
		Blague blague = null;
		
		int idBlague = rs.getInt("id");
		String libelle = rs.getString("libelle");
		float note = rs.getInt("note");
		int nbNotes = rs.getInt("nombreNote");
		
		blague = new Blague(libelle, note, nbNotes);
		
		return blague;
	}
	
	@Override
	public void insert(Blague blague) throws fr.eni.blagues.dal.DALException {
		//1. connexion
		try(Connection cnx = JdbcTools.getConnection()) {
			//2. requ�te
			PreparedStatement pStmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, blague.getTxtBlague());
		
			pStmt.executeUpdate();
			
			//3. clé primaire
			ResultSet rs = pStmt.getGeneratedKeys();
			if(rs.next()) {
				int idArticle = rs.getInt(1); //premi�re colonne de l'enregistrement
				blague.setIdBlague(idArticle);
			}		
		} catch (SQLException e) {
			e.printStackTrace();		
		}		
	}

	@Override
	public List<Blague> selectAll() throws fr.eni.blagues.dal.DALException {
		return null;
	}

	@Override
	public Blague selectTopUn() throws fr.eni.blagues.dal.DALException {
		Blague blague = null;

		try (Connection cnx = JdbcTools.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(SELECT_TOP_1);

			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				blague = map(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("coucou");
		return blague;
	}

	@Override
	public void update(Blague blague) throws fr.eni.blagues.dal.DALException {
		try(Connection cnx = JdbcTools.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(UPDATE);
			
			pStmt.setFloat(1, blague.getNote());
			pStmt.setInt(2, blague.getIdBlague());
			pStmt.setInt(3, blague.getIdBlague());
			
			pStmt.executeUpdate();	
			System.out.println(blague.getTxtBlague());
			System.out.println("ID " + blague.getIdBlague());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
}
