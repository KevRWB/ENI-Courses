package fr.eni.tpGestionListesCourses.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.tpGestionListesCourses.BusinessException;
import fr.eni.tpGestionListesCourses.bo.Article;
import fr.eni.tpGestionListesCourses.bo.Liste;


public class ListesCourseDAOJdbcImpl implements ListesCourseDAO {

	private final String SELECT_ALL = "SELECT l.ID as ID, l.NOM as NOM_LISTE, a.NOM as NOM_ARTICLE FROM LISTES l JOIN ARTICLES a ON l.ID = a.ID_LISTE";
	private final String DELETE_LIST = "DELETE FROM LISTES WHERE ID = ?";
	private final String DELETE_ARTICLE = "DELETE FROM ARTICLES WHERE NOM = ?";
	
	@Override
	public void insertList(Liste liste) throws BusinessException {

	}

	@Override
	public List<Liste> selectList() throws BusinessException {
		
		List<Liste> listeListes = new ArrayList<>();
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{	
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			Liste listeCourante=new Liste();
			while(rs.next())
			{
				if(rs.getInt("ID")!= listeCourante.getIdListe())
				{
					listeCourante = listBuilder(rs);
					listeListes.add(listeCourante);
				}
				Article article = articleBuilder(rs);
				listeCourante.getListeArticles().add(article);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.LECTURE_REPAS_ECHEC);
			throw businessException;
		}
		return listeListes;
	}



	@Override
	public void deleteList(int idListe) throws BusinessException {

		try(Connection cnx = ConnectionProvider.getConnection())
		{	
			PreparedStatement pstmt = cnx.prepareStatement(DELETE_LIST);
			pstmt.setInt(1, idListe);
			pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.LECTURE_REPAS_ECHEC);
			throw businessException;
		}
		
	}

	@Override
	public void deleteArticle(String nomArticle) throws BusinessException {
		try(Connection cnx = ConnectionProvider.getConnection())
		{	
			PreparedStatement pstmt = cnx.prepareStatement(DELETE_ARTICLE);
			pstmt.setString(1, nomArticle);
			pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.LECTURE_REPAS_ECHEC);
			throw businessException;
		}
		
		
	}
	
	//---BUILDERS
	private Liste listBuilder(ResultSet rs) throws SQLException {
		Liste liste = new Liste();
		liste.setIdListe(rs.getInt("ID"));
		liste.setNom(rs.getString("NOM_LISTE"));
		return liste;
	}

	private Article articleBuilder(ResultSet rs) throws SQLException {
		Article article = new Article();
		article.setNom(rs.getString("NOM_ARTICLE"));
		return article;
	}



}
