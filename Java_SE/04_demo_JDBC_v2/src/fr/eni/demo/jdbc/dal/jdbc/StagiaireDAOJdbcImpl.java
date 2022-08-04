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
			
			//2. requête
			Statement stmt = cnx.createStatement();
			
			//3. résultat
			ResultSet rs = stmt.executeQuery(SELECT);
			
			//4. on parcourt le résultat
			while(rs.next()) {
				//4.1 récupère les valeurs de tous les champs
				int idStagiaire = rs.getInt("idStagiaire");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email = rs.getString("email");
				String password = rs.getString("password");
				//4.2 crée l'instance du Stagiaire
				Stagiaire s = new Stagiaire(idStagiaire, nom, prenom, email, password);
				//4.3 l'ajoute à la liste
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
			//2. requête
			//pas obligatoire : Statement.RETURN_GENERATED_KEYS : permet de récupérer les clés primaires générées
			PreparedStatement pStmt = cnx.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, stagiaire.getPrenom());
			pStmt.setString(2, stagiaire.getNom());
			pStmt.setString(3, stagiaire.getEmail());
			pStmt.setString(4, stagiaire.getPassword());
			
			//3. résultat
			int nbLignesInserees = pStmt.executeUpdate();
			System.out.println("Nb de lignes insérées : " + nbLignesInserees);
			
			//4. facultatif : récupération des clés primaires
			ResultSet rs = pStmt.getGeneratedKeys();
			if(rs.next()) { //if si 1 seule valeur insérée (sinon while)
				int idNouveauStagiaire = rs.getInt(1);
				System.out.println("idNouveauStagiaire: " + idNouveauStagiaire);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
