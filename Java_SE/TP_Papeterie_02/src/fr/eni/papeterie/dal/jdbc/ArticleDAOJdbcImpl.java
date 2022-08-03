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

	private final static String url = "jdbc:sqlserver://localhost:1433;databasename=PAPETERIE_DB";
	private final static String user = "sa";
	private final static String pwd = "Pa$$w0rd";
		
	//INSERT
	public void insert(Article article) throws DALException{
		//String des requetes
		final String INSERT_STYLO = "INSERT INTO Articles (reference, marque,  designation, prixUnitaire, qteStock, couleur, type) VALUES(?,?,?,?,?,?,'Stylo')";
		final String INSERT_RAMETTE = "INSERT INTO Articles (marque, reference, designation, prixUnitaire, qteStock, grammage, type) VALUES(?,?,?,?,?,?,'Ramette')";
		// 1. connexion
		try (Connection cnx = DriverManager.getConnection(url, user, pwd)) {
			// 2. requete
			// pas obligatoire : Statement.RETURN_GENERATED_KEYS : permet de recuperer les
			// cles primaires generees
			PreparedStatement pStmt = null;
			//prepareStatement en fonction du type d'objet à inserer
			if (article instanceof Stylo) {
				pStmt = cnx.prepareStatement(INSERT_STYLO, Statement.RETURN_GENERATED_KEYS);
			} else {
				pStmt = cnx.prepareStatement(INSERT_RAMETTE, Statement.RETURN_GENERATED_KEYS);
			}
			//associe "?" de la requete à valeurs
			pStmt.setNString(1, article.getReference());
			pStmt.setNString(2, article.getMarque());
			pStmt.setNString(3, article.getDesignation());
			pStmt.setFloat(4, article.getPrixUnitaire());
			pStmt.setInt(5, article.getQteStock());
			//modifie la valeur en fonction de l'instance de Article
			if (article instanceof Stylo) {
				pStmt.setNString(6, ((Stylo) article).getCouleur());
			} else {
				pStmt.setInt(6, ((Ramette) article).getGrammage());
			}
			// 3. resultat
			
			//execution
			pStmt.executeUpdate();
			//recupere cles primaires
			ResultSet rs = pStmt.getGeneratedKeys();
			//insere cles primaires dans idArticle de l'objet article
			while(rs.next()) {
				int idArticle = rs.getInt(1);
				article.setIdArticle(idArticle);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//SELECT BY ID
	public Article selectById(int idArticle) throws DALException{
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
	
	//SELECT BY ID
	public List<Article> selectAll() throws DALException{
			List<Article> list = new ArrayList<>();	
			Article article = null;
			final String SELECT = "SELECT * FROM Articles";
			
			// 1. connexion
			try (Connection cnx = DriverManager.getConnection(url, user, pwd)) {
				
				Statement Stmt = cnx.createStatement();
				
				ResultSet rs = Stmt.executeQuery(SELECT);
				
				while(rs.next()) {
					int idArticle = rs.getInt("idArticle");
					String reference = rs.getString("reference");
					String marque = rs.getString("marque");
					String designation = rs.getString("designation");
					float prixUnitaire = rs.getFloat("prixUnitaire");
					int qteStock = rs.getInt("qteStock");
					String couleur = rs.getString("couleur");
					int grammage = rs.getInt("grammage");
					String type = rs.getString("type");
					if(type.trim().equalsIgnoreCase("Stylo")) {
						article = new Stylo(idArticle, reference, marque, designation, prixUnitaire, qteStock, couleur);
					}else {
						article =  new Ramette(idArticle, reference, marque, designation, prixUnitaire, qteStock, grammage);
					}
					list.add(article);		
				}		
			} catch (SQLException e) {
				e.printStackTrace();		
		}
			return list;
	}
	
	//DELETE
	public void delete(int idArticle) throws DALException{
		final String SELECT = "DELETE  FROM Articles WHERE idArticle = ?";
		// 1. connexion
		try (Connection cnx = DriverManager.getConnection(url, user, pwd)) {	
			PreparedStatement pStmt = cnx.prepareStatement(SELECT);
			pStmt.setInt(1, idArticle);
			pStmt.executeUpdate();
		} catch (SQLException e) {
				e.printStackTrace();		
		}
	}

	//UPDATE
	public void update(Article article)throws DALException {
		final String UPDATE_STYLO = "UPDATE Articles SET marque=?,reference=?,  designation=?, prixUnitaire=?, qteStock=?, couleur=? WHERE idArticle = ?";
		final String UPDATE_RAMETTE = "UPDATE Articles SET  marque=?, reference=?,, designation=?, prixUnitaire=?, qteStock=?, grammage=? WHERE idArticle = ?";	
		// 1. connexion
		try (Connection cnx = DriverManager.getConnection(url, user, pwd)) {
			PreparedStatement pStmt = null;
			if (article instanceof Stylo) {
				pStmt = cnx.prepareStatement(UPDATE_STYLO);
			} else {
				pStmt = cnx.prepareStatement(UPDATE_RAMETTE);
			}
			pStmt.setNString(1, article.getReference());
			pStmt.setNString(2, article.getMarque());					
			pStmt.setNString(3, article.getDesignation());
			pStmt.setFloat(4, article.getPrixUnitaire());
			pStmt.setInt(5, article.getQteStock());

			if (article instanceof Stylo) {
				pStmt.setNString(6, ((Stylo) article).getCouleur());
			} else {
				pStmt.setInt(6, ((Ramette) article).getGrammage());
			}
			pStmt.setInt(7, article.getIdArticle());
			
			pStmt.executeUpdate();

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}


	
