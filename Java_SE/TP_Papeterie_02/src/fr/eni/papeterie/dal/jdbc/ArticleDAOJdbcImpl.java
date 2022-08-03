/**
 * 
 */
package fr.eni.papeterie.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;
import fr.eni.papeterie.dal.DALException;

/**
 * @author Eni Ecole
 * 
 */
public class ArticleDAOJdbcImpl {

	static String url = "jdbc:sqlserver://localhost:1433;databasename=PAPETERIE_DB";
	static String user = "sa";
	static String pwd = "Pa$$w0rd";
	
	
	//MEthod insert
	public void insert(Article article) {
		final String INSERT_STYLO = "INSERT INTO Articles (reference, marque,  designation, prixUnitaire, qteStock, couleur, type) VALUES(?,?,?,?,?,?,?)";
		final String INSERT_RAMETTE = "INSERT INTO Articles (marque, reference, designation, prixUnitaire, qteStock, grammage, type) VALUES(?,?,?,?,?,?,?)";

		// 1. connexion
		try (Connection cnx = DriverManager.getConnection(url, user, pwd)) {
			// 2. requ�te
			// pas obligatoire : Statement.RETURN_GENERATED_KEYS : permet de r�cup�rer les
			// cl�s primaires g�n�r�es
			PreparedStatement pStmt = null;
			if (article instanceof Stylo) {
				pStmt = cnx.prepareStatement(INSERT_STYLO, Statement.RETURN_GENERATED_KEYS);
			} else {
				pStmt = cnx.prepareStatement(INSERT_RAMETTE, Statement.RETURN_GENERATED_KEYS);
			}
			pStmt.setNString(1, article.getReference());
			pStmt.setNString(2, article.getMarque());
			pStmt.setNString(3, article.getDesignation());
			pStmt.setFloat(4, article.getPrixUnitaire());
			pStmt.setInt(5, article.getQteStock());

			if (article instanceof Stylo) {
				pStmt.setNString(6, ((Stylo) article).getCouleur());
				pStmt.setNString(7, "Stylo");
			} else {
				pStmt.setInt(6, ((Ramette) article).getGrammage());
				pStmt.setString(7, "Ramette");
			}
			// 3. r�sultat
			int nbLignesInserees = pStmt.executeUpdate();
			System.out.println("Nb de lignes ins�r�es : " + nbLignesInserees);
			
			ResultSet rs = pStmt.getGeneratedKeys();
			while(rs.next()) {
				int idArticle = rs.getInt(1);
				article.setIdArticle(idArticle);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	//MEthod select by id
	public Article selectById(int idArticle) {
		Article article = null;
		final String SELECT = "SELECT * FROM Articles WHERE idArticle = ?";
		
		// 1. connexion
		try (Connection cnx = DriverManager.getConnection(url, user, pwd)) {
			
			PreparedStatement pStmt = cnx.prepareStatement(SELECT , Statement.RETURN_GENERATED_KEYS);
			pStmt.setInt(1, idArticle);
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				int idArticle1 = rs.getInt(1);
				String reference = rs.getString("reference");
				String marque = rs.getString("marque");
				String designation = rs.getString("designation");
				float prixUnitaire = rs.getFloat("prixUnitaire");
				int qteStock = rs.getInt("qteStock");
				String couleur = rs.getString("couleur");
				int grammage = rs.getInt("grammage");
				String type = rs.getString("type");
				if(type == "Stylo") {
					article = new Stylo(idArticle1, reference, marque, designation, prixUnitaire, qteStock, couleur);
				}else {
					article =  new Ramette(idArticle1, reference, marque, designation, prixUnitaire, qteStock, grammage);
				}		
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return article;	
		}
	
	//MEthod select by id
		public List<Article> selectAll() {
			List<Article> list = new ArrayList<>();	
			Article article = null;
			final String SELECT = "SELECT * FROM Articles";
			
			// 1. connexion
			try (Connection cnx = DriverManager.getConnection(url, user, pwd)) {
				
				Statement Stmt = cnx.createStatement();
				
				ResultSet rs = Stmt.executeQuery(SELECT);
				
				while(rs.next()) {
					String reference = rs.getString("reference");
					String marque = rs.getString("marque");
					String designation = rs.getString("designation");
					float prixUnitaire = rs.getFloat("prixUnitaire");
					int qteStock = rs.getInt("qteStock");
					String couleur = rs.getString("couleur");
					int grammage = rs.getInt("grammage");
					String type = rs.getString("type");
					if(type.trim().equalsIgnoreCase("Stylo")) {
						article = new Stylo(reference, marque, designation, prixUnitaire, qteStock, couleur);
					}else {
						article =  new Ramette(reference, marque, designation, prixUnitaire, qteStock, grammage);
					}
					
					list.add(article);
					
					
				}		
			} catch (SQLException e) {
				e.printStackTrace();
				
		}
			return list;
	}
}

	
