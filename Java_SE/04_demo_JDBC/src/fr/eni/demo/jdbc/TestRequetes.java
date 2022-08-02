package fr.eni.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.demo.jdbc.bo.Stagiaire;

public class TestRequetes {

	static String url = "jdbc:sqlserver://localhost:1433;databasename=EVAL_DB";
	static String user = "sa";
	static String pwd = "Pa$$w0rd";
	
	public static void main(String[] args) {
		
		/*
		 * SELECT 
		 */
		List<Stagiaire> stagiaires = selectAll();
		System.out.println(stagiaires);
		
		/*
		 * INSERT
		 */
		insertStagiaire();
	}

	private static List<Stagiaire> selectAll() {
		final String SELECT = "SELECT * FROM Stagiaires";
		List<Stagiaire> stagiaires = new ArrayList<Stagiaire>();
		//1. connexion
		try(Connection cnx = DriverManager.getConnection(url, user, pwd)) {
			
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

	private static void insertStagiaire() {
		String nomNouveauStagiaire = "Titgoutte";
		String prenomNouveauStagiaire = "Justine";
		String emailNouveauStagiaire = "justine@gmail.com";
		String pwdNouveauStagiaire = "ABCD";
		
		final String INSERT = "INSERT INTO Stagiaires(prenom, nom, email, password) VALUES (?, ?, ?, ?)";
		
		//1. connexion
		try(Connection cnx = DriverManager.getConnection(url, user, pwd)) {
			//2. requ�te
			//pas obligatoire : Statement.RETURN_GENERATED_KEYS : permet de r�cup�rer les cl�s primaires g�n�r�es
			PreparedStatement pStmt = cnx.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, prenomNouveauStagiaire);
			pStmt.setString(2, nomNouveauStagiaire);
			pStmt.setString(3, emailNouveauStagiaire);
			pStmt.setString(4, pwdNouveauStagiaire);
			
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
