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
import java.sql.Types;
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
	
	private final static String INSERT = "INSERT INTO Articles(reference, marque, designation, prixUnitaire, qteStock, grammage, couleur, type) VALUES(?,?,?,?,?,?,?,?)";
	
	private final static String SELECT_BY_ID = "SELECT * FROM Articles WHERE idArticle=?";
	
	private final static String SELECT_ALL = "SELECT * FROM Articles";
	
	private final static String UPDATE = "UPDATE Articles SET couleur=?, designation=?, reference=? WHERE idArticle=?";
	
	public void insert(Article article) throws DALException {
		//1. connexion
		try(Connection cnx = DriverManager.getConnection(url, user, pwd)) {
			//2. requ�te
			PreparedStatement pStmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, article.getReference());
			pStmt.setString(2, article.getMarque());
			pStmt.setString(3, article.getDesignation());
			pStmt.setFloat(4, article.getPrixUnitaire());
			pStmt.setInt(5, article.getQteStock());
			
			if(article instanceof Ramette) {
				pStmt.setInt(6, ((Ramette) article).getGrammage());
				pStmt.setNull(7, Types.NVARCHAR);
			} else if(article instanceof Stylo) {
				pStmt.setNull(6, Types.INTEGER);
				pStmt.setString(7, ((Stylo) article).getCouleur());
			}
			
			//getSimpleName() : renvoie le nom de la classe (Stylo ou Ramette)
			pStmt.setString(8, article.getClass().getSimpleName());
			
			pStmt.executeUpdate();
			
			//3. cl� primaire
			ResultSet rs = pStmt.getGeneratedKeys();
			if(rs.next()) {
				int idArticle = rs.getInt(1); //premi�re colonne de l'enregistrement
				article.setIdArticle(idArticle);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	}

	public Article selectById(int idArticle) throws DALException {
		Article article = null;
		
		try(Connection cnx = DriverManager.getConnection(url, user, pwd)) {
			PreparedStatement pStmt = cnx.prepareStatement(SELECT_BY_ID);
			pStmt.setInt(1, idArticle);
			
			ResultSet rs = pStmt.executeQuery();
			if(rs.next()) {
				article = map(rs);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return article;
	}

	/**
	 * Converti une ligne d'enregistrement en objet (Article)
	 * @param rs Une ligne d'enregistrement
	 * @return L'Article cr�� � partir des donn�es de l'enregistrement
	 * @throws SQLException
	 */
	private Article map(ResultSet rs) throws SQLException {
		Article article;
		
		int idArticle = rs.getInt("idArticle");
		String reference = rs.getString("reference");
		String marque = rs.getString("marque");
		String designation = rs.getString("designation");
		float prixUnitaire = rs.getFloat("prixUnitaire");
		int qteStock = rs.getInt("qteStock");
		//trim : enl�ve les espaces � la fin (� cause du type nchar dans la BDD)
		String type = rs.getString("type").trim();
		
		//Ramette.class.getSimpleName() : renvoie "Ramette"
		if(type.equalsIgnoreCase(Ramette.class.getSimpleName())) {
			int grammage = rs.getInt("grammage");
			article = new Ramette(idArticle, reference, marque, designation, prixUnitaire, qteStock, grammage);
		} else {
			String couleur = rs.getString("couleur");
			article = new Stylo(idArticle, reference, marque, designation, prixUnitaire, qteStock, couleur);
		}
		
		return article;
	}
	
	public void update(Article article) throws DALException {
		try(Connection cnx = DriverManager.getConnection(url, user, pwd)) {
			PreparedStatement pStmt = cnx.prepareStatement(UPDATE);
			
			if(article instanceof Stylo) {
				pStmt.setString(1, ((Stylo) article).getCouleur());
			} else {
				pStmt.setNull(1, Types.VARCHAR);
			}
			
			pStmt.setString(2, article.getDesignation());
			pStmt.setString(3, article.getReference());
			pStmt.setInt(4, article.getIdArticle());
			
			pStmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(int idArticle) throws DALException {
		final String DELETE = "DELETE FROM Articles WHERE idArticle=?";
		
		try(Connection cnx = DriverManager.getConnection(url, user, pwd)) {
			PreparedStatement pStmt = cnx.prepareStatement(DELETE);
			pStmt.setInt(1, idArticle);
			
			pStmt.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	}

	public List<Article> selectAll() throws DALException {
		List<Article> articles = new ArrayList<Article>();
		
		try(Connection cnx = DriverManager.getConnection(url, user, pwd)) {
			Statement stmt = cnx.createStatement();
			
			ResultSet rs = stmt.executeQuery(SELECT_ALL);
			while(rs.next()) {
				Article a = map(rs); //transforme une ligne d'enregistrement en objet
				articles.add(a); //ajoute l'objet � la liste
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return articles;
	}


}
