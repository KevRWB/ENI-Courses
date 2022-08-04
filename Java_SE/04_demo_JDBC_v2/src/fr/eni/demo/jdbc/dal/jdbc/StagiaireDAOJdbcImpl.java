package fr.eni.demo.jdbc.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.demo.jdbc.bo.Stagiaire;
import fr.eni.demo.jdbc.dal.StagiaireDAO;

public class StagiaireDAOJdbcImpl implements StagiaireDAO {

	@Override
	public List<Stagiaire> selectAll() {
		final String SELECT = "SELECT * FROM Stagiaires";
		List<Stagiaire> stagiaires = new ArrayList<Stagiaire>();
		//1. connexion
		try(Connection cnx = JdbcTools.getConnection()) {
			
			//2. requ�te
			Statement stmt = cnx.createStatement();
			
			//3. r�sultat
			ResultSet rs = stmt.executeQuery(SELECT);
			
			//4. on parcourt le r�sultat
			while(rs.next()) {
				//4.1 r�cup�re les valeurs de tous les champs
				int idStagiaire = rs.getInt("idStagiaire");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email = rs.getString("email");
				String password = rs.getString("password");
				//4.2 cr�e l'instance du Stagiaire
				Stagiaire s = new Stagiaire(idStagiaire, nom, prenom, email, password);
				//4.3 l'ajoute � la liste
				stagiaires.add(s);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stagiaires;
	}

	@Override
	public void insertStagiaire(Stagiaire stagiaire) {
		
		final String INSERT = "INSERT INTO Stagiaires(prenom, nom, email, password) VALUES (?, ?, ?, ?)";
		
		//1. connexion
		try(Connection cnx = JdbcTools.getConnection()) {
			//2. requ�te
			//pas obligatoire : Statement.RETURN_GENERATED_KEYS : permet de r�cup�rer les cl�s primaires g�n�r�es
			PreparedStatement pStmt = cnx.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, stagiaire.getPrenom());
			pStmt.setString(2, stagiaire.getNom());
			pStmt.setString(3, stagiaire.getEmail());
			pStmt.setString(4, stagiaire.getPassword());
			
			//3. r�sultat
			int nbLignesInserees = pStmt.executeUpdate();
			System.out.println("Nb de lignes ins�r�es : " + nbLignesInserees);
			
			//4. facultatif : r�cup�ration des cl�s primaires
			ResultSet rs = pStmt.getGeneratedKeys();
			if(rs.next()) { //if si 1 seule valeur ins�r�e (sinon while)
				int idNouveauStagiaire = rs.getInt(1);
				System.out.println("idNouveauStagiaire: " + idNouveauStagiaire);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
